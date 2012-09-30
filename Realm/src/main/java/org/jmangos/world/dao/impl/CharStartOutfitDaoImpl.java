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
import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;
import org.jmangos.world.dao.CharStartOutfitDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("charStartOutfitDao")
public class CharStartOutfitDaoImpl implements CharStartOutfitDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public CharStartOutfitEntity readCharStartOutfit(final CharStartOutfitEntityPk pk) {

        return this.entityManager.find(CharStartOutfitEntity.class, pk);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CharStartOutfitEntity> readCharStartOutfits(final Criterion... criterions) {

        final Criteria criteria =
                CriteriaUtils.createCriteria(this.entityManager, CharStartOutfitEntity.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria.getResultList();
    }

    @Transactional(value = "world")
    @Override
    public CharStartOutfitEntityPk createOrUpdateCharStartOutfitEntity(
            final CharStartOutfitEntity charStartOutfitEntity) {

        if (charStartOutfitEntity.getCharStartOutfitEntityPk() == null) {
            this.entityManager.persist(charStartOutfitEntity);
        } else {
            this.entityManager.merge(charStartOutfitEntity);
        }
        this.entityManager.flush();
        return charStartOutfitEntity.getCharStartOutfitEntityPk();
    }

    @Transactional(value = "world")
    @Override
    public void deleteCharStartOutfitEntity(final CharStartOutfitEntity charStartOutfitEntity) {

        if (charStartOutfitEntity == null) {
            return;
        }
        this.entityManager.remove(charStartOutfitEntity);
    }

}
