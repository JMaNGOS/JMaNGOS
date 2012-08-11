/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.realm.service;

import java.util.List;

import gnu.trove.map.hash.TLongObjectHashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.jmangos.commons.database.DatabaseFactory;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.netty.sender.AbstractPacketSender;
import org.jmangos.realm.RealmServer;
import org.jmangos.realm.dao.PlayerDAO;
import org.jmangos.realm.domain.Characters;
import org.jmangos.realm.model.Classes;
import org.jmangos.realm.model.InventoryTemplate;
import org.jmangos.realm.model.Races;
import org.jmangos.realm.model.account.Account;
import org.jmangos.realm.model.base.PlayerClassLevelInfo;
import org.jmangos.realm.model.base.PlayerLevelInfo;
import org.jmangos.realm.model.base.WorldObject;
import org.jmangos.realm.model.base.character.CharactersData;
import org.jmangos.realm.model.base.item.Item;
import org.jmangos.realm.model.base.item.ItemPrototype;
import org.jmangos.realm.model.base.update.PlayerFields;
import org.jmangos.realm.model.base.update.UnitFields;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.model.player.PlayerCharacterData;
import org.jmangos.realm.model.unit.Powers;
import org.jmangos.realm.model.unit.SpellSchools;
import org.jmangos.realm.model.unit.Stats;
import org.jmangos.realm.network.netty.packetClient.server.*;

/**
 * The Class PlayerService.
 */
public class PlayerService {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(PlayerService.class);
	
	/** The Constant PLAYER_EXPLORED_ZONES_SIZE. */
	private static final int PLAYER_EXPLORED_ZONES_SIZE = 128;
	
	/** The Constant KNOWN_TITLES_SIZE. */
	private static final int KNOWN_TITLES_SIZE = 3;
	
	/** The Constant CONFIG_UINT32_MAX_PLAYER_LEVEL. */
	private static final int CONFIG_UINT32_MAX_PLAYER_LEVEL = 80;
	
	/** The sender. */
	@Inject
	@Named("client")
	private AbstractPacketSender sender;

    @Inject
    private DatabaseFactory databaseFactory;

	/** The player dao. */
	@Inject
	private PlayerDAO playerDAO;
	
	/** The player class level info storages. */
	@Inject
	private PlayerClassLevelInfoStorages playerClassLevelInfoStorages;
	
	/** The player level storages. */
	@Inject
	private PlayerLevelStorages playerLevelStorages;
	
	/** The simple storages. */
	@Inject
	private SimpleStorages simpleStorages;
	
	/** The item storages. */
	@Inject
	private ItemStorages itemStorages;

	/** The playerlist. */
	private static TLongObjectHashMap<Player> playerlist = new TLongObjectHashMap<Player>();
	
	/**
	 * Prepare player.
	 *
	 * @param chanel the chanel
	 * @param guid the guid
	 * @return the player
	 */
	public Player preparePlayer(NettyNetworkChannel chanel, long guid) {
		Account curAccount = (Account) chanel.getChanneledObject();
		Player player = new Player(curAccount.getCharacterData(guid));
		player.setChannel(chanel);
		chanel.setActiveObject(player);
		return player;
	}

