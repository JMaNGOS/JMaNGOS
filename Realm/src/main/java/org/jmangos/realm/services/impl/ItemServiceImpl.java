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

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.dao.ItemDao;
import org.jmangos.realm.entities.ItemEntity;
import org.jmangos.realm.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    
    @Autowired
    private ItemDao itemDao;
    
    @Override
    public ItemEntity readItem(final Integer id) {
    
        return this.itemDao.readItem(id);
    }
    
    @Override
    public List<ItemEntity> readItems(final Criterion... criterions) {
    
        return this.itemDao.readItems(criterions);
    }
    
    @Override
    public Integer createOrUpdateItem(final ItemEntity itemEntity) {
    
        return this.itemDao.createOrUpdateItem(itemEntity);
    }
    
    @Override
    public void deleteItem(final ItemEntity itemEntity) {
    
        this.itemDao.deleteItem(itemEntity);
    }
    
}
