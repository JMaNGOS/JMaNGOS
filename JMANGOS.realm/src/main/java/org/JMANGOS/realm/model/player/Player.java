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
package org.JMANGOS.realm.model.player;

import org.JMANGOS.realm.model.account.Account;
import org.JMANGOS.realm.model.base.character.CharactersData;
import org.JMANGOS.realm.model.base.guid.TypeId;
import org.JMANGOS.realm.model.base.guid.TypeMask;
import org.JMANGOS.realm.model.base.item.Item;
import org.JMANGOS.realm.model.base.update.PlayerFields;
import org.JMANGOS.realm.model.unit.Powers;
import org.JMANGOS.realm.model.unit.SpellSchools;
import org.JMANGOS.realm.model.unit.Stats;
import org.JMANGOS.realm.model.unit.UnitMoveType;
import org.JMANGOS.realm.model.unit.Units;
import org.JMANGOS.realm.model.unit.WeaponAttackType;
import org.apache.log4j.Logger;
import org.JMANGOS.common.network.model.ChanneledObject;
import org.JMANGOS.common.network.model.NettyNetworkChannel;
import org.JMANGOS.common.network.model.NetworkChannel;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player extends Units implements ChanneledObject {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Player.class);
	
	/** The Constant PLAYER_SLOTS_COUNT. */
	final static int PLAYER_SLOTS_COUNT = 150;
	
	/** The Constant TRADE_SLOT_COUNT. */
	final static int TRADE_SLOT_COUNT = 7;

	/** The character data. */
	private CharactersData characterData;
	
	/** The channel. */
	private NetworkChannel channel;
	
	/** The home bind. */
	private PlayerHomeBindData homeBind;

	/** The Weapon proficiency. */
	int WeaponProficiency = 0;
	
	/** The Armor proficiency. */
	int ArmorProficiency = 0;
	
	/** The can parry. */
	boolean canParry = false;
	
	/** The can block. */
	boolean canBlock = false;
	
	/** The can dual wield. */
	boolean canDualWield = false;
	
	/** The can titan grip. */
	boolean canTitanGrip = false;
	
	/** The ammo dps. */
	float ammoDPS = 0;
	
	/** The aura base mod. */
	private float[][] auraBaseMod = new float[BaseModGroup.BASEMOD_END
			.ordinal()][BaseModType.values().length];

	/** The items. */
	private Item[] items = new Item[PLAYER_SLOTS_COUNT];
	
	/** The trade items. */
	@SuppressWarnings("unused")
	private int[] tradeItems = new int[TRADE_SLOT_COUNT];

	/** The forced_speed_changes. */
	byte[] forced_speed_changes = new byte[UnitMoveType.MAX_MOVE_TYPE];
	
	/** The money. */
	private int money = 0;
	
	/** The time sync counter. */
	private int timeSyncCounter = 0;

	/**
	 * Instantiates a new player.
	 *
	 * @param cd the cd
	 */
	public Player(CharactersData cd) {
		super(cd.getObjectId());
		setName(cd.getName());
		valuesCount = PlayerFields.PLAYER_END;
		objectType.add(TypeMask.TYPEMASK_PLAYER);
		objectTypeId = TypeId.TYPEID_PLAYER;
		characterData = cd;
		for (int i = 0; i < BaseModGroup.BASEMOD_END.ordinal(); ++i) {
			auraBaseMod[i][BaseModType.PCT_MOD.ordinal()] = 1.0f;
		}
	}

	/**
	 * Sets the character data.
	 *
	 * @param characterData the characterData to set
	 */
	public final void setCharacterData(CharactersData characterData) {
		this.characterData = characterData;
		setName(characterData.getName());
	}

	/**
	 * Instantiates a new player.
	 *
	 * @param guid the guid
	 */
	public Player(long guid) {
		super(guid);
		valuesCount = PlayerFields.PLAYER_END;
		objectType.add(TypeMask.TYPEMASK_PLAYER);
		objectTypeId = TypeId.TYPEID_PLAYER;
		for (int i = 0; i < BaseModGroup.BASEMOD_END.ordinal(); ++i) {
			auraBaseMod[i][BaseModType.PCT_MOD.ordinal()] = 1.0f;
		}
	}

	/**
	 * Gets the home bind.
	 *
	 * @return the home bind
	 */
	public final PlayerHomeBindData getHomeBind() {
		return homeBind;
	}

	/**
	 * Gets the map id.
	 *
	 * @return the int
	 */
	public int GetMapId() {
		return characterData.getMap();
	}

	/**
	 * Gets the character data.
	 *
	 * @return the characterData
	 */
	public CharactersData getCharacterData() {
		return characterData;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ChanneledObject#setChannel(org.wowemu.common.network.model.NetworkChannel)
	 */
	@Override
	public void setChannel(NetworkChannel channel) {
		this.channel = channel;

	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.ChanneledObject#getChannel()
	 */
	@Override
	public NetworkChannel getChannel() {
		return channel;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	public Account getAccount() {
		return (Account) ((NettyNetworkChannel) getChannel())
				.getChanneledObject();
	}

	/**
	 * Sets the home bind.
	 *
	 * @param HomeBind the home bind
	 * @return true, if successful
	 */
	public boolean setHomeBind(PlayerHomeBindData HomeBind) {
		if (HomeBind != null) {
			this.homeBind = HomeBind;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets the aura base mod.
	 *
	 * @param auraBaseMod the new aura base mod
	 */
	public void setAuraBaseMod(float[][] auraBaseMod) {
		this.auraBaseMod = auraBaseMod;
	}

	/**
	 * Gets the aura base mod.
	 *
	 * @return the aura base mod
	 */
	public float[][] getAuraBaseMod() {
		return auraBaseMod;
	}

	/**
	 * Sets the money.
	 *
	 * @param money the new money
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
	 * Gets the money.
	 *
	 * @return the money
	 */
	public final int getMoney() {
		return money;
	}

	/**
	 * Out debug value.
	 */
	public void outDebugValue() {
		logger.debug(String.format("HP is: \t\t\t%d\t\tMP is: \t\t\t%d",
				GetMaxHealth(), GetMaxPower(Powers.POWER_MANA)));
		logger.debug(String.format("AGILITY is: \t\t%f\tSTRENGTH is: \t\t%f",
				GetStat(Stats.STAT_AGILITY), GetStat(Stats.STAT_STRENGTH)));
		logger.debug(String.format("INTELLECT is: \t\t%f\tSPIRIT is: \t\t%f",
				GetStat(Stats.STAT_INTELLECT), GetStat(Stats.STAT_SPIRIT)));
		logger.debug(String.format("STAMINA is: \t\t%f",
				GetStat(Stats.STAT_STAMINA)));
		logger.debug(String
				.format("Armor is: \t\t\t%d\t\tBlock is: \t\t%f", GetArmor(),
						GetFloatValue(PlayerFields.PLAYER_BLOCK_PERCENTAGE)));
		logger.debug(String.format("HolyRes is: \t\t%d\t\tFireRes is: \t\t%d",
				GetResistance(SpellSchools.SPELL_SCHOOL_HOLY),
				GetResistance(SpellSchools.SPELL_SCHOOL_FIRE)));
		logger.debug(String.format(
				"NatureRes is: \t\t%d\t\tFrostRes is: \t\t%d",
				GetResistance(SpellSchools.SPELL_SCHOOL_NATURE),
				GetResistance(SpellSchools.SPELL_SCHOOL_FROST)));
		logger.debug(String.format(
				"ShadowRes is: \t\t%d\t\tArcaneRes is: \t\t%d",
				GetResistance(SpellSchools.SPELL_SCHOOL_SHADOW),
				GetResistance(SpellSchools.SPELL_SCHOOL_ARCANE)));
		logger.debug(String.format(
				"MIN_DAMAGE is: \t\t%f\tMAX_DAMAGE is: \t\t%f",
				GetFloatValue(PlayerFields.UNIT_FIELD_MINDAMAGE),
				GetFloatValue(PlayerFields.UNIT_FIELD_MAXDAMAGE)));
		logger.debug(String.format(
				"MIN_OFFHAND_DAMAGE is: \t%f\tMAX_OFFHAND_DAMAGE is: \t%f",
				GetFloatValue(PlayerFields.UNIT_FIELD_MINOFFHANDDAMAGE),
				GetFloatValue(PlayerFields.UNIT_FIELD_MAXOFFHANDDAMAGE)));
		logger.debug(String.format(
				"MIN_RANGED_DAMAGE is: \t%f\tMAX_RANGED_DAMAGE is: \t%f",
				GetFloatValue(PlayerFields.UNIT_FIELD_MINRANGEDDAMAGE),
				GetFloatValue(PlayerFields.UNIT_FIELD_MAXRANGEDDAMAGE)));
		logger.debug(String.format(
				"ATTACK_TIME is: \t\t%d\t\tRANGE_ATTACK_TIME is: \t%d",
				GetAttackTime(WeaponAttackType.BASE_ATTACK), GetAttackTime(WeaponAttackType.RANGED_ATTACK)));
		System.out.println();
	}

	/**
	 * Gets the update time sync counter.
	 *
	 * @return the update time sync counter
	 */
	public int getUpdateTimeSyncCounter() {
		return timeSyncCounter++ ;
	}

	/**
	 * Equip item.
	 *
	 * @param slot the slot
	 * @param item the item
	 */
	public void equipItem(int slot, Item item) {
		// FIXME NEED VISUALIZE add to fields
		 items[slot] = item;
		
	}
}