	/**
	 * Send inicial packets.
	 *
	 * @param player the player
	 * @return the world object
	 */
	public WorldObject sendInicialPackets(Player player) {
        byte[] taurenBytes = new byte[] {
                (byte)0x55,(byte)0x07,(byte)0x00,(byte)0x00,(byte)0x78,(byte)0x01,(byte)0x85,(byte)0x94,(byte)0x4D,(byte)0x48,(byte)0x54,(byte)0x51,(byte)0x14,(byte)0xC7,(byte)0xEF,(byte)0xBD
                ,(byte)0x33,(byte)0x3E,(byte)0x4D,(byte)0x27,(byte)0x4C,(byte)0x4B,(byte)0xAD,(byte)0x4C,(byte)0x1A,(byte)0x61,(byte)0x90,(byte)0x31,(byte)0x86,(byte)0x7A,(byte)0x19,(byte)0x25
                ,(byte)0x4A,(byte)0xE0,(byte)0x33,(byte)0xA2,(byte)0xB1,(byte)0x4D,(byte)0x24,(byte)0x54,(byte)0x20,(byte)0x06,(byte)0x13,(byte)0x11,(byte)0xED,(byte)0x06,(byte)0x91,(byte)0x16
                ,(byte)0x7D,(byte)0xAC,(byte)0xE6,(byte)0xB5,(byte)0x6D,(byte)0xD3,(byte)0xA6,(byte)0x02,(byte)0xA1,(byte)0x2F,(byte)0x97,(byte)0xED,(byte)0xDC,(byte)0x64,(byte)0x46,(byte)0x0B
                ,(byte)0x41,(byte)0xDA,(byte)0x5A,(byte)0xBB,(byte)0x82,(byte)0x88,(byte)0x8C,(byte)0x36,(byte)0x6D,(byte)0x5A,(byte)0x84,(byte)0xB4,(byte)0x1B,(byte)0xB2,(byte)0xFF,(byte)0xFF
                ,(byte)0x7E,(byte)0x30,(byte)0x77,(byte)0xDE,(byte)0x1B,(byte)0xE8,(byte)0x0D,(byte)0xE7,(byte)0x9E,(byte)0xFB,(byte)0xF5,(byte)0x9B,(byte)0x7B,(byte)0xEE,(byte)0x39,(byte)0xF7
                ,(byte)0x9C,(byte)0x7D,(byte)0x42,(byte)0x08,(byte)0x15,(byte)0xAB,(byte)0xB2,(byte)0xDC,(byte)0x23,(byte)0x44,(byte)0x19,(byte)0xDD,(byte)0xCA,(byte)0x34,(byte)0x26,(byte)0x38
                ,(byte)0x67,(byte)0x54,(byte)0x39,(byte)0x03,(byte)0xFD,(byte)0x6B,(byte)0x80,(byte)0x83,(byte)0xDA,(byte)0x94,(byte)0x44,(byte)0xEB,(byte)0x44,(byte)0xC5,(byte)0x61,(byte)0x92
                ,(byte)0x09,(byte)0x43,(byte)0x6E,(byte)0xC3,(byte)0xDF,(byte)0x90,(byte)0xB9,(byte)0xD6,(byte)0xC9,(byte)0x6E,(byte)0x33,(byte)0x33,(byte)0x8E,(byte)0x19,(byte)0x8A,(byte)0x8A
                ,(byte)0x87,(byte)0x53,(byte)0xEC,(byte)0x30,(byte)0xB7,(byte)0x5B,(byte)0x76,(byte)0xAE,(byte)0x8D,(byte)0xDD,(byte)0x66,(byte)0x16,(byte)0xE6,(byte)0x09,(byte)0x8A,(byte)0x8A
                ,(byte)0x47,(byte)0x53,(byte)0xEC,(byte)0x28,(byte)0xB7,(byte)0x5B,(byte)0xF6,(byte)0x7A,(byte)0x0B,(byte)0xF6,(byte)0x00,(byte)0x16,(byte)0x29,(byte)0x2A,(byte)0xEE,(byte)0x4D
                ,(byte)0xB1,(byte)0xBD,(byte)0x24,(byte)0x2D,(byte)0x3B,(byte)0xDF,(byte)0xC2,(byte)0x66,(byte)0xAE,(byte)0x53,(byte)0x54,(byte)0x5C,(byte)0xF0,(byte)0xD8,(byte)0x3C,(byte)0x66
                ,(byte)0x44,(byte)0x58,(byte)0x60,(byte)0x6B,(byte)0xD9,(byte)0xA3,(byte)0x7B,(byte)0xD9,(byte)0x6D,(byte)0xB6,(byte)0x99,(byte)0xBE,(byte)0x6A,(byte)0xF0,(byte)0x81,(byte)0xC7
                ,(byte)0x73,(byte)0xAF,(byte)0x08,(byte)0x03,(byte)0xAD,(byte)0x8C,(byte)0xBF,(byte)0x26,(byte)0x76,(byte)0x71,(byte)0xD0,(byte)0xCC,(byte)0x37,(byte)0xEC,(byte)0xEE,(byte)0xF0
                ,(byte)0xD8,(byte)0xBC,(byte)0xA6,(byte)0x3A,(byte)0x74,(byte)0x6B,(byte)0xD8,(byte)0xC2,(byte)0x20,(byte)0x07,(byte)0xCD,(byte)0x2C,(byte)0xCF,(byte)0x56,(byte)0x71,(byte)0xA7
                ,(byte)0xC7,(byte)0x19,(byte)0x40,(byte)0x5F,(byte)0xD1,(byte)0xDA,(byte)0xFC,(byte)0x26,(byte)0xC1,(byte)0xD1,(byte)0x75,(byte)0x2A,(byte)0xEE,(byte)0x4A,(byte)0x31,(byte)0x5D
                ,(byte)0x06,(byte)0xD5,(byte)0x71,(byte)0x7D,(byte)0xA4,(byte)0x1D,(byte)0xD6,(byte)0x38,(byte)0xCB,(byte)0x30,(byte)0x39,(byte)0x8F,(byte)0xE1,(byte)0xC9,(byte)0x42,(byte)0xE4
                ,(byte)0x3C,(byte)0x66,(byte)0xAD,(byte)0xC5,(byte)0x39,(byte)0x3B,(byte)0xF8,(byte)0x54,(byte)0x3C,(byte)0xE6,(byte)0x71,(byte)0x06,(byte)0x18,(byte)0xF3,(byte)0xB8,(byte)0xE5
                ,(byte)0x04,(byte)0xC7,(byte)0x37,(byte)0xA9,(byte)0xE2,(byte)0x49,(byte)0x8F,(byte)0xC9,(byte)0x73,(byte)0x77,(byte)0x38,(byte)0xC9,(byte)0xD6,(byte)0xDE,(byte)0xE9,(byte)0xF8
                ,(byte)0x7F,(byte)0xE3,(byte)0x30,(byte)0xEE,(byte)0xF1,(byte)0x06,(byte)0xE4,(byte)0x9B,(byte)0xC4,(byte)0xA7,(byte)0xEF,(byte)0x27,(byte)0x13,(byte)0xBC,(byte)0x39,(byte)0xB3
                ,(byte)0x3F,(byte)0xC5,(byte)0xF4,(byte)0x7B,(byte)0x4C,(byte)0xD2,(byte)0x27,(byte)0x7C,(byte)0xFF,(byte)0x2A,(byte)0x1E,(byte)0x4A,(byte)0x31,(byte)0x43,(byte)0x1E,(byte)0x93
                ,(byte)0xF4,(byte)0xBD,(byte)0x39,(byte)0x67,(byte)0x24,(byte)0xC5,(byte)0x8C,(byte)0x78,(byte)0xCC,(byte)0xCB,(byte)0x84,(byte)0x3F,(byte)0xCC,(byte)0x39,(byte)0xC5,(byte)0x14
                ,(byte)0x53,(byte)0xF4,(byte)0x98,(byte)0xA4,(byte)0x0F,(byte)0x4D,(byte)0xBC,(byte)0xB2,(byte)0x49,(byte)0x26,(byte)0xCC,(byte)0x7A,(byte)0xCC,(byte)0x03,(byte)0xDD,(byte)0x6F
                ,(byte)0xC4,(byte)0x98,(byte)0x11,(byte)0x75,(byte)0x6F,(byte)0x31,(byte)0x23,(byte)0x65,(byte)0x76,(byte)0xD1,(byte)0xEC,(byte)0x15,(byte)0x57,(byte)0xEA,(byte)0x42,(byte)0xDC
                ,(byte)0x0C,(byte)0x4E,(byte)0xBE,(byte)0x1F,(byte)0x58,(byte)0x5B,(byte)0xD8,(byte)0x38,(byte)0x7B,(byte)0xEF,(byte)0xF2,(byte)0x99,(byte)0xA5,(byte)0x95,(byte)0xFB,(byte)0x91
                ,(byte)0x59,(byte)0xCA,(byte)0x43,(byte)0x6F,(byte)0x41,(byte)0x1E,(byte)0x46,(byte)0x8B,(byte)0x87,(byte)0x9E,(byte)0x40,(byte)0x37,(byte)0xC6,(byte)0x5B,(byte)0xDD,(byte)0xE7
                ,(byte)0xA3,(byte)0x8D,(byte)0x3F,(byte)0x33,(byte)0xD1,(byte)0x31,(byte)0x6C,(byte)0x3C,(byte)0xD2,(byte)0x27,(byte)0x6A,(byte)0x3D,(byte)0x7D,(byte)0x62,(byte)0xFD,(byte)0xF3
                ,(byte)0x37,(byte)0xF1,(byte)0x5B,(byte)0xE2,(byte)0x41,(byte)0x5F,(byte)0x08,(byte)0x44,(byte)0x76,(byte)0xB3,(byte)0xC3,(byte)0xBC,(byte)0x1F,(byte)0x2C,(byte)0x9B,(byte)0xEF
                ,(byte)0x55,(byte)0x11,(byte)0xB5,(byte)0xA8,(byte)0xBE,(byte)0x8D,(byte)0x07,(byte)0x55,(byte)0xDF,(byte)0xF9,(byte)0xD0,(byte)0xED,(byte)0x66,(byte)0x5B,(byte)0xEA,(byte)0x77
                ,(byte)0xD5,(byte)0x2F,(byte)0xAF,(byte)0xAB,(byte)0x2D,(byte)0x57,(byte)0x5A,(byte)0x4F,(byte)0xE6,(byte)0x7F,(byte)0xD4,(byte)0x84,(byte)0xB2,(byte)0x17,(byte)0xB7,(byte)0x3B
                ,(byte)0x02,(byte)0xF1,(byte)0x97,(byte)0xBD,(byte)0x48,(byte)0x0F,(byte)0x6B,(byte)0x6C,(byte)0xA7,(byte)0x20,(byte)0xCE,(byte)0x01,(byte)0x4C,(byte)0xB2,(byte)0x40,(byte)0x4A
                ,(byte)0x79,(byte)0x1B,(byte)0x73,(byte)0x37,(byte)0x20,(byte)0xD4,(byte)0x3F,(byte)0x11,(byte)0x05,(byte)0xF6,(byte)0x19,(byte)0x0C,(byte)0x26,(byte)0xB4,(byte)0x4E,(byte)0x4C
                ,(byte)0x34,(byte)0x97,(byte)0x90,(byte)0x35,(byte)0x1F,(byte)0xDB,(byte)0x8D,(byte)0x8C,(byte)0x5E,(byte)0xAD,(byte)0xE0,(byte)0x6F,(byte)0xD6,(byte)0xA7,(byte)0x4E,(byte)0x63
                ,(byte)0x9D,(byte)0x32,(byte)0xDB,(byte)0x3E,(byte)0x37,(byte)0x3D,(byte)0xDB,(byte)0x7E,(byte)0x77,(byte)0x9A,(byte)0xFF,(byte)0x77,(byte)0x18,(byte)0xE3,(byte)0x1E,(byte)0xC8
                ,(byte)0x41,(byte)0x08,(byte)0xAF,(byte)0x37,(byte)0x00,(byte)0x79,(byte)0x0B,(byte)0xB1,(byte)0x81,(byte)0xEF,(byte)0x39,(byte)0x81,(byte)0x3E,(byte)0x93,(byte)0x76,(byte)0xB5
                ,(byte)0x3A,(byte)0x18,(byte)0xAD,(byte)0x56,(byte)0xE7,(byte)0x23,(byte)0x32,(byte)0x6D,(byte)0x99,(byte)0x40,(byte)0xC2,(byte)0x6E,(byte)0x49,(byte)0xBB,(byte)0xB6,(byte)0x95
                ,(byte)0xB1,(byte)0x2F,(byte)0x07,(byte)0x03,(byte)0xC2,(byte)0xDD,(byte)0xA6,(byte)0x58,(byte)0xB3,(byte)0xF8,(byte)0xB2,(byte)0x88,(byte)0xB2,(byte)0x18,(byte)0xB2,(byte)0xA8
                ,(byte)0xB1,(byte)0x38,(byte)0xB1,(byte)0xC0,(byte)0x60,(byte)0x2B,(byte)0xBF,(byte)0xB2,(byte)0x2B,(byte)0xD4,(byte)0xC3,(byte)0x76,(byte)0xEC,(byte)0x0A,(byte)0xA8,(byte)0xCE
                ,(byte)0x6D,(byte)0xAC,(byte)0x17,(byte)0xEC,(byte)0xBC,(byte)0x2B,(byte)0x50,(byte)0xFA,(byte)0x4E,(byte)0x98,(byte)0x77,(byte)0xC5,(byte)0xC3,(byte)0x15,(byte)0x04,(byte)0x97
                ,(byte)0xE4,(byte)0x2E,(byte)0x69,(byte)0x5D,(byte)0x22,(byte)0xBA,(byte)0x84,(byte)0x72,(byte)0x49,(byte)0xE2,(byte)0x1E,(byte)0xBE,(byte)0x7B,(byte)0xCC,(byte)0x45,(byte)0xFB
                ,(byte)0xFF,(byte)0xB8,(byte)0x03,(byte)0xBF,(byte)0x72,(byte)0x09,(byte)0xB6,(byte)0xDF,(byte)0x81,(byte)0xAD,(byte)0xF4,(byte)0x81,(byte)0xC4,(byte)0xAF,(byte)0xA4,(byte)0x75
                ,(byte)0xB7,(byte)0x38,(byte)0x65,(byte)0x75,(byte)0x05,(byte)0xBA,(byte)0x0B,(byte)0xDE,(byte)0x61,(byte)0x70,(byte)0x4B,(byte)0xB2,(byte)0x24,(byte)0x6F,(byte)0x59,(byte)0xFD
                ,(byte)0x02,(byte)0x3A,(byte)0x87,(byte)0xF9,(byte)0x65,(byte)0x68,(byte)0x09,(byte)0xFD,(byte)0x14,(byte)0x0E,(byte)0x21,(byte)0xFF,(byte)0xCC,(byte)0xEA,(byte)0xE7,(byte)0x56
                ,(byte)0xAF,(byte)0x58,(byte)0xCD,(byte)0xFB,(byte)0xCF,(byte)0x7C,(byte)0x5F,(byte)0x8A,(byte)0x1E,(byte)0xCF,(byte)0x2F,(byte)0x45,(byte)0x0B,(byte)0x95,(byte)0xAF,(byte)0xD1
                ,(byte)0xB9,(byte)0xCC,(byte)0xA6,(byte)0x16,(byte)0x26,(byte)0x85,(byte)0x10,(byte)0xB4,(byte)0x26,(byte)0x2B,(byte)0x3E,(byte)0x61,(byte)0xD3,(byte)0x84,(byte)0x1E,(byte)0xD7
                ,(byte)0x10,(byte)0xB3,(byte)0xD6,(byte)0xC2,(byte)0xE2,(byte)0x75,(byte)0x11,(byte)0x7B,(byte)0xFA,(byte)0x20,(byte)0xBC,(byte)0x23,(byte)0x63,(byte)0xB6,(byte)0x1F,(byte)0xC2
                ,(byte)0x24,(byte)0xE1,(byte)0x1D,(byte)0xFE,(byte)0x01,(byte)0x33,(byte)0x4E,(byte)0xA7,(byte)0x10
        };

        sender.send(player.getChannel(), new SMSG_POWER_UPDATE());

		sender.send(player.getChannel(), new MSG_SET_DUNGEON_DIFFICULTY());
        sender.send(player.getChannel(), new SMSG_INSTANCE_DIFFICULTY());

        sender.send(player.getChannel(), new SMSG_LOGIN_VERIFY_WORLD(player));
		sender.send(player.getChannel(), new SMSG_ACCOUNT_DATA_TIMES(
				SMSG_ACCOUNT_DATA_TIMES.PER_CHARACTER_CACHE_MASK, player
						.getAccount().getAccountData()));
		sender.send(player.getChannel(), new SMSG_FEATURE_SYSTEM_STATUS());
		//sender.send(player.getChannel(), new SMSG_LEARNED_DANCE_MOVES());
		sender.send(player.getChannel(), new SMSG_BINDPOINTUPDATE(player));
		sender.send(player.getChannel(), new SMSG_TALENTS_INFO());
		sender.send(player.getChannel(), new SMSG_INITIAL_SPELLS());
		sender.send(player.getChannel(), new SMSG_ACTION_BUTTONS());
		sender.send(player.getChannel(), new SMSG_INITIALIZE_FACTIONS());

		sender.send(player.getChannel(), new SMSG_INIT_WORLD_STATES(player));
		sender.send(player.getChannel(), new SMSG_EQUIPMENT_SET_LIST());
		sender.send(player.getChannel(), new SMSG_ALL_ACHIEVEMENT_DATA());
		sender.send(player.getChannel(), new SMSG_LOGIN_SETTIMESPEED());
		sender.send(player.getChannel(), new SMSG_INIT_WORLD_STATES(player));
		sender.send(player.getChannel(), new SMSG_TIME_SYNC_REQ());
		sender.send(player.getChannel(), new SMSG_SPELL_GO());
		sender.send(player.getChannel(), new SMSG_PLAYED_TIME());

        SMSG_COMPRESSED_UPDATE_OBJECT updatePacket = new SMSG_COMPRESSED_UPDATE_OBJECT( player, taurenBytes );

        //sender.send(player.getChannel(), updatePacket );
        sender.send(player.getChannel(), new SMSG_MOTD("Test MotD String@test".split("@")));

        PlayerService.playerlist.put(player.getObjectId(), player);

        RealmServer.console.setVariable( "playerService", this );
        RealmServer.console.setVariable( "sender", sender );
        RealmServer.console.setVariable("player", player);
        RealmServer.console.setVariable( "updatePacket", updatePacket );
        RealmServer.console.setVariable( "update", new SMSG_UPDATE_OBJECT( player ) );

        player.update();

        return player;
	}

