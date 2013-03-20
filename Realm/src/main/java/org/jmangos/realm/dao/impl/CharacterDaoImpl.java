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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.realm.dao.CharacterDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("characterDao")
public class CharacterDaoImpl implements CharacterDao {

    @PersistenceContext(unitName = "realm")
    private EntityManager entityManager;

    @Override
    public CharacterData readCharacter(final Long id) {

        return this.entityManager.find(CharacterData.class, id);
    }

    @Override
    public List<CharacterData> readCharacters() {

        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<CharacterData> criteria = builder.createQuery(CharacterData.class);
        final Root<CharacterData> root = criteria.from(CharacterData.class);
        criteria.select(root);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public CharacterData readCharacterByName(String name) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<CharacterData> criteria = builder.createQuery(CharacterData.class);
        final Root<CharacterData> root = criteria.from(CharacterData.class);
        criteria.select(root);
        final Predicate pName = builder.equal(root.get("name"), name);
        criteria.where(pName);
        List<CharacterData> results = this.entityManager.createQuery(criteria).getResultList();
        if (!results.isEmpty()) {
            return results.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<CharacterData> readCharacterByName(Long accountId) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<CharacterData> criteria = builder.createQuery(CharacterData.class);
        final Root<CharacterData> root = criteria.from(CharacterData.class);
        criteria.select(root);
        final Predicate pAccountId = builder.equal(root.get("account"), accountId);
        criteria.where(pAccountId);
        return this.entityManager.createQuery(criteria).getResultList();
    }

    @Transactional(value = "realm")
    @Override
    public Long createOrUpdateCharacter(final CharacterData characterData) {

        if (characterData.getGuid() == null) {
            this.entityManager.persist(characterData);
        } else {
            this.entityManager.merge(characterData);
        }
        this.entityManager.flush();
        return characterData.getGuid();
    }

    @Transactional(value = "realm")
    @Override
    public void deleteCharacter(final CharacterData characterData) {

        if (characterData == null) {
            return;
        }
        this.entityManager.remove(characterData);
    }

}
