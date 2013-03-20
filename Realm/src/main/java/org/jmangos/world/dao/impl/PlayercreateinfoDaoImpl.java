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

import org.jmangos.commons.entities.Playercreateinfo;
import org.jmangos.commons.entities.pk.PlayercreateinfoPK;
import org.jmangos.world.dao.PlayercreateinfoDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("playercreateinfoDao")
public class PlayercreateinfoDaoImpl implements PlayercreateinfoDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public Playercreateinfo readPlayercreateinfo(final PlayercreateinfoPK pk) {

        return this.entityManager.find(Playercreateinfo.class, pk);
    }

    @Override
    public List<Playercreateinfo> readPlayercreateinfos() {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Playercreateinfo> criteria =
                builder.createQuery(Playercreateinfo.class);
        final Root<Playercreateinfo> root = criteria.from(Playercreateinfo.class);
        criteria.select(root);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional(value = "world")
    @Override
    public PlayercreateinfoPK createOrUpdatePlayercreateinfo(final Playercreateinfo playercreateinfo) {

        if (playercreateinfo.getPlayercreateinfoPK() == null) {
            this.entityManager.persist(playercreateinfo);
        } else {
            this.entityManager.merge(playercreateinfo);
        }
        this.entityManager.flush();
        return playercreateinfo.getPlayercreateinfoPK();
    }

    @Transactional(value = "world")
    @Override
    public void deletePlayercreateinfo(final Playercreateinfo playercreateinfo) {

        if (playercreateinfo == null) {
            return;
        }
        this.entityManager.remove(playercreateinfo);
    }

}
