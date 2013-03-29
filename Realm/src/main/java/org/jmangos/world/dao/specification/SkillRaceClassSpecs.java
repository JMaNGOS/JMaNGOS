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
