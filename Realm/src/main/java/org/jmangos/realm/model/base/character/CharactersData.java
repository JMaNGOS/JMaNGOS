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
package org.jmangos.realm.model.base.character;

import org.jmangos.commons.model.NamedObject;

// TODO: Auto-generated Javadoc
/**
 * The Class CharactersData.
 */
public class CharactersData extends NamedObject {
	
	/** The at login flags. */
	private int atLoginFlags;

	/** The char_flags. */
	private int char_flags;

	/** The Class. */
	private byte Class;

	/** The gender. */
	private byte gender;

	/** The guid. */
	private int guid;

	/** The guild id. */
	private int guildId;

	/** The level. */
	private byte level;

	/** The player bytes. */
	private int playerBytes;

	/** The player bytes2. */
	private int playerBytes2;

	/** The player flags. */
	private int playerFlags;

	/** The pos_x. */
	private float pos_x;

	/** The pos_y. */
	private float pos_y;

	/** The pos_z. */
	private float pos_z;

	/** The orientation. */
	private float orientation;

	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public final float getOrientation() {
		return orientation;
	}

	/**
	 * Sets the orientation.
	 *
	 * @param orientation the new orientation
	 */
	public final void setOrientation(float orientation) {
		this.orientation = orientation;
	}

	/** The Race. */
	private byte Race;

	/** The zone. */
	private int zone;

	/** The map. */
	private int map;

	/** The Name. */
	private String Name;

	/** item. */

	private ItemData[] bags = new ItemData[4];

	/** The items. */
	private ItemData[] items = new ItemData[19];

	/** pets. */
	private int petDisplayId = 0;

	/** The pet family. */
	private int petFamily = 0;

	/** The pet level. */
	private int petLevel = 0;

	/**
	 * Instantiates a new characters data.
	 *
	 * @param guid the guid
	 */
	public CharactersData(int guid) {
		super(guid);
	}

	/**
	 * Gets the at login flags.
	 *
	 * @return the at login flags
	 */
	public final int getAtLoginFlags() {
		return atLoginFlags;
	}

	/**
	 * Gets the bags.
	 *
	 * @return the bags
	 */
	public final ItemData[] getBags() {
		return bags;
	}

	/**
	 * Gets the char_flags.
	 *
	 * @return the char_flags
	 */
	public final int getChar_flags() {
		return char_flags;
	}

