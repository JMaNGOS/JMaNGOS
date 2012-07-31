/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.service;

import java.util.List;

import gnu.trove.TLongObjectHashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.JMANGOS.realm.dao.PlayerDAO;
import org.JMANGOS.realm.model.InventoryTemplate;
import org.JMANGOS.realm.model.account.Account;
import org.JMANGOS.realm.model.base.PlayerClassLevelInfo;
import org.JMANGOS.realm.model.base.PlayerLevelInfo;
import org.JMANGOS.realm.model.base.WorldObject;
import org.JMANGOS.realm.model.base.character.CharactersData;
import org.JMANGOS.realm.model.base.item.Item;
import org.JMANGOS.realm.model.base.item.ItemPrototype;
import org.JMANGOS.realm.model.base.update.PlayerFields;
import org.JMANGOS.realm.model.player.Player;
import org.JMANGOS.realm.model.player.PlayerCharacterData;
import org.JMANGOS.realm.model.unit.Powers;
import org.JMANGOS.realm.model.unit.SpellSchools;
import org.JMANGOS.realm.model.unit.Stats;
import org.JMANGOS.realm.network.netty.packet.server.MSG_SET_DUNGEON_DIFFICULTY;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_ACCOUNT_DATA_TIMES;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_ACTION_BUTTONS;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_ALL_ACHIEVEMENT_DATA;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_BINDPOINTUPDATE;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_COMPRESSED_UPDATE_OBJECT;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_EQUIPMENT_SET_LIST;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_FEATURE_SYSTEM_STATUS;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_INITIALIZE_FACTIONS;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_INITIAL_SPELLS;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_INIT_WORLD_STATES;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_INSTANCE_DIFFICULTY;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_LEARNED_DANCE_MOVES;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_LOGIN_SETTIMESPEED;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_LOGIN_VERIFY_WORLD;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_MOTD;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_PLAYED_TIME;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_POWER_UPDATE;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_SPELL_GO;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_TALENTS_INFO;
import org.JMANGOS.realm.network.netty.packet.server.SMSG_TIME_SYNC_REQ;
import org.apache.log4j.Logger;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.netty.sender.AbstractPacketSender;

