package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.domain.CharacterData;
import org.jmangos.realm.domain.InventoryItem;
import org.jmangos.realm.domain.PlayerHomeBindData;
import org.jmangos.realm.domain.Playercreateinfo;
import org.jmangos.realm.domain.PlayercreateinfoPK;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Races;
import org.jmangos.realm.model.player.CharacterStartOutfit;
import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CREATE;
import org.jmangos.realm.service.DBCStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.07. Time: 23:26 To change this template use
 * File | Settings | File Templates.
 */
@Component
public class CMSG_CHAR_CREATE extends AbstractWoWClientPacket {
    
    Logger                       log = LoggerFactory.getLogger(getClass());
    
    @Inject
    private DatabaseFactory      databaseFactory;
    
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender sender;
    
    @Inject
    private DBCStorage           dbcStorage;
    
    String                       charName;
    Integer                      charRace;
    Integer                      charClass;
    Integer                      gender, skin, face, hairStyle, hairColor, facialHair, outfitId;
    
    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        this.charName = readS();
        this.charRace = readC();
        this.charClass = readC();
        
        this.gender = readC();
        this.skin = readC();
        this.face = readC();
        this.hairStyle = readC();
        this.hairColor = readC();
        this.facialHair = readC();
        this.outfitId = readC();
        
        this.log.info(String.format("PlayerCreate: [%s] Race: %d, Class: %d", this.charName, this.charRace, this.charClass));
        skipAll();
    }
    
    @Override
    protected void runImpl() {
    
        final Session session = this.databaseFactory.getCharactersSessionFactory().openSession();
        
        final Query query = session.createQuery("from CharacterData where name = :name").setString("name", this.charName);
        if (query.list().size() != 0) {
            this.log.warn("Username already exists: " + this.charName);
            this.sender.send(getClient(), new SMSG_CHAR_CREATE(SMSG_CHAR_CREATE.CharCreateCodes.NAME_IN_USE));
            return;
        }
        
        final Session worldSession = this.databaseFactory.getWorldSessionFactory().openSession();
        final Playercreateinfo info = (Playercreateinfo) worldSession.get(Playercreateinfo.class, new PlayercreateinfoPK(this.charClass, this.charRace));
        
        if (info == null) {
            this.log.error("Player create template not found for: " + Classes.get(this.charClass) + " " + Races.get(this.charRace));
            this.sender.send(getClient(), new SMSG_CHAR_CREATE(SMSG_CHAR_CREATE.CharCreateCodes.ERROR));
            return;
        }
        
        final CharacterData charData = new CharacterData();
        // Set account id
        charData.setAccount((int) getAccountInfo().getId());
        
        // Set name
        charData.setName(this.charName);
        
        // Set Class/Race/Gender
        charData.setClazz(Classes.get(this.charClass));
        charData.setRace(Races.get(this.charRace));
        charData.setGender(this.gender);
        
        // Set spawn coord
        charData.setMap(info.getMap());
        charData.setZone(info.getZone());
        charData.setPositionX(info.getPositionX());
        charData.setPositionY(info.getPositionY());
        charData.setPositionZ(info.getPositionZ());
        charData.setOrientation(info.getOrientation());
        
        // Skin, Face, Hair(style,color)
        charData.setPlayerBytes((this.skin | (this.face << 8) | (this.hairStyle << 16) | (this.hairColor << 24)));
        
        // Hair(facial), Bankslot
        charData.setPlayerBytes2((this.facialHair /* | (0xEE << 8) */| (0x02 << 24)));
        
        charData.setExploredZones(Integer.toString(info.getZone()));
        charData.setKnownTitles("0");
        
        // TODO: make a config to create some inital value
        charData.setMoney(0);
        charData.setLevel(1);
        charData.setXp(0);
        
        // First login
        charData.setAtLoginFlags(0x1);
        
        // Set home (hs) location
        final PlayerHomeBindData phbd = new PlayerHomeBindData();
        phbd.setHomeBindAreaId(charData.getZone());
        phbd.setHomeBindMapId(charData.getMap());
        phbd.setHomeBindPositionX(charData.getPositionX());
        phbd.setHomeBindPositionY(charData.getPositionY());
        phbd.setHomeBindPositionZ(charData.getPositionZ());
        
        charData.setHomeBindData(phbd);
        
        // Inventory items
        final Iterator<CharacterStartOutfit> outfitItr = this.dbcStorage.getOutfitEntries().iterator();
        CharacterStartOutfit startOutfit = null;
        while (outfitItr.hasNext()) {
            startOutfit = outfitItr.next();
            if ((startOutfit.clazz == this.charClass) && (startOutfit.gender == this.gender) && (startOutfit.race == this.charRace)) {
                break;
            }
            startOutfit = null;
        }
        
        session.getTransaction().begin();
        
        try {
            session.save(charData);
            
            final Iterator<CharacterStartOutfit.ItemSlot> itr = startOutfit.getItems().iterator();
            while (itr.hasNext()) {
                final CharacterStartOutfit.ItemSlot item = itr.next();
                final InventoryItem inventoryItem = new InventoryItem(item.getItemId(), item.getInventorySlot());
                charData.getInventory().add(inventoryItem);
                this.log.info("Adding item for character: " + item.getItemId() + " SlotId: " + item.getInventorySlot());
            }
            
            session.getTransaction().commit();
        } catch (final Exception e) {
            session.getTransaction().rollback();
            this.log.error("Error while creating character: " + Classes.get(this.charClass) + " " + Races.get(this.charRace), e);
            this.sender.send(getClient(), new SMSG_CHAR_CREATE(SMSG_CHAR_CREATE.CharCreateCodes.ERROR));
            return;
        }
        
        // Send SUCCESS
        this.sender.send(getClient(), new SMSG_CHAR_CREATE());
    }
}
