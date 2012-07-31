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

import gnu.trove.TIntObjectHashMap;

import javax.inject.Inject;

import org.JMANGOS.realm.dao.ItemDAO;
import org.JMANGOS.realm.model.InventoryTemplate;
import org.JMANGOS.realm.model.base.guid.HighGuid;
import org.JMANGOS.realm.model.base.item.Bag;
import org.JMANGOS.realm.model.base.item.InventoryType;
import org.JMANGOS.realm.model.base.item.Item;
import org.JMANGOS.realm.model.base.item.ItemPrototype;
import org.JMANGOS.realm.model.base.update.ItemFields;
import org.apache.log4j.Logger;
import org.JMANGOS.common.dataholder.DataLoadService;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemStorages.
 */
public class ItemStorages
		implements
			DataLoadService<TIntObjectHashMap<ItemPrototype>> {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(ItemStorages.class);

	/** The item dao. */
	@Inject
	private ItemDAO itemDAO;

	/** The item prototypes. */
	private TIntObjectHashMap<ItemPrototype> itemPrototypes = new TIntObjectHashMap<ItemPrototype>();

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#get()
	 */
	@Override
	public TIntObjectHashMap<ItemPrototype> get() {
		return itemPrototypes;
	}

	/**
	 * Gets the.
	 *
	 * @param guid the guid
	 * @return the item prototype
	 */
	public ItemPrototype get(int guid) {
		if (itemPrototypes.contains(guid)) {
			return itemPrototypes.get(guid);
		} else {
			ItemPrototype ip = itemDAO.loadItemPrototype(guid);
			if (ip != null) {
				itemPrototypes.put(ip.getObjectId(), ip);
				return ip;
			}
		}
		return null;
	}

	/**
	 * Load from db.
	 *
	 * @param itemplate the itemplate
	 * @param proto the proto
	 * @return the item
	 */
	public Item loadFromDB(InventoryTemplate itemplate, ItemPrototype proto) {
		long guid = HighGuid.HIGHGUID_ITEM.getValue() << 48| itemplate.getItem_guid();
		Item item = null;
		if(proto.getInventoryType() == InventoryType.INVTYPE_BAG){
			item = new Bag(guid);
		}
		else{
			item = new Item(guid);
		}
		item.initfields();
		if (item.loadValues(itemplate.getData().split(" "))) {
			logger.info("Good items " + proto.getName() + " count " + item.GetUInt32Value(ItemFields.ITEM_FIELD_STACK_COUNT));
			
			return item;
		} else {
			logger.info("Bad items" + proto.getName());
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#load()
	 */
	@Override
	public TIntObjectHashMap<ItemPrototype> load() {
		itemPrototypes = itemDAO.loadItemPrototypes();
		return itemPrototypes;
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#reload()
	 */
	@Override
	public TIntObjectHashMap<ItemPrototype> reload() {
		itemPrototypes.clear();
		return load();
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.dataholder.DataLoadService#save()
	 */
	@Override
	public void save() {
		// TODO Save in xml?

	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		load();
		logger.info("Loaded " + itemPrototypes.size() + " ItemPrototypes");
	}

	/* (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		itemPrototypes.clear();
	}

}