	/**
	 * Gets the clazz.
	 *
	 * @return the clazz
	 */
	public final byte getClazz() {
		return Class;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public final byte getGender() {
		return gender;
	}

	/**
	 * Gets the guid.
	 *
	 * @return the guid
	 */
	public final int getGuid() {
		return guid;
	}

	/**
	 * Gets the guild id.
	 *
	 * @return the guild id
	 */
	public final int getGuildId() {
		return guildId;
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	public final ItemData[] getItems() {
		return items;
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public final byte getLevel() {
		return level;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public final int getMap() {
		return map;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.model.NamedObject#getName()
	 */
	public final String getName() {
		return Name;
	}

	/**
	 * Gets the pet display id.
	 *
	 * @return the pet display id
	 */
	public final int getPetDisplayId() {
		return petDisplayId;
	}

	/**
	 * Gets the pet family.
	 *
	 * @return the pet family
	 */
	public final int getPetFamily() {
		return petFamily;
	}

	/**
	 * Gets the pet level.
	 *
	 * @return the pet level
	 */
	public final int getPetLevel() {
		return petLevel;
	}

	/**
	 * Gets the player bytes.
	 *
	 * @return the player bytes
	 */
	public final int getPlayerBytes() {
		return playerBytes;
	}

	/**
	 * Gets the player bytes2.
	 *
	 * @return the player bytes2
	 */
	public final int getPlayerBytes2() {
		return playerBytes2;
	}

	/**
	 * Gets the player flags.
	 *
	 * @return the player flags
	 */
	public final int getPlayerFlags() {
		return playerFlags;
	}

	/**
	 * Gets the pos_x.
	 *
	 * @return the pos_x
	 */
	public final float getPos_x() {
		return pos_x;
	}

	/**
	 * Gets the pos_y.
	 *
	 * @return the pos_y
	 */
	public final float getPos_y() {
		return pos_y;
	}

	/**
	 * Gets the pos_z.
	 *
	 * @return the pos_z
	 */
	public final float getPos_z() {
		return pos_z;
	}

	/**
	 * Gets the race.
	 *
	 * @return the race
	 */
	public final byte getRace() {
		return Race;
	}

	/**
	 * Gets the zone.
	 *
	 * @return the zone
	 */
	public final int getZone() {
		return zone;
	}

	/**
	 * Sets the at login flags.
	 *
	 * @param atLoginFlags the new at login flags
	 */
	public final void setAtLoginFlags(int atLoginFlags) {
		this.atLoginFlags = atLoginFlags;
	}

	/**
	 * Sets the bags.
	 *
	 * @param bags the new bags
	 */
	public final void setBags(ItemData[] bags) {
		this.bags = bags;
	}

	/**
	 * Sets the char_flags.
	 *
	 * @param char_flags the new char_flags
	 */
	public final void setChar_flags(int char_flags) {
		this.char_flags = char_flags;
	}

	/**
	 * Sets the clazz.
	 *
	 * @param class1 the new clazz
	 */
	public final void setClazz(byte class1) {
		Class = class1;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public final void setGender(byte gender) {
		this.gender = gender;
	}

	/**
	 * Sets the guid.
	 *
	 * @param guid the new guid
	 */
	public final void setGuid(int guid) {
		this.guid = guid;
	}

	/**
	 * Sets the guild id.
	 *
	 * @param guildId the new guild id
	 */
	public final void setGuildId(int guildId) {
		this.guildId = guildId;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public final void setItems(ItemData[] items) {
		this.items = items;
	}

	/**
	 * Sets the level.
	 *
	 * @param level the new level
	 */
	public final void setLevel(byte level) {
		this.level = level;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	public final void setMap(int map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.model.NamedObject#setName(java.lang.String)
	 */
	public final void setName(String name) {
		Name = name;
	}

	/**
	 * Sets the pet display id.
	 *
	 * @param petDisplayId the new pet display id
	 */
	public final void setPetDisplayId(int petDisplayId) {
		this.petDisplayId = petDisplayId;
	}

	/**
	 * Sets the pet family.
	 *
	 * @param petFamily the new pet family
	 */
	public final void setPetFamily(int petFamily) {
		this.petFamily = petFamily;
	}

	/**
	 * Sets the pet level.
	 *
	 * @param petLevel the new pet level
	 */
	public final void setPetLevel(int petLevel) {
		this.petLevel = petLevel;
	}

	/**
	 * Sets the player bytes.
	 *
	 * @param playerBytes the new player bytes
	 */
	public final void setPlayerBytes(int playerBytes) {
		this.playerBytes = playerBytes;
	}

	/**
	 * Sets the player bytes2.
	 *
	 * @param i the new player bytes2
	 */
	public final void setPlayerBytes2(int i) {
		this.playerBytes2 = i;
	}

	/**
	 * Sets the player flags.
	 *
	 * @param playerFlags the new player flags
	 */
	public final void setPlayerFlags(int playerFlags) {
		this.playerFlags = playerFlags;
	}

	/**
	 * Sets the pos_x.
	 *
	 * @param pos_x the new pos_x
	 */
	public final void setPos_x(float pos_x) {
		this.pos_x = pos_x;
	}

	/**
	 * Sets the pos_y.
	 *
	 * @param pos_y the new pos_y
	 */
	public final void setPos_y(float pos_y) {
		this.pos_y = pos_y;
	}

	/**
	 * Sets the pos_z.
	 *
	 * @param pos_z the new pos_z
	 */
	public final void setPos_z(float pos_z) {
		this.pos_z = pos_z;
	}

	/**
	 * Sets the race.
	 *
	 * @param race the new race
	 */
	public final void setRace(byte race) {
		Race = race;
	}

	/**
	 * Sets the zone.
	 *
	 * @param zone the new zone
	 */
	public final void setZone(int zone) {
		this.zone = zone;
	}

	/**
	 * Sets the items from cache.
	 *
	 * @param Cache the new items from cache
	 */
	public void setItemsFromCache(String[] Cache) {
		for (int i = 0; i < (Cache.length / 2); i++) {
			this.items[i] = new ItemData();
			this.items[i].setDisplayInfoID(Integer.decode(Cache[i*2]));
		}
	}

}
