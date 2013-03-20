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
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.dao.SkillRaceClassDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("skillRaceClassDao")
public class SkillRaceClassDaoImpl implements SkillRaceClassDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public SkillRaceClassInfoEntity readSkillRaceClass(final Integer id) {

        return this.entityManager.find(SkillRaceClassInfoEntity.class, id);
    }

    @Override
    public List<SkillRaceClassInfoEntity> readSkillRaceClasses(final Races race, final Classes clazz) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<SkillRaceClassInfoEntity> criteria =
                builder.createQuery(SkillRaceClassInfoEntity.class);

        final Root<SkillRaceClassInfoEntity> xpRoot = criteria.from(SkillRaceClassInfoEntity.class);

        final ParameterExpression<Integer> classParam = builder.parameter(Integer.class);
        final ParameterExpression<Integer> raceParam = builder.parameter(Integer.class);
        final ParameterExpression<Integer> zeroParam = builder.parameter(Integer.class);

        final Expression<Integer> classFunction =
                builder.function("bitwise_and", Integer.class, xpRoot.get("classmask"), classParam);
        final Expression<Integer> raceFunction =
                builder.function("bitwise_and", Integer.class, xpRoot.get("racemask"), raceParam);
        criteria.where(builder.greaterThan(classFunction, zeroParam),
                builder.greaterThan(raceFunction, zeroParam));

        final TypedQuery<SkillRaceClassInfoEntity> q = this.entityManager.createQuery(criteria);
        q.setParameter(classParam, clazz.getMask());
        q.setParameter(raceParam, race.getMask());
        q.setParameter(zeroParam, 0);
        return q.getResultList();

    }

    @Transactional(value = "world")
    @Override
    public void deleteSkillRaceClass(final SkillRaceClassInfoEntity givenSkillRaceClassInfo) {

        if (givenSkillRaceClassInfo == null) {
            return;
        }
        this.entityManager.remove(givenSkillRaceClassInfo);
    }

}
