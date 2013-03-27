/**
 * 
 */
package org.jmangos.realm.dao.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.CharacterData;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author MinimaJack
 * 
 */
public class CharacterSpecs {

    public static Specification<CharacterData> isMatchName(final String name) {
        return new Specification<CharacterData>() {

            @Override
            public Predicate toPredicate(final Root<CharacterData> root,
                    final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                return cb.equal(root.<String> get("name"), name);
            }
        };
    }

}
