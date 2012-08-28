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

import gnu.trove.map.hash.TLongObjectHashMap;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jmangos.commons.dataholder.DataLoadService;
import org.jmangos.realm.domain.InventoryItem;
import org.jmangos.realm.model.base.item.Bag;
import org.jmangos.realm.model.base.item.Item;
import org.jmangos.realm.model.base.update.ItemFields;
import org.jmangos.realm.model.enums.HighGuid;
import org.jmangos.realm.model.enums.InventoryType;
import org.jmangos.world.entities.ItemPrototype;
import org.jmangos.world.services.ItemPrototypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class ItemStorages.
 */
@Component
public class ItemStorages implements DataLoadService<TLongObjectHashMap<ItemPrototype>> {
    
    /** The Constant logger. */
    private static final Logger               logger         = LoggerFactory.getLogger(ItemStorages.class);
    
    @Inject
    private ItemPrototypeService              itemPrototypeService;
    
    /** The item prototypes. */
    private TLongObjectHashMap<ItemPrototype> itemPrototypes = new TLongObjectHashMap<ItemPrototype>();
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#get()
     */
    @Override
    public TLongObjectHashMap<ItemPrototype> get() {
    
        return this.itemPrototypes;
    }
    
    /**
     * Gets the.
     * 
     * @param guid
     *            the guid
     * @return the item prototype
     */
    public ItemPrototype get(final int guid) {
    
        if (this.itemPrototypes.containsKey(guid)) {
            logger.debug(String.format("The specified id: %d hit in the storage! DisplayInfoID: %d", guid, this.itemPrototypes.get(guid).getDisplayInfoID()));
            return this.itemPrototypes.get(guid);
        } else {
            logger.debug(String.format("The specified id: %d not in the store. Trying to load directly from the database!", guid));
            final ItemPrototype ip = this.itemPrototypeService.readItemPrototype(guid);
            if (ip != null) {
                this.itemPrototypes.put(ip.getObjectId(), ip);
                return ip;
            }
        }
        return null;
    }
    
    /**
     * Load from db.
     * 
     * @param itemplate
     *            the itemplate
     * @param proto
     *            the proto
     * @return the item
     */
    public Item loadFromDB(final InventoryItem itemplate, final ItemPrototype proto) {
    
        final long guid = (HighGuid.ITEM.getValue() << 48) | itemplate.getItem_guid();
        Item item = null;
        if (proto.getInventoryType() == InventoryType.BAG) {
            item = new Bag(guid);
        } else {
            item = new Item(guid);
        }
        item.initfields();
        if (item.loadValues(itemplate.getData().split(" "))) {
            logger.debug("Good items " + proto.getName() + " count " + item.GetUInt32Value(ItemFields.ITEM_FIELD_STACK_COUNT));
            
            return item;
        } else {
            logger.debug("Bad items" + proto.getName());
            return null;
        }
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#load()
     */
    @Override
    public TLongObjectHashMap<ItemPrototype> load() {
    
        Long eTime = System.currentTimeMillis();
        
        final TLongObjectHashMap<ItemPrototype> map = new TLongObjectHashMap<ItemPrototype>();
        final List<ItemPrototype> itemPrototypeList = this.itemPrototypeService.readItemPrototypes();
        
        // Fill map
        for (final ItemPrototype item : itemPrototypeList) {
            map.put(item.getEntry(), item);
        }
        
        eTime = System.currentTimeMillis() - eTime;
        ItemStorages.logger.info(String.format("Loaded [%d] ItemPrototypes under %d ms", map.size(), eTime));
        
        this.itemPrototypes = map;
        return this.itemPrototypes;
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#reload()
     */
    @Override
    public void reload() {
    
        final TLongObjectHashMap<ItemPrototype> itemProrotypesTemp = load();
        this.itemPrototypes = itemProrotypesTemp;
    }
    
    /**
     * 
     * @see org.jmangos.commons.dataholder.DataLoadService#save()
     */
    @Override
    public void save() {
    
        // TODO Save in xml?
        
    }
    
    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {
    
        load();
    }
    
    /**
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        this.itemPrototypes.clear();
    }
    
}
