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
package org.jmangos.realm.services.impl;

import java.util.List;

import org.jmangos.commons.entities.FieldsContainer;
import org.jmangos.commons.entities.FieldsItem;
import org.jmangos.commons.entities.ItemPrototype;
import org.jmangos.commons.enums.ItemClass;
import org.jmangos.commons.enums.ItemFlags;
import org.jmangos.realm.dao.ItemDao;
import org.jmangos.realm.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Override
    public FieldsItem readItem(final Long id) {

        return this.itemDao.readItem(id);
    }

    @Override
    public List<FieldsItem> readItems() {

        return this.itemDao.readItems();
    }

    @Override
    public Long createOrUpdateItem(final FieldsItem item) {

        return this.itemDao.createOrUpdateItem(item);
    }

    @Override
    public void deleteItem(final FieldsItem item) {

        this.itemDao.deleteItem(item);
    }

    @Override
    public FieldsItem createItem(final ItemPrototype itemProto, int itemCount) {

        FieldsItem item = null;
        if (itemProto.getStackable() < itemCount) {
            itemCount = itemProto.getStackable();
        }

        if ((itemProto.getClazz() == ItemClass.CONTAINER.ordinal()) ||
            (itemProto.getClazz() == ItemClass.QUIVER.ordinal())) {
            item = new FieldsContainer();
            ((FieldsContainer) item).setSlotsCount((byte) itemProto.getContainerSlots());
        } else {
            item = new FieldsItem();
        }
        item.setPrototype(itemProto);
        item.setEntry(itemProto.getEntry());
        item.setDurability(itemProto.getMaxDurability());
        item.setMaxDurability(itemProto.getMaxDurability());
        item.setStackCount(itemCount);
        item.setFlags(ItemFlags.JUST_CREATED.getValue());
        this.itemDao.createOrUpdateItem(item);
        item.initBits();

        return item;
    }

}
