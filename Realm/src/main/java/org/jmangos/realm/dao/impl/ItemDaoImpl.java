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
package org.jmangos.realm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.FieldsItem;
import org.jmangos.realm.dao.ItemDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext(unitName = "realm")
    private EntityManager entityManager;

    @Override
    public FieldsItem readItem(final Long id) {

        return this.entityManager.find(FieldsItem.class, id);
    }

    @Override
    public List<FieldsItem> readItems() {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<FieldsItem> criteria = builder.createQuery(FieldsItem.class);
        final Root<FieldsItem> root = criteria.from(FieldsItem.class);
        criteria.select(root);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional(value = "realm")
    @Override
    public Long createOrUpdateItem(final FieldsItem givenItem) {

        if (givenItem.getGuid() == null) {
            this.entityManager.persist(givenItem);
        } else {
            this.entityManager.merge(givenItem);
        }
        this.entityManager.flush();
        return givenItem.getGuid();
    }

    @Transactional(value = "realm")
    @Override
    public void deleteItem(final FieldsItem givenItem) {

        if (givenItem == null) {
            return;
        }
        this.entityManager.remove(givenItem);
    }

}
