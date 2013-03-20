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

import org.jmangos.commons.entities.PlayerXpForLevel;
import org.jmangos.world.dao.PlayerXpForLevelDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class PlayerXpForLevelDaoImpl.
 */
@Repository("playerXpForLevelDao")
public class PlayerXpForLevelDaoImpl implements PlayerXpForLevelDao {

    @PersistenceContext(unitName = "world")
    private EntityManager em;

    @Override
    public PlayerXpForLevel readXpForLevel(final Byte id) {
        return this.em.find(PlayerXpForLevel.class, id);
    }

    @Override
    public List<PlayerXpForLevel> readPlayerXpForLevels() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<PlayerXpForLevel> criteria = builder.createQuery(PlayerXpForLevel.class);
        Root<PlayerXpForLevel> xpRoot = criteria.from(PlayerXpForLevel.class);
        criteria.select(xpRoot);
        return em.createQuery(criteria).getResultList();
    }

    @Transactional(value = "world")
    @Override
    public Byte createOrUpdatePlayerLevelInfo(final PlayerXpForLevel playerXpForLevel) {

        if (playerXpForLevel.getLevel() == null) {
            this.em.persist(playerXpForLevel);
        } else {
            this.em.merge(playerXpForLevel);
        }
        this.em.flush();
        return playerXpForLevel.getLevel();
    }

    @Transactional(value = "world")
    @Override
    public void deletePlayerXpForLevel(final PlayerXpForLevel playerXpForLevel) {

        if (playerXpForLevel == null) {
            return;
        }
        this.em.remove(playerXpForLevel);

    }

}