    public void updatePlayer( Player player ) {
        sender.send( player.getChannel(), new SMSG_UPDATE_OBJECT( player ) );
    }

    public void savePlayer( Player player ) {
        Session session = databaseFactory.getWorldSessionFactory().openSession();
        Characters character = new Characters();
        character.setAccount( 1 );
        character.setGuid( new Long( player.getObjectGuid().getRawValue() ).intValue() );
        character.setPlayerBytes( player.GetUInt32Value( PlayerFields.PLAYER_BYTES ) );
        character.setPlayerBytes2(player.GetUInt32Value(PlayerFields.PLAYER_BYTES_2));
        character.setName( player.getName() );
        character.setRace( Races.GNOME );
        character.setClazz( Classes.CLASS_PRIEST );

        session.getTransaction().begin();
        session.saveOrUpdate( character );
        session.getTransaction().commit();
        session.close();
    }

	/**
	 * Load home bind.
	 *
	 * @param player the player
	 * @return true, if successful
	 */
	public boolean LoadHomeBind(Player player) {
		return player.setHomeBind(playerDAO.loadHomeBind(player.getObjectId()));
	}

	/**
	 * Load from db.
	 *
	 * @param player the player
	 * @return true, if successful
	 */
	public boolean LoadFromDB(Player player) {
		player.initfields();
		PlayerCharacterData plchd = playerDAO.loadFromDB(player.getObjectId());
		player.SetUInt64Value(UnitFields.OBJECT_FIELD_GUID, player
				.getObjectGuid().getRawValue());
		CharactersData ch = player.getCharacterData();
		int bytes0 = 0;
		bytes0 |= ch.getRace();
		bytes0 |= ch.getClazz() << 8;
		bytes0 |= ch.getGender() << 16;
		player.SetUInt32Value( UnitFields.UNIT_FIELD_BYTES_0, bytes0);
		player.SetUInt32Value( UnitFields.UNIT_FIELD_LEVEL, ch.getLevel());
		player.SetUInt32Value( PlayerFields.PLAYER_XP, plchd.getXP());
		player._LoadIntoDataField(plchd.getExploredZones().split(" "),
				PlayerFields.PLAYER_EXPLORED_ZONES_1.getValue(),
				PLAYER_EXPLORED_ZONES_SIZE);
		player._LoadIntoDataField(plchd.getKnownTitles().split(" "),
				PlayerFields.PLAYER__FIELD_KNOWN_TITLES.getValue(), KNOWN_TITLES_SIZE * 2);

		player.SetFloatValue(UnitFields.UNIT_FIELD_BOUNDINGRADIUS,
				0.388999998569489f);
		player.SetFloatValue(UnitFields.UNIT_FIELD_COMBATREACH, 1.5f);
		player.SetFloatValue(UnitFields.UNIT_FIELD_HOVERHEIGHT, 1.0f);
		player.setMoney(plchd.getMoney());

		player.SetUInt32Value(PlayerFields.PLAYER_BYTES, ch.getPlayerBytes());
		player
				.SetUInt32Value(PlayerFields.PLAYER_BYTES_2, ch
						.getPlayerBytes2());
		player.SetUInt32Value(PlayerFields.PLAYER_BYTES_3,
				(plchd.getDrunk() & 0xFFFE) | ch.getGender());
		player.SetUInt32Value(PlayerFields.PLAYER_FLAGS, ch.getPlayerFlags());
		player.SetUInt32Value(PlayerFields.PLAYER_FIELD_WATCHED_FACTION_INDEX,
				plchd.getWatchedFaction());

		player.SetUInt64Value(PlayerFields.PLAYER_FIELD_KNOWN_CURRENCIES, plchd
				.getKnownCurrencies());

		player.SetUInt32Value(PlayerFields.PLAYER_AMMO_ID, plchd.getAmmoId());
		player.SetByteValue(PlayerFields.PLAYER_FIELD_BYTES, 2, plchd
				.getActionBars());
		// FIXME load from dbc
		int modelId = 0;
		player.SetUInt32Value(UnitFields.UNIT_FIELD_DISPLAYID, modelId);
		player.SetUInt32Value(UnitFields.UNIT_FIELD_NATIVEDISPLAYID, modelId);

		player.outDebugValue();

		player.setHomeBind(playerDAO.loadHomeBind(player.getObjectId()));
		InitStatsForLevel(player);
		LoadInventory(player);
		player.outDebugValue();
		return false;
	}
	
