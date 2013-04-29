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
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.CreaturePositionerHolder;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.model.base.NestedMap;
import org.springframework.data.jpa.domain.Specification;

/**
 * <p>
 * <ol>
 * <li><b>Class:</b> <tt>SkillLineAbilitySpecs</tt> contains specification for
 * {@link SkillLineAbilityEntity}
 * <ol>
 * <b>Specifications:</b>
 * <li>isRaceMatchToRaceMask
 * <li>isClassMatchToClassMask
 * <li>isLearnOnGetSkill
 * <li>isSkill
 * </ol>
 * <li><b>Used in:
 * {@link org.jmangos.world.services.impl.SkillLineAbilityServiceImpl}</b>
 * </ol>
 * </p>
 * 
 * @author MinimaJack
 */
public class CreatureDataSpecs {

    public static Specification<Creature> isWithinCoords(final Position poslc, final Position posrc) {
        return new Specification<Creature>() {

            @Override
            public Predicate toPredicate(final Root<Creature> root, final CriteriaQuery<?> query,
                    final CriteriaBuilder cb) {
                final Path<CreaturePositionerHolder> mov =
                        root.<CreaturePositionerHolder> get("movement");
                final Path<Position> position = mov.<Position> get("position");
                final Predicate y =
                        cb.between(position.<Float> get("y"), poslc.getY(), posrc.getY());
                final Predicate x =
                        cb.between(position.<Float> get("x"), poslc.getX(), posrc.getX());
                return cb.and(y, x);
            }
        };
    }

    public static Specification<Creature> isInMap(final NestedMap map) {
        return new Specification<Creature>() {

            @Override
            public Predicate toPredicate(final Root<Creature> root, final CriteriaQuery<?> query,
                    final CriteriaBuilder cb) {
                final Path<CreaturePositionerHolder> mov =
                        root.<CreaturePositionerHolder> get("movement");
                return cb.equal(mov.get("map"), map.getId());
            }
        };
    }

    public static Specification<Creature> isHaveId(final Integer id) {
        return new Specification<Creature>() {

            @Override
            public Predicate toPredicate(final Root<Creature> root, final CriteriaQuery<?> query,
                    final CriteriaBuilder cb) {

                return cb.equal(root.get("entry"), id);
            }
        };
    }
}
