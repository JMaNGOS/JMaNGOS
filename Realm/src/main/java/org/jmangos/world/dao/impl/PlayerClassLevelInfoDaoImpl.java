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

import org.criteria4jpa.Criteria;
import org.criteria4jpa.CriteriaUtils;
import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.domain.PlayerClassLevelInfoPK;
import org.jmangos.world.dao.PlayerClassLevelInfoDao;
import org.jmangos.world.entities.PlayerClassLevelInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("playerClassLevelInfoDao")
public class PlayerClassLevelInfoDaoImpl implements PlayerClassLevelInfoDao {
    
    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;
    
    @Override
    public PlayerClassLevelInfo readPlayerClassLevelInfo(final PlayerClassLevelInfoPK pk) {
    
        return this.entityManager.find(PlayerClassLevelInfo.class, pk);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<PlayerClassLevelInfo> readPlayerClassLevelInfos(final Criterion... criterions) {
    
        final Criteria criteria = CriteriaUtils.createCriteria(this.entityManager, PlayerClassLevelInfo.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria.getResultList();
    }
    
    @Transactional(value = "world")
    @Override
    public PlayerClassLevelInfoPK createOrUpdatePlayerClassLevelInfo(final PlayerClassLevelInfo playerClassLevelInfo) {
    
        if (playerClassLevelInfo.getPlayerClassLevelInfoPK() == null) {
            this.entityManager.persist(playerClassLevelInfo);
        } else {
            this.entityManager.merge(playerClassLevelInfo);
        }
        this.entityManager.flush();
        return playerClassLevelInfo.getPlayerClassLevelInfoPK();
    }
    
    @Transactional(value = "world")
    @Override
    public void deletePlayerClassLevelInfo(final PlayerClassLevelInfo playerClassLevelInfo) {
    
        if (playerClassLevelInfo == null) {
            return;
        }
        this.entityManager.remove(playerClassLevelInfo);
    }
    
}
