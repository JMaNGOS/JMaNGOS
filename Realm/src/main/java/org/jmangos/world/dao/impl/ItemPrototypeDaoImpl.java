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
package org.jmangos.world.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.ItemPrototype;
import org.jmangos.world.dao.ItemPrototypeDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("itemPrototypeDao")
public class ItemPrototypeDaoImpl implements ItemPrototypeDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public ItemPrototype readItemPrototype(final Integer id) {

        return this.entityManager.find(ItemPrototype.class, id);
    }

    @Override
    public List<ItemPrototype> readItemPrototypes() {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<ItemPrototype> criteria = builder.createQuery(ItemPrototype.class);
        final Root<ItemPrototype> root = criteria.from(ItemPrototype.class);
        criteria.select(root);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional(value = "world")
    @Override
    public Integer createOrUpdateItemPrototype(final ItemPrototype itemPrototype) {

        if (itemPrototype.getEntry() == null) {
            this.entityManager.persist(itemPrototype);
        } else {
            this.entityManager.merge(itemPrototype);
        }
        this.entityManager.flush();
        return itemPrototype.getEntry();
    }

    @Transactional(value = "world")
    @Override
    public void deleteItemPrototype(final ItemPrototype itemPrototype) {

        if (itemPrototype == null) {
            return;
        }
        this.entityManager.remove(itemPrototype);
    }

}
