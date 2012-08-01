/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.dao.mysql5;

import gnu.trove.map.hash.TIntObjectHashMap;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.JMANGOS.realm.dao.ItemDAO;
import org.JMANGOS.realm.model.base.item.ItemPrototype;
import org.JMANGOS.realm.model.base.item._ItemStat;
import org.JMANGOS.realm.model.base.item._Socket;
import org.apache.log4j.Logger;
import org.JMANGOS.common.database.DB;

// TODO: Auto-generated Javadoc
/**
 * DAO that manages items.
 * 
 * @author minimajack
 */
public class MySQL5ItemDAO extends ItemDAO {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(MySQL5ItemDAO.class);
	
	/** The Constant START_SOCKET_DATA. */
	private static final byte START_SOCKET_DATA = 120;
	
	/** The Constant START_ITEM_STAT_DATA. */
	private static final byte START_ITEM_STAT_DATA = 29;
	
	/** The Constant START_DAMAGES_DATA. */
	private static final byte START_DAMAGES_DATA = 51;

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.ItemDAO#loadItemPrototypes()
	 */
	@Override
	public TIntObjectHashMap<ItemPrototype> loadItemPrototypes() {
		TIntObjectHashMap<ItemPrototype> mps = new TIntObjectHashMap<ItemPrototype>();
		PreparedStatement st = DB.prepareStatement("SELECT * FROM mangos.item_template;");

		try {
			st.setFetchSize(Integer.MIN_VALUE);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				mps.put(rs.getInt("entry"), getPrototypeByData(rs));
			}
			rs.close();
		} catch (Exception e) {
			log.error("Can't load ItemPrototypes  ", e);
		} finally {
			DB.close(st);
		}
		return mps;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.realm.dao.ItemDAO#loadItemPrototype(int)
	 */
	@Override
	public ItemPrototype loadItemPrototype(int guid) {
		PreparedStatement st = DB.prepareStatement("SELECT * FROM mangos.item_template WHERE entry = ?");

		try {
			st.setInt(1, guid);
			st.setFetchSize(Integer.MIN_VALUE);
			ResultSet rs = st.executeQuery();
			if (rs != null)
			while (rs.next()) {
				return getPrototypeByData(rs);
			}
			rs.close();
		} catch (Exception e) {
			log.error("Can't find ItemPrototype in DB with guid" + guid, e);
		} finally {
			DB.close(st);
		}
		return null;
	}

	/**
	 * Gets the prototype by data.
	 *
	 * @param rs the rs
	 * @return the prototype by data
	 * @throws SQLException the sQL exception
	 */
	private ItemPrototype getPrototypeByData(ResultSet rs) throws SQLException {
		ItemPrototype itemPrototype = new ItemPrototype(rs.getInt("entry"), rs.getInt("class"), rs.getInt("subClass"),
				rs.getInt("unk0"), rs.getInt("displayid"), rs.getInt("quality"), rs.getLong("flags"),  (int) rs
						.getLong("flags2"), (byte) rs.getInt("buyCount"), rs.getInt("buyPrice"),
				rs.getInt("sellPrice"), rs.getByte("inventoryType"), rs.getInt("allowableClass"), rs
						.getInt("allowableRace"), rs.getInt("itemLevel"), rs.getByte("requiredLevel"), rs
						.getInt("requiredSkill"), rs.getInt("requiredSkillRank"), rs.getInt("requiredSpell"), rs
						.getInt("requiredHonorRank"), rs.getInt("requiredCityRank"), rs
						.getInt("requiredReputationFaction"), rs.getInt("requiredReputationRank"), rs
						.getInt("maxCount"), rs.getInt("stackable"), rs.getByte("containerSlots"), rs
						.getInt("statsCount"), rs.getInt("scalingStatDistribution"), rs.getInt("scalingStatValue"), rs
						.getInt("armor"), rs.getByte("holy_res"), rs.getByte("fire_res"), rs.getByte("nature_res"), rs
						.getByte("frost_res"), rs.getByte("shadow_res"), rs.getByte("arcane_res"), rs.getInt("delay"),
				rs.getInt("ammo_type"), rs.getFloat("rangedModRange"), rs.getByte("bonding"), rs
						.getString("description"), rs.getInt("pageText"), rs.getByte("languageID"), rs
						.getByte("pageMaterial"), rs.getInt("startQuest"), rs.getInt("lockID"), rs.getInt("material"),
				rs.getByte("sheath"), rs.getInt("randomProperty"), rs.getInt("randomSuffix"), rs.getInt("block"), rs
						.getInt("itemSet"), rs.getInt("maxDurability"), rs.getInt("area"), rs.getInt("map"), rs
						.getInt("bagFamily"), rs.getInt("totemCategory"), rs.getInt("socketBonus"), rs
						.getInt("gemProperties"), rs.getInt("requiredDisenchantSkill"), rs
						.getFloat("armorDamageModifier"), rs.getInt("duration"), rs.getInt("itemLimitCategory"), rs
						.getInt("holidayId"),
				// FIXME set proper script id
				0, rs.getInt("DisenchantID"), rs.getByte("FoodType"), rs.getInt("minMoneyLoot"), rs
						.getInt("maxMoneyLoot"), rs.getByte("extraFlags"));

		itemPrototype.setName(rs.getString("name"));
		List<_Socket> tsock = new ArrayList<_Socket>();
		for (byte i = 0; i < ItemPrototype.MAX_ITEM_PROTO_SOCKETS; i++) {
			tsock.add(new _Socket(rs.getByte(START_SOCKET_DATA + 2 * i), rs.getInt(START_SOCKET_DATA + 1 + 2 * i)));
			
		}
		
		itemPrototype.setSocket(tsock.toArray());
		tsock.clear();
		List<_ItemStat> tst = new ArrayList<_ItemStat>();
		for (byte i = 0; i < ItemPrototype.MAX_ITEM_PROTO_STATS; i++) {
			tst.add(new _ItemStat(rs.getByte(START_ITEM_STAT_DATA + 2 * i), rs.getInt(START_ITEM_STAT_DATA + 1 + 2
					* i)));
		}
		itemPrototype.setItemStat(tst.toArray());
		tst.clear();
		for (byte i = 0; i < ItemPrototype.MAX_ITEM_PROTO_DAMAGES; i++) {
			itemPrototype.setDamage(rs.getFloat(START_DAMAGES_DATA + 3 * i), rs
					.getFloat(START_DAMAGES_DATA + 1 + 3 * i), rs.getByte(START_DAMAGES_DATA + 2 + 3 * i), i);
		}

		return itemPrototype;
	}
}
