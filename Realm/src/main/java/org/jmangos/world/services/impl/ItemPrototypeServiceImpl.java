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
package org.jmangos.world.services.impl;

import java.util.List;

import org.jmangos.commons.entities.ItemPrototype;
import org.jmangos.world.dao.ItemPrototypeDao;
import org.jmangos.world.services.ItemPrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemPrototypeService")
public class ItemPrototypeServiceImpl implements ItemPrototypeService {

    @Autowired
    private ItemPrototypeDao itemPrototypeDao;

    @Override
    public ItemPrototype readItemPrototype(final Integer id) {

        return this.itemPrototypeDao.readItemPrototype(id);
    }

    @Override
    public List<ItemPrototype> readItemPrototypes() {

        return this.itemPrototypeDao.readItemPrototypes();
    }

    @Override
    public Integer createOrUpdateItemPrototype(final ItemPrototype itemPrototype) {

        return this.itemPrototypeDao.createOrUpdateItemPrototype(itemPrototype);
    }

    @Override
    public void deleteItemPrototype(final ItemPrototype itemPrototype) {

        this.itemPrototypeDao.deleteItemPrototype(itemPrototype);
    }

}
