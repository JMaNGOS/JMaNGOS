/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
/**
 * 
 */
package org.jmangos.world.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author MinimaJack
 * 
 */
public class SkillLineAbilitySpecs {

    public static Specification<SkillLineAbilityEntity> isRaceMatchToRaceMask(final Races race) {
        return new Specification<SkillLineAbilityEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillLineAbilityEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Expression<Integer> racemask = cb.literal(race.getMask());

                final Expression<Integer> raceFunction =
                        cb.function("bitwise_and", Integer.class, root.<Integer> get("racemask"),
                                racemask);

                return cb.or(cb.greaterThan(raceFunction, 0), cb.equal(root.get("racemask"), 0));
            }
        };
    }

    public static Specification<SkillLineAbilityEntity> isClassMatchToClassMask(final Classes clazz) {
        return new Specification<SkillLineAbilityEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillLineAbilityEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Expression<Integer> classmask = cb.literal(clazz.getMask());
                final Expression<Integer> classFunction =
                        cb.function("bitwise_and", Integer.class, root.<Integer> get("classmask"),
                                classmask);

                return cb.or(cb.greaterThan(classFunction, 0), cb.equal(root.get("classmask"), 0));
            }
        };
    }

    public static Specification<SkillLineAbilityEntity> isLearnOnGetSkill() {
        return new Specification<SkillLineAbilityEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillLineAbilityEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {

                return cb.greaterThan(root.<Integer> get("learnOnGetSkill"), 1);
            }
        };
    }

    public static Specification<SkillLineAbilityEntity> isSkill(final Integer skillId) {
        return new Specification<SkillLineAbilityEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillLineAbilityEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {

                return cb.equal(root.get("skillId"), skillId);
            }
        };
    }
}
