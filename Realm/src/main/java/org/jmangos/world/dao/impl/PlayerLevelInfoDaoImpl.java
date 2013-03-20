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

import org.jmangos.commons.entities.PlayerLevelInfo;
import org.jmangos.commons.entities.pk.PlayerLevelInfoPK;
import org.jmangos.world.dao.PlayerLevelInfoDao;
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
    public List<PlayerLevelInfo> readPlayerLevelInfos() {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<PlayerLevelInfo> criteria = builder.createQuery(PlayerLevelInfo.class);
        final Root<PlayerLevelInfo> root = criteria.from(PlayerLevelInfo.class);
        criteria.select(root);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional(value = "world")
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

    @Transactional(value = "world")
    @Override
    public void deletePlayerLevelInfo(final PlayerLevelInfo playerLevelInfo) {

        if (playerLevelInfo == null) {
            return;
        }
        this.entityManager.remove(playerLevelInfo);
    }

}
