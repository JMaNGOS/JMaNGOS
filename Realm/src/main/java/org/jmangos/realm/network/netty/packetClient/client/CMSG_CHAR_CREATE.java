package org.jmangos.realm.network.netty.packetClient.client;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.model.Classes;
import org.jmangos.realm.model.Races;
import org.jmangos.realm.model.base.Playercreateinfo;
import org.jmangos.realm.model.base.PlayercreateinfoPK;
import org.jmangos.realm.model.base.character.CharacterData;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket;
import org.jmangos.realm.network.netty.packetClient.server.SMSG_CHAR_CREATE;

import javax.inject.Inject;
import javax.inject.Named;
import java.nio.BufferUnderflowException;

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

        // TODO: implement explored zones, known titles
        charData.setExploredZones( "" );
        charData.setKnownTitles("");

        // TODO: make a config to create some inital value
        charData.setMoney( 0 );
        charData.setLevel( 1 );
        charData.setXp( 0 );

        // First login
        charData.setAtLoginFlags( 0x1 );

        session.getTransaction().begin();

        try {
            session.save( charData );
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.fatal( "Error while creating character: " + Classes.get( charClass ) + " " + Races.get( charRace ) );
            sender.send( getClient(), new SMSG_CHAR_CREATE( SMSG_CHAR_CREATE.CharCreateCodes.ERROR ) );
            return;
        }

        // Send SUCCESS
        sender.send( getClient(), new SMSG_CHAR_CREATE() );
    }
}