// TODO: Auto-generated Javadoc
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
		sender.send(player.getChannel(), new SMSG_POWER_UPDATE());
		sender.send(player.getChannel(), new MSG_SET_DUNGEON_DIFFICULTY());
		sender.send(player.getChannel(), new SMSG_LOGIN_VERIFY_WORLD(player));
		sender.send(player.getChannel(), new SMSG_ACCOUNT_DATA_TIMES(
				SMSG_ACCOUNT_DATA_TIMES.PER_CHARACTER_CACHE_MASK, player
						.getAccount().getAccountData()));
		sender.send(player.getChannel(), new SMSG_FEATURE_SYSTEM_STATUS());
		sender.send(player.getChannel(), new SMSG_MOTD("Test MotD String@test"
				.split("@")));
		sender.send(player.getChannel(), new SMSG_LEARNED_DANCE_MOVES());
		sender.send(player.getChannel(), new SMSG_BINDPOINTUPDATE(player));
		sender.send(player.getChannel(), new SMSG_TALENTS_INFO());
		sender.send(player.getChannel(), new SMSG_INSTANCE_DIFFICULTY());

		sender.send(player.getChannel(), new SMSG_INITIAL_SPELLS());
		sender.send(player.getChannel(), new SMSG_ACTION_BUTTONS());
		sender.send(player.getChannel(), new SMSG_INITIALIZE_FACTIONS());

		sender.send(player.getChannel(), new SMSG_INIT_WORLD_STATES(player));
		sender.send(player.getChannel(), new SMSG_EQUIPMENT_SET_LIST());
		sender.send(player.getChannel(), new SMSG_ALL_ACHIEVEMENT_DATA());
		sender.send(player.getChannel(), new SMSG_LOGIN_SETTIMESPEED());
		sender.send(player.getChannel(), new SMSG_COMPRESSED_UPDATE_OBJECT());
		sender.send(player.getChannel(), new SMSG_INIT_WORLD_STATES(player));
		sender.send(player.getChannel(), new SMSG_TIME_SYNC_REQ());
		sender.send(player.getChannel(), new SMSG_SPELL_GO());
		sender.send(player.getChannel(), new SMSG_PLAYED_TIME());
		PlayerService.playerlist.put(player.getObjectId(), player);
		return player;
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
		player.SetUInt64Value(PlayerFields.OBJECT_FIELD_GUID, player
				.getObjectGuid().getRawValue());
		CharactersData ch = player.getCharacterData();
		int bytes0 = 0;
		bytes0 |= ch.getRace();
		bytes0 |= ch.getClazz() << 8;
		bytes0 |= ch.getGender() << 16;
		player.SetUInt32Value(PlayerFields.UNIT_FIELD_BYTES_0, bytes0);
		player.SetUInt32Value(PlayerFields.UNIT_FIELD_LEVEL, ch.getLevel());
		player.SetUInt32Value(PlayerFields.PLAYER_XP, plchd.getXP());
		player._LoadIntoDataField(plchd.getExploredZones().split(" "),
				PlayerFields.PLAYER_EXPLORED_ZONES_1,
				PLAYER_EXPLORED_ZONES_SIZE);
		player._LoadIntoDataField(plchd.getKnownTitles().split(" "),
				PlayerFields.PLAYER__FIELD_KNOWN_TITLES, KNOWN_TITLES_SIZE * 2);

		player.SetFloatValue(PlayerFields.UNIT_FIELD_BOUNDINGRADIUS,
				0.388999998569489f);
		player.SetFloatValue(PlayerFields.UNIT_FIELD_COMBATREACH, 1.5f);
		player.SetFloatValue(PlayerFields.UNIT_FIELD_HOVERHEIGHT, 1.0f);
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
		player.SetUInt32Value(PlayerFields.UNIT_FIELD_DISPLAYID, modelId);
		player.SetUInt32Value(PlayerFields.UNIT_FIELD_NATIVEDISPLAYID, modelId);

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
				logger.info(proto.getName() + " - " + iT.getSlot());
				Item item = itemStorages.loadFromDB(iT,proto);
				if( Item.IsInventoryPos( Item.INVENTORY_SLOT_BAG_0, iT.getSlot() )){
					logger.info(proto.getName() + " - " +"in INVENTORY_SLOT_BAG_0");
				}
				if( Item.IsEquipmentPos( Item.INVENTORY_SLOT_BAG_0, iT.getSlot() )){
					logger.info(proto.getName() + " - " +"in INVENTORY_SLOT_BAG_0 and can equip");
					player.equipItem(iT.getSlot(), item);
					//Item* m_items[PLAYER_SLOTS_COUNT];
				}
				//item.LoadFromDB(iT, player.getObjectGuid().getRawValue());
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

		player.SetFloatValue(PlayerFields.UNIT_MOD_CAST_SPEED, 1.0f);

		for (Stats stat : Stats.values()) {
			int val = info.getStats(stat);
			player.setCreateStat(stat, val);
			player.SetUInt32Value(PlayerFields.UNIT_FIELD_STAT0
					+ stat.ordinal(), val);
		}
		player.SetUInt32Value(PlayerFields.UNIT_FIELD_BASE_HEALTH, classInfo
				.getBasehealth());
		player.SetUInt32Value(PlayerFields.UNIT_FIELD_BASE_MANA, classInfo
				.getBasemana());
		player.SetArmor(info.getStats(Stats.STAT_AGILITY) * 2);

		// InitStatBuffMods();

		for (SpellSchools spellscool : SpellSchools.values())
			player.SetFloatValue(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_PCT
					+ spellscool.ordinal(), 1.00f);

		player.SetFloatValue(PlayerFields.UNIT_FIELD_BASEATTACKTIME, 2000.0f);
		player.SetFloatValue(PlayerFields.UNIT_FIELD_BASEATTACKTIME + 1,
				2000.0f);
		// offhand attack time
		player.SetFloatValue(PlayerFields.UNIT_FIELD_RANGEDATTACKTIME, 2000.0f);

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
