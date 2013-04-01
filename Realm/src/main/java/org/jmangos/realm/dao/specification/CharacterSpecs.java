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
