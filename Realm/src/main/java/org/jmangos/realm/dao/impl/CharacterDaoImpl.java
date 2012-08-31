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
package org.jmangos.realm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.criteria4jpa.Criteria;
import org.criteria4jpa.CriteriaUtils;
import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.dao.CharacterDao;
import org.jmangos.realm.entities.CharacterEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("characterDao")
public class CharacterDaoImpl implements CharacterDao {
    
    @PersistenceContext(unitName = "realm")
    private EntityManager entityManager;
    
    @Override
    public CharacterEntity readCharacter(final Integer id) {
    
        return this.entityManager.find(CharacterEntity.class, id);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<CharacterEntity> readCharacters(final Criterion... criterions) {
    
        final Criteria criteria = CriteriaUtils.createCriteria(this.entityManager, CharacterEntity.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria.getResultList();
    }
    
    @Transactional(value = "realm")
    @Override
    public Integer createOrUpdateCharacter(final CharacterEntity characterEntity) {
    
        if (characterEntity.getGuid() == null) {
            this.entityManager.persist(characterEntity);
        } else {
            this.entityManager.merge(characterEntity);
        }
        this.entityManager.flush();
        return characterEntity.getGuid();
    }
    
    @Transactional(value = "realm")
    @Override
    public void deleteCharacter(final CharacterEntity characterEntity) {
    
        if (characterEntity == null) {
            return;
        }
        this.entityManager.remove(characterEntity);
    }
    
}
