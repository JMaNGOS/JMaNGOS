package org.jmangos.realm.network.netty.packetClient.client;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.model.Classes;
import org.jmangos.realm.model.InventoryItem;
import org.jmangos.realm.model.Races;
import org.jmangos.realm.model.base.Playercreateinfo;
import org.jmangos.realm.model.base.PlayercreateinfoPK;
import org.jmangos.realm.model.base.character.CharacterData;
import org.jmangos.realm.model.player.CharacterStartOutfit;
import org.jmangos.realm.model.player.PlayerHomeBindData;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_CHAR_CREATE;
import org.jmangos.realm.service.DBCStorage;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.BufferUnderflowException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.07.
 * Time: 23:26
 * To change this template use File | Settings | File Templates.
 */
public class CMSG_CHAR_CREATE extends AbstractWoWClientPacket {
    Logger log = Logger.getLogger( getClass() );

    @Inject
    @Named("client")
    private AbstractPacketSender sender;

    @Inject
    private DBCStorage dbcStorage;

    String charName;
    Integer charRace;
    Integer charClass;
    Integer gender, skin, face, hairStyle, hairColor, facialHair, outfitId;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        charName = readS();
        charRace = readC();
        charClass = readC();

        gender = readC();
        skin = readC();
        face = readC();
        hairStyle = readC();
        hairColor = readC();
        facialHair = readC();
        outfitId = readC();

        log.info( String.format("PlayerCreate: [%s] Race: %d, Class: %d", charName, charRace, charClass) );
        skipAll();
    }

    @Override
    protected void runImpl() {
        Session session = DatabaseFactory.getCharactersSessionFactory().openSession();

        Query query = session.createQuery( "from CharacterData where name = :name" ).setString( "name", charName );
        if ( query.list().size() != 0 ) {
            log.warn( "Username already exists: " + charName );
            sender.send( getClient(), new SMSG_CHAR_CREATE( SMSG_CHAR_CREATE.CharCreateCodes.NAME_IN_USE ) );
            return;
        }


        Session worldSession = DatabaseFactory.getWorldSessionFactory().openSession();
        Playercreateinfo info = (Playercreateinfo)worldSession.get( Playercreateinfo.class, new PlayercreateinfoPK( charClass,charRace ) );

        if ( info == null ) {
            log.fatal( "Player create template not found for: " + Classes.get( charClass ) + " " + Races.get( charRace ) );
            sender.send( getClient(), new SMSG_CHAR_CREATE( SMSG_CHAR_CREATE.CharCreateCodes.ERROR ) );
            return;
        }

        CharacterData charData = new CharacterData();
        // Set account id
        charData.setAccount( getAccount().getId() );

        // Set name
        charData.setName( charName );

        // Set Class/Race/Gender
        charData.setClazz( Classes.get( charClass ) );
        charData.setRace( Races.get( charRace ) );
        charData.setGender( gender );

        // Set spawn coord
        charData.setMap( info.getMap() );
        charData.setZone( info.getZone() );
        charData.setPositionX( info.getPositionX() );
        charData.setPositionY(info.getPositionY());
        charData.setPositionZ(info.getPositionZ());
        charData.setOrientation( info.getOrientation() );

        // Skin, Face, Hair(style,color)
        charData.setPlayerBytes( ( skin | ( face << 8 ) | ( hairStyle << 16 ) | ( hairColor << 24) ) );

        // Hair(facial), Bankslot
        charData.setPlayerBytes2( ( facialHair /*| (0xEE << 8)*/  | ( 0x02 << 24 ) ) );

        charData.setExploredZones( Integer.toString( info.getZone() ) );
        charData.setKnownTitles( "0" );

        // TODO: make a config to create some inital value
        charData.setMoney( 0 );
        charData.setLevel( 1 );
        charData.setXp( 0 );

        // First login
        charData.setAtLoginFlags( 0x1 );

        // Set home (hs) location
        PlayerHomeBindData phbd = new PlayerHomeBindData();
        phbd.setHomeBindAreaId( charData.getZone() );
        phbd.setHomeBindMapId( charData.getMap() );
        phbd.setHomeBindPositionX( charData.getPositionX() );
        phbd.setHomeBindPositionY( charData.getPositionY() );
        phbd.setHomeBindPositionZ( charData.getPositionZ() );

        charData.setHomeBindData( phbd );

        // Inventory items
        Iterator<CharacterStartOutfit> outfitItr = dbcStorage.getOutfitEntries().iterator();
        CharacterStartOutfit startOutfit = null;
        while (outfitItr.hasNext()) {
            startOutfit = outfitItr.next();
            if( (startOutfit.clazz == charClass) && (startOutfit.gender == gender) && (startOutfit.race == charRace) ) {
                break;
            }
            startOutfit = null;
        }

        session.getTransaction().begin();

        try {
            session.save(charData);

            Iterator<CharacterStartOutfit.ItemSlot> itr = startOutfit.getItems().iterator();
            while ( itr.hasNext() ) {
                CharacterStartOutfit.ItemSlot item = itr.next();
                InventoryItem inventoryItem = new InventoryItem( item.getItemId(), item.getInventorySlot() );
                charData.getInventory().add(inventoryItem);
                log.info( "Adding item for character: " + item.getItemId() + " SlotId: " + item.getInventorySlot() );
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.fatal( "Error while creating character: " + Classes.get( charClass ) + " " + Races.get( charRace ), e );
            sender.send( getClient(), new SMSG_CHAR_CREATE( SMSG_CHAR_CREATE.CharCreateCodes.ERROR ) );
            return;
        }

        // Send SUCCESS
        sender.send( getClient(), new SMSG_CHAR_CREATE() );
    }
}
