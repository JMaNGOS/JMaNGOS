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
import org.jmangos.realm.domain.PlayerLevelInfoPK;
import org.jmangos.world.dao.PlayerLevelInfoDao;
import org.jmangos.world.entities.PlayerLevelInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("playerLevelInfoDao")
public class PlayerLevelInfoDaoImpl implements PlayerLevelInfoDao {
    
    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;
    
    @Override
    public PlayerLevelInfo readPlayerLevelInfo(final PlayerLevelInfoPK pk) {
    
        return this.entityManager.find(PlayerLevelInfo.class, pk);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<PlayerLevelInfo> readPlayerLevelInfos(final Criterion... criterions) {
    
        final Criteria criteria = CriteriaUtils.createCriteria(this.entityManager, PlayerLevelInfo.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria.getResultList();
    }
    
    @Transactional
    @Override
    public PlayerLevelInfoPK createOrUpdatePlayerLevelInfo(final PlayerLevelInfo playerLevelInfo) {
    
        if (playerLevelInfo.getPlayerLevelInfoPK() == null) {
            this.entityManager.persist(playerLevelInfo);
        } else {
            this.entityManager.merge(playerLevelInfo);
        }
        this.entityManager.flush();
        return playerLevelInfo.getPlayerLevelInfoPK();
    }
    
    @Transactional
    @Override
    public void deletePlayerLevelInfo(final PlayerLevelInfo playerLevelInfo) {
    
        if (playerLevelInfo == null) {
            return;
        }
        this.entityManager.remove(playerLevelInfo);
    }
    
}
