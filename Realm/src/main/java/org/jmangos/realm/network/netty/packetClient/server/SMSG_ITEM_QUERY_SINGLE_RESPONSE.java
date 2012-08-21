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
package org.jmangos.realm.network.netty.packetClient.server;

import org.jmangos.realm.domain.ItemPrototype;
import org.jmangos.realm.network.netty.packetClient.AbstractWoWServerPacket;

/**
 * The Class SMSG_ITEM_QUERY_SINGLE_RESPONSE.
 */
public class SMSG_ITEM_QUERY_SINGLE_RESPONSE extends AbstractWoWServerPacket {
    
    /** The item prototype. */
    private final ItemPrototype itemPrototype;
    
    /**
     * Instantiates a new sMS g_ ite m_ quer y_ singl e_ response.
     * 
     * @param itemPrototype
     *            the item prototype
     */
    public SMSG_ITEM_QUERY_SINGLE_RESPONSE(final ItemPrototype itemPrototype) {
    
        this.itemPrototype = itemPrototype;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    protected void writeImpl() {
    
        writeD(this.itemPrototype.getObjectId());
        writeD(this.itemPrototype.getClazz());
        writeD(this.itemPrototype.getSubClass());
        writeD(this.itemPrototype.getUnk0());
        writeS(this.itemPrototype.getItemName());
        writeC(0);
        writeC(0);
        writeC(0);
        writeD(this.itemPrototype.getDisplayInfoID());
        writeD(this.itemPrototype.getQuality());
        writeD(this.itemPrototype.getFlags() & 0xFFFFFFFF);
        writeD(this.itemPrototype.getFlags2() & 0xFFFFFFFF);
        writeD(this.itemPrototype.getBuyPrice());
        writeD(this.itemPrototype.getSellPrice());
        writeD(this.itemPrototype.getInventoryType().ordinal());
        writeD(this.itemPrototype.getAllowableClass());
        writeD(this.itemPrototype.getAllowableRace());
        writeD(this.itemPrototype.getItemLevel());
        writeD(this.itemPrototype.getRequiredLevel());
        writeD(this.itemPrototype.getRequiredSkill());
        writeD(this.itemPrototype.getRequiredSkillRank());
        writeD(this.itemPrototype.getRequiredSpell());
        writeD(this.itemPrototype.getRequiredHonorRank());
        writeD(this.itemPrototype.getRequiredCityRank());
        writeD(this.itemPrototype.getRequiredReputationFaction());
        writeD(this.itemPrototype.getRequiredReputationRank());
        
        writeD(this.itemPrototype.getMaxCount());
        writeD(this.itemPrototype.getStackable());
        writeD(this.itemPrototype.getContainerSlots());
        writeD(this.itemPrototype.getStatsCount());
        for (int i = 0; i < this.itemPrototype.getStatsCount(); i++) {
            // writeD(itemPrototype.getItemStat(i).getItemStatType());
            // writeD(itemPrototype.getItemStat(i).getItemStatValue());
            // TODO:reimplement to ItemPrototype
            writeD(0);
            writeD(0);
        }
        writeD(this.itemPrototype.getScalingStatDistribution());
        writeD(this.itemPrototype.getScalingStatValue());
        
        for (int i = 0; i < ItemPrototype.MAX_ITEM_PROTO_DAMAGES; i++) {
            // writeF(itemPrototype.getDamage(i).getDamageMin());
            // writeF(itemPrototype.getDamage(i).getDamageMax());
            // writeD(itemPrototype.getDamage(i).getDamageType());
            // TODO:implement to ItemPrototype
            writeF(0.0f);
            writeF(0.0f);
            writeD(0);
        }
        
        writeD(this.itemPrototype.getArmor());
        writeD(this.itemPrototype.getHolyRes());
        writeD(this.itemPrototype.getFireRes());
        writeD(this.itemPrototype.getNatureRes());
        writeD(this.itemPrototype.getFrostRes());
        writeD(this.itemPrototype.getShadowRes());
        writeD(this.itemPrototype.getArcaneRes());
        writeD(this.itemPrototype.getDelay());
        writeD(this.itemPrototype.getAmmoType());
        writeF(this.itemPrototype.getRangedModRange());
        
        for (int i = 0; i < ItemPrototype.MAX_ITEM_PROTO_SPELLS; i++) {
            
            writeD(0);
            writeD(0);
            writeD(0);
            writeD(-1);
            writeD(0);
            writeD(-1);
        }
        writeD(this.itemPrototype.getBonding());
        writeS(this.itemPrototype.getDescription());
        writeD(this.itemPrototype.getPageText());
        writeD(this.itemPrototype.getLanguageID());
        writeD(this.itemPrototype.getPageMaterial());
        writeD(this.itemPrototype.getStartQuest());
        writeD(this.itemPrototype.getLockID());
        writeD(this.itemPrototype.getMaterial());
        writeD(this.itemPrototype.getSheath());
        writeD(this.itemPrototype.getRandomProperty());
        writeD(this.itemPrototype.getRandomSuffix());
        writeD(this.itemPrototype.getBlock());
        writeD(this.itemPrototype.getItemSet());
        writeD(this.itemPrototype.getMaxDurability());
        writeD(this.itemPrototype.getArea());
        writeD(this.itemPrototype.getMap()); // Added in 1.12.x & 2.0.1 client branch
        writeD(this.itemPrototype.getBagFamily());
        writeD(this.itemPrototype.getTotemCategory());
        
        for (int i = 0; i < ItemPrototype.MAX_ITEM_PROTO_SOCKETS; i++) {
            writeD(this.itemPrototype.getSocket(i).getColor());
            writeD(this.itemPrototype.getSocket(i).getContent());
        }
        
        writeD(this.itemPrototype.getSocketBonus());
        writeD(this.itemPrototype.getGemProperties());
        writeD(this.itemPrototype.getRequiredDisenchantSkill());
        writeF(this.itemPrototype.getArmorDamageModifier());
        writeD(this.itemPrototype.getDuration()); // added in 2.4.2.8209, duration
                                                  // (seconds)
        writeD(this.itemPrototype.getItemLimitCategory()); // WotLK,
                                                           // ItemLimitCategory
        writeD(this.itemPrototype.getHolidayId()); // Holiday.dbc?
    }
    
}
