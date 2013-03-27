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
import org.springframework.data.jpa.domain.Specification;

/**
 * @author MinimaJack
 * 
 */
public class SkillRaceClassSpecs {

    public static Specification<SkillRaceClassInfoEntity> isMatchRaceMask(final Integer raceMask) {
        return new Specification<SkillRaceClassInfoEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillRaceClassInfoEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Expression<Integer> racemask = cb.literal(raceMask);

                final Expression<Integer> raceFunction =
                        cb.function("bitwise_and", Integer.class, root.<Integer> get("racemask"),
                                racemask);

                return cb.greaterThan(raceFunction, 0);
            }
        };
    }

    public static Specification<SkillRaceClassInfoEntity> isMatchClassMask(final Integer classMask) {
        return new Specification<SkillRaceClassInfoEntity>() {

            @Override
            public Predicate toPredicate(final Root<SkillRaceClassInfoEntity> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                final Expression<Integer> classmask = cb.literal(classMask);
                final Expression<Integer> classFunction =
                        cb.function("bitwise_and", Integer.class, root.<Integer> get("classmask"),
                                classmask);

                return cb.greaterThan(classFunction, 0);
            }
        };
    }

}
