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
package org.jmangos.auth.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.criteria4jpa.Criteria;
import org.criteria4jpa.CriteriaUtils;
import org.criteria4jpa.criterion.Criterion;
import org.jmangos.auth.dao.AccountDao;
import org.jmangos.auth.entities.AccountEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public AccountEntity readAccount(final Integer id) {
    
        return this.entityManager.find(AccountEntity.class, id);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<AccountEntity> readAccounts(final Criterion... criterions) {
    
        final Criteria criteria = CriteriaUtils.createCriteria(this.entityManager, AccountEntity.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        return criteria.getResultList();
    }
    
    @Transactional
    @Override
    public Integer createOrUpdateAccount(final AccountEntity accountEntity) {
    
        if (accountEntity.getId() == null) {
            this.entityManager.persist(accountEntity);
        } else {
            this.entityManager.merge(accountEntity);
        }
        this.entityManager.flush();
        return accountEntity.getId();
    }
    
    @Transactional
    @Override
    public void deleteAccount(final AccountEntity accountEntity) {
    
        if (accountEntity == null) {
            return;
        }
        this.entityManager.remove(accountEntity);
    }
    
}