	/**
	 * Load inventory.
	 *
	 * @param player the player
	 */
	public void LoadInventory(Player player) {
		List<InventoryTemplate> inventoryTemplate = playerDAO
				.loadInventory(player.getObjectId());
		for (InventoryTemplate iT: inventoryTemplate) {
			ItemPrototype proto = itemStorages.get(iT.getItem_id());
			if(proto != null){
				logger.debug(proto.getName() + " - " + iT.getSlot());
				Item item = itemStorages.loadFromDB(iT,proto);
				if( Item.IsInventoryPos( Item.INVENTORY_SLOT_BAG_0, iT.getSlot() )){
					logger.debug(proto.getName() + " - " +"in INVENTORY_SLOT_BAG_0");
				}
				if( Item.IsEquipmentPos( Item.INVENTORY_SLOT_BAG_0, iT.getSlot() )){
					logger.debug(proto.getName() + " - " +"in INVENTORY_SLOT_BAG_0 and can equip");
					player.equipItem(iT.getSlot(), item);
				}
			}
		}
		
	}
	
	/**
	 * Inits the stats for level.
	 *
	 * @param player the player
	 */
	public void InitStatsForLevel(Player player) {
		PlayerClassLevelInfo classInfo = playerClassLevelInfoStorages.get(
				player.getCharacterData().getClazz(), player.getCharacterData()
						.getLevel());
		PlayerLevelInfo info = playerLevelStorages.get(player
				.getCharacterData().getRace(), player.getCharacterData()
				.getClazz(), player.getCharacterData().getLevel());

		player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MAX_LEVEL,
				CONFIG_UINT32_MAX_PLAYER_LEVEL);
		player.SetUInt32Value(PlayerFields.PLAYER_NEXT_LEVEL_XP, simpleStorages
				.GetXPForLevel(player.getCharacterData().getLevel()));

