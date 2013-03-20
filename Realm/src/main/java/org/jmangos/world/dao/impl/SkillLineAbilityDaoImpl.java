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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.dao.SkillLineAbilityDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("skillLineAbilityDao")
public class SkillLineAbilityDaoImpl implements SkillLineAbilityDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public SkillLineAbilityEntity readSkillLineAbility(final Integer id) {

        return this.entityManager.find(SkillLineAbilityEntity.class, id);
    }

    @Transactional(value = "world")
    @Override
    public void deleteSkillLineAbility(final SkillLineAbilityEntity givenSkillLineAbilityEntity) {

        if (givenSkillLineAbilityEntity == null) {
            return;
        }
        this.entityManager.remove(givenSkillLineAbilityEntity);
    }

    @Override
    public List<SkillLineAbilityEntity> getAbilitiesForRaceClassSkill(final Races race,
            final Classes clazz, final int skill) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<SkillLineAbilityEntity> criteria =
                builder.createQuery(SkillLineAbilityEntity.class);

        final Root<SkillLineAbilityEntity> xpRoot = criteria.from(SkillLineAbilityEntity.class);

        final ParameterExpression<Integer> classParam = builder.parameter(Integer.class);
        final ParameterExpression<Integer> raceParam = builder.parameter(Integer.class);
        final ParameterExpression<Integer> skillParam = builder.parameter(Integer.class);
        final ParameterExpression<Integer> zeroParam = builder.parameter(Integer.class);

        final Expression<Integer> classFunction =
                builder.function("bitwise_and", Integer.class, xpRoot.get("classmask"), classParam);
        final Expression<Integer> raceFunction =
                builder.function("bitwise_and", Integer.class, xpRoot.get("racemask"), raceParam);

        final Predicate pClass =
                builder.or(builder.greaterThan(classFunction, zeroParam),
                        builder.equal(xpRoot.get("classmask"), 0));
        final Predicate pSkill = builder.equal(xpRoot.get("skillId"), skillParam);
        @SuppressWarnings({ "unchecked", "rawtypes" })
        final Predicate pLearnOnGetSkill =
                builder.gt((Expression) xpRoot.get("learnOnGetSkill"), 1);

        final Predicate pRace =
                builder.or(builder.greaterThan(raceFunction, zeroParam),
                        builder.equal(xpRoot.get("racemask"), 0));

        criteria.where(pClass, pRace, pLearnOnGetSkill, pSkill);

        final TypedQuery<SkillLineAbilityEntity> q = this.entityManager.createQuery(criteria);
        q.setParameter(classParam, clazz.getMask());
        q.setParameter(raceParam, race.getMask());
        q.setParameter(skillParam, skill);
        q.setParameter(zeroParam, 0);
        return q.getResultList();
    }

}
