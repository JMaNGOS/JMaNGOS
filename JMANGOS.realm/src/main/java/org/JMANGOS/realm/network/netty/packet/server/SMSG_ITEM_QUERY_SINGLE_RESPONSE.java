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
package org.JMANGOS.realm.network.netty.packet.server;

import org.JMANGOS.realm.model.base.item.ItemPrototype;
import org.JMANGOS.realm.network.netty.packet.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_ITEM_QUERY_SINGLE_RESPONSE.
 */
public class SMSG_ITEM_QUERY_SINGLE_RESPONSE extends AbstractWoWServerPacket {

	/** The item prototype. */
	private ItemPrototype itemPrototype;

	/**
	 * Instantiates a new sMS g_ ite m_ quer y_ singl e_ response.
	 */
	public SMSG_ITEM_QUERY_SINGLE_RESPONSE() {

	}
	
	/**
	 * Instantiates a new sMS g_ ite m_ quer y_ singl e_ response.
	 *
	 * @param itemPrototype the item prototype
	 */
	public SMSG_ITEM_QUERY_SINGLE_RESPONSE(ItemPrototype itemPrototype) {
		this.itemPrototype = itemPrototype;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
	 */
	@Override
	protected void writeImpl() {
		writeD(itemPrototype.getObjectId());
		writeD(itemPrototype.getClazz());
		writeD(itemPrototype.getSubClass());
		writeD(itemPrototype.getUnk0());
		writeS(itemPrototype.getName());
		writeC(0);
		writeC(0);
		writeC(0);
		writeD(itemPrototype.getDisplayInfoID());
		writeD(itemPrototype.getQuality());
		writeD(itemPrototype.getFlags() & 0xFFFFFFFF);
		writeD(itemPrototype.getFlags2() & 0xFFFFFFFF);
		writeD(itemPrototype.getBuyPrice());
		writeD(itemPrototype.getSellPrice());
		writeD(itemPrototype.getInventoryType().ordinal());
		writeD(itemPrototype.getAllowableClass());
		writeD(itemPrototype.getAllowableRace());
		writeD(itemPrototype.getItemLevel());
		writeD(itemPrototype.getRequiredLevel());
		writeD(itemPrototype.getRequiredSkill());
		writeD(itemPrototype.getRequiredSkillRank());
		writeD(itemPrototype.getRequiredSpell());
		writeD(itemPrototype.getRequiredHonorRank());
		writeD(itemPrototype.getRequiredCityRank());
		writeD(itemPrototype.getRequiredReputationFaction());
		writeD(itemPrototype.getRequiredReputationRank());
		
		writeD(itemPrototype.getMaxCount());
		writeD(itemPrototype.getStackable());
		writeD(itemPrototype.getContainerSlots());
		writeD(itemPrototype.getStatsCount());
		for (int i = 0; i < itemPrototype.getStatsCount(); i++) {
			writeD(itemPrototype.getItemStat(i).getItemStatType());
			writeD(itemPrototype.getItemStat(i).getItemStatValue());
		}
		writeD(itemPrototype.getScalingStatDistribution());
		writeD(itemPrototype.getScalingStatValue());

		for (int i = 0; i < ItemPrototype.MAX_ITEM_PROTO_DAMAGES; i++) {

			writeF(itemPrototype.getDamage(i).getDamageMin());
			writeF(itemPrototype.getDamage(i).getDamageMax());
			writeD(itemPrototype.getDamage(i).getDamageType());
		}

		writeD(itemPrototype.getArmor());
		writeD(itemPrototype.getHolyRes());
		writeD(itemPrototype.getFireRes());
		writeD(itemPrototype.getNatureRes());
		writeD(itemPrototype.getFrostRes());
		writeD(itemPrototype.getShadowRes());
		writeD(itemPrototype.getArcaneRes());
		writeD(itemPrototype.getDelay());
		writeD(itemPrototype.getAmmoType());
		writeF(itemPrototype.getRangedModRange());

		for (int i = 0; i < ItemPrototype.MAX_ITEM_PROTO_SPELLS; i++) {

			writeD(0);
			writeD(0);
			writeD(0);
			writeD(-1);
			writeD(0);
			writeD(-1);
		}
		writeD(itemPrototype.getBonding());
		writeS(itemPrototype.getDescription());
		writeD(itemPrototype.getPageText());
		writeD(itemPrototype.getLanguageID());
		writeD(itemPrototype.getPageMaterial());
		writeD(itemPrototype.getStartQuest());
		writeD(itemPrototype.getLockID());
		writeD(itemPrototype.getMaterial());
		writeD(itemPrototype.getSheath());
		writeD(itemPrototype.getRandomProperty());
		writeD(itemPrototype.getRandomSuffix());
		writeD(itemPrototype.getBlock());
		writeD(itemPrototype.getItemSet());
		writeD(itemPrototype.getMaxDurability());
		writeD(itemPrototype.getArea());
		writeD(itemPrototype.getMap()); // Added in 1.12.x & 2.0.1 client branch
		writeD(itemPrototype.getBagFamily());
		writeD(itemPrototype.getTotemCategory());

		for (int i = 0; i < ItemPrototype.MAX_ITEM_PROTO_SOCKETS; i++) {
			writeD(itemPrototype.getSocket(i).getColor());
			writeD(itemPrototype.getSocket(i).getContent());
		}

		writeD(itemPrototype.getSocketBonus());
		writeD(itemPrototype.getGemProperties());
		writeD(itemPrototype.getRequiredDisenchantSkill());
		writeF(itemPrototype.getArmorDamageModifier());
		writeD(itemPrototype.getDuration()); // added in 2.4.2.8209, duration
												// (seconds)
		writeD(itemPrototype.getItemLimitCategory()); // WotLK,
														// ItemLimitCategory
		writeD(itemPrototype.getHolidayId()); // Holiday.dbc?
	}

}