		// UpdateSkillsForLevel ();

		player.SetFloatValue(UnitFields.UNIT_MOD_CAST_SPEED, 1.0f);

		for (Stats stat : Stats.values()) {
			int val = info.getStats(stat);
			player.setCreateStat(stat, val);
			player.SetUInt32Value(UnitFields.UNIT_FIELD_STAT0
					+ stat.ordinal(), val);
		}
		player.SetUInt32Value(UnitFields.UNIT_FIELD_BASE_HEALTH, classInfo
				.getBasehealth());
		player.SetUInt32Value(UnitFields.UNIT_FIELD_BASE_MANA, classInfo
				.getBasemana());
		player.SetArmor(info.getStats(Stats.AGILITY) * 2);

		// InitStatBuffMods();

		for (SpellSchools spellscool : SpellSchools.values())
			player.SetFloatValue(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_PCT.getValue()
					+ spellscool.ordinal(), 1.00f);

		player.SetFloatValue(UnitFields.UNIT_FIELD_BASEATTACKTIME, 2000.0f);
		player.SetFloatValue(UnitFields.UNIT_FIELD_BASEATTACKTIME + 1,
				2000.0f);
		// offhand attack time
		player.SetFloatValue(UnitFields.UNIT_FIELD_RANGEDATTACKTIME, 2000.0f);

