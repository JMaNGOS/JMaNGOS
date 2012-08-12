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
package org.jmangos.realm.model.player;

import org.apache.log4j.Logger;
import org.jmangos.commons.model.Account;
import org.jmangos.commons.network.model.ChanneledObject;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.model.NetworkChannel;
import org.jmangos.realm.model.base.character.CharacterData;
import org.jmangos.realm.model.base.guid.TypeId;
import org.jmangos.realm.model.base.guid.TypeMask;
import org.jmangos.realm.model.base.item.Item;
import org.jmangos.realm.model.base.update.PlayerFields;
import org.jmangos.realm.model.base.update.UnitField;
import org.jmangos.realm.model.unit.*;

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
	private CharacterData characterData;
	
	/** The channel. */
	private NetworkChannel channel;
	
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
	public Player(CharacterData cd) {
		super(cd.getGuid());
		setName(cd.getName());
		valuesCount = PlayerFields.PLAYER_END.getValue();
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
	public final void setCharacterData(CharacterData characterData) {
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
		valuesCount = PlayerFields.PLAYER_END.getValue();
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
		return characterData.getHomeBindData();
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
	public CharacterData getCharacterData() {
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
		return (Account)((NettyNetworkChannel) getChannel()).getChanneledObject();
	}

	/**
	 * Sets the home bind.
	 *
	 * @param homeBind the home bind
	 * @return true, if successful
	 */
	public boolean setHomeBind(PlayerHomeBindData homeBind) {
		if (homeBind != null) {
			characterData.setHomeBindData( homeBind );
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
				GetStat(Stats.AGILITY), GetStat(Stats.STRENGTH)));
		logger.debug(String.format("INTELLECT is: \t\t%f\tSPIRIT is: \t\t%f",
				GetStat(Stats.INTELLECT), GetStat(Stats.SPIRIT)));
		logger.debug(String.format("STAMINA is: \t\t%f",
				GetStat(Stats.STAMINA)));
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
                GetFloatValue(UnitField.UNIT_FIELD_MINDAMAGE),
                GetFloatValue(UnitField.UNIT_FIELD_MAXDAMAGE)));
		logger.debug(String.format(
				"MIN_OFFHAND_DAMAGE is: \t%f\tMAX_OFFHAND_DAMAGE is: \t%f",
				GetFloatValue(UnitField.UNIT_FIELD_MINOFFHANDDAMAGE),
				GetFloatValue(UnitField.UNIT_FIELD_MAXOFFHANDDAMAGE)));
		logger.debug(String.format(
				"MIN_RANGED_DAMAGE is: \t%f\tMAX_RANGED_DAMAGE is: \t%f",
				GetFloatValue(UnitField.UNIT_FIELD_MINRANGEDDAMAGE),
				GetFloatValue(UnitField.UNIT_FIELD_MAXRANGEDDAMAGE)));
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
