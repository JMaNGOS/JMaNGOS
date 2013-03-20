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

import org.jmangos.commons.entities.SpellEntity;
import org.jmangos.world.dao.SpellDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("spellDao")
public class SpellDaoImpl implements SpellDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public SpellEntity readSpell(final Integer id) {

        return this.entityManager.find(SpellEntity.class, id);
    }

    @Override
    public List<SpellEntity> readSpells() {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<SpellEntity> criteria = builder.createQuery(SpellEntity.class);
        final Root<SpellEntity> xpRoot = criteria.from(SpellEntity.class);
        criteria.select(xpRoot);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional(value = "world")
    @Override
    public Integer createOrUpdateSpell(final SpellEntity givenSpell) {

        if (givenSpell.getId() == null) {
            this.entityManager.persist(givenSpell);
        } else {
            this.entityManager.merge(givenSpell);
        }
        this.entityManager.flush();
        return givenSpell.getId();
    }

    @Transactional(value = "world")
    @Override
    public void deleteSpell(final SpellEntity givenSpell) {

        if (givenSpell == null) {
            return;
        }
        this.entityManager.remove(givenSpell);
    }

}