		// set armor (resistance 0) to original value (create_agility*2)

		// InitDataForForm();

		// save new stats
		for (Powers power : Powers.values())
			player.SetMaxPower(power, player.GetCreatePowers(power));

		player.SetMaxHealth(classInfo.getBasehealth());
		// stamina bonus will applied later

		// player.SetFlag(PlayerFields.UNIT_FIELD_FLAGS,
		// UnitFlags.UNIT_FLAG_PVP_ATTACKABLE.getValue() );
		// must be set
		/*
		 * SetFlag(UNIT_FIELD_FLAGS_2,UNIT_FLAG2_REGENERATE_POWER); // must be
		 * set
		 * 
		 * // cleanup player flags (will be re-applied if need at aura load), to
		 * avoid have ghost flag without ghost aura, for example.
		 * RemoveFlag(PLAYER_FLAGS, PLAYER_FLAGS_AFK | PLAYER_FLAGS_DND |
		 * PLAYER_FLAGS_GM | PLAYER_FLAGS_GHOST);
		 * 
		 * RemoveStandFlags(UNIT_STAND_FLAGS_ALL); // one form stealth modified
		 * bytes RemoveByteFlag(UNIT_FIELD_BYTES_2, 1, UNIT_BYTE2_FLAG_FFA_PVP |
		 * UNIT_BYTE2_FLAG_SANCTUARY);
		 * 
		 * // restore if need some important flags
		 * SetUInt32Value(PLAYER_FIELD_BYTES2, 0 ); // flags empty by default
		 * 
		 * if(reapplyMods) //reapply stats values only on .reset stats (level)
		 * command _ApplyAllStatBonuses();
		 * 
		 * // set current level health and mana/energy to maximum after applying
		 * all mods.
		 */
		player.SetHealth(player.GetMaxHealth());
		player.SetPower(Powers.POWER_MANA, player
				.GetMaxPower(Powers.POWER_MANA));
		player.SetPower(Powers.POWER_ENERGY, player
				.GetMaxPower(Powers.POWER_ENERGY));
		if (player.GetPower(Powers.POWER_RAGE) > player
				.GetMaxPower(Powers.POWER_RAGE))
			player.SetPower(Powers.POWER_RAGE, player
					.GetMaxPower(Powers.POWER_RAGE));

	}
	
	/**
	 * Gets the playerlist.
	 *
	 * @return the playerlist
	 */
	public static TLongObjectHashMap<Player> getPlayerlist() {
		return playerlist;
	}

	/**
	 * Sets the playerlist.
	 *
	 * @param playerlist the new playerlist
	 */
	public static void setPlayerlist(TLongObjectHashMap<Player> playerlist) {
		PlayerService.playerlist = playerlist;
	}

	/**
	 * Gets the player name.
	 *
	 * @param guid the guid
	 * @return the player name
	 */
	public static String getPlayerName(long guid) {
		if (PlayerService.playerlist.contains(guid)) {
			return PlayerService.playerlist.get(guid).getName();
		}
		return "";
	}

	/**
	 * Gets the player.
	 *
	 * @param guid the guid
	 * @return the player
	 */
	public static Player getPlayer(long guid) {
		if (PlayerService.playerlist.contains(guid)) {
			return PlayerService.playerlist.get(guid);
		}
		return null;
	}

}
