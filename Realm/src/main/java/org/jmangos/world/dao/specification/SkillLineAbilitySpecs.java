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
