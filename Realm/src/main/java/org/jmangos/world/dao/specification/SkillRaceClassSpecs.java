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

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author MinimaJack
 * 
 */
public class SkillRaceClassSpecs {

    public static Specification<SkillRaceClassInfoEntity> isRaceMatchToRaceMask(final Races race) {
        return new Specification<SkillRaceClassInfoEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillRaceClassInfoEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Expression<Integer> racemask = cb.literal(race.getMask());

                final Expression<Integer> raceFunction =
                        cb.function("bitwise_and", Integer.class, root.<Integer> get("racemask"),
                                racemask);

                return cb.greaterThan(raceFunction, 0);
            }
        };
    }

    public static Specification<SkillRaceClassInfoEntity> isClassMatchToClassMask(final Classes clazz) {
        return new Specification<SkillRaceClassInfoEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillRaceClassInfoEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Expression<Integer> classmask = cb.literal(clazz.getMask());
                final Expression<Integer> classFunction =
                        cb.function("bitwise_and", Integer.class, root.<Integer> get("classmask"),
                                classmask);

                return cb.greaterThan(classFunction, 0);
            }
        };
    }

}
