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
package org.jmangos.auth.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jmangos.auth.dao.RealmDao;
import org.jmangos.auth.entities.RealmEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("realmDao")
public class RealmDaoImpl implements RealmDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RealmEntity readRealm(final Integer id) {

        return this.entityManager.find(RealmEntity.class, id);
    }

    @Override
    public List<RealmEntity> readRealms() {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<RealmEntity> criteria = builder.createQuery(RealmEntity.class);
        final Root<RealmEntity> root = criteria.from(RealmEntity.class);
        criteria.select(root);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional
    @Override
    public Integer createOrUpdateRealm(final RealmEntity realmEntity) {

        if (realmEntity.getId() == null) {
            this.entityManager.persist(realmEntity);
        } else {
            this.entityManager.merge(realmEntity);
        }
        this.entityManager.flush();
        return realmEntity.getId();
    }

    @Transactional
    @Override
    public void deleteRealm(final RealmEntity realmEntity) {

        if (realmEntity == null) {
            return;
        }
        this.entityManager.remove(realmEntity);
    }

}
