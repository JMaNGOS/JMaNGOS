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
package org.jmangos.world.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.criteria4jpa.Criteria;
import org.criteria4jpa.CriteriaUtils;
import org.criteria4jpa.criterion.Criterion;
import org.jmangos.world.dao.QuestPrototypeDao;
import org.jmangos.world.entities.QuestPrototype;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("questPrototypeDao")
public class QuestPrototypeDaoImpl implements QuestPrototypeDao {

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public QuestPrototype readQuestPrototype(final Integer id) {

        return this.entityManager.find(QuestPrototype.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<QuestPrototype> readQuestPrototypes(final Criterion... criterions) {

        final Criteria criteria =
                CriteriaUtils.createCriteria(this.entityManager, QuestPrototype.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria.getResultList();
    }

    @Transactional(value = "world")
    @Override
    public Integer createOrUpdateQuestPrototype(final QuestPrototype questPrototype) {

        if (questPrototype.getEntry() == null) {
            this.entityManager.persist(questPrototype);
        } else {
            this.entityManager.merge(questPrototype);
        }
        this.entityManager.flush();
        return questPrototype.getEntry();
    }

    @Transactional(value = "world")
    @Override
    public void deleteQuestPrototype(final QuestPrototype questPrototype) {

        if (questPrototype == null) {
            return;
        }
        this.entityManager.remove(questPrototype);
    }

}
