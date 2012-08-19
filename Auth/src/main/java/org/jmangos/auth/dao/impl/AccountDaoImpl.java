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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.criteria4jpa.Criteria;
import org.criteria4jpa.CriteriaUtils;
import org.criteria4jpa.criterion.Criterion;
import org.jmangos.auth.dao.AccountDao;
import org.jmangos.auth.entities.AccountEntity;
import org.jmangos.auth.model.AccountDto;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public AccountDto readAccount(final Long id) {
    
        final AccountEntity accountEntity = this.entityManager.find(AccountEntity.class, id);
        return accountEntity != null ? entityToDto(accountEntity) : null;
    }
    
    public List<AccountDto> readAccounts(final Criterion... criterions) {
    
        final List<AccountDto> resultList = new ArrayList<AccountDto>();
        final List<AccountEntity> accountList = getAccountList(criterions);
        if (accountList != null) {
            for (final AccountEntity accountEntity : accountList) {
                resultList.add(entityToDto(accountEntity));
            }
        }
        return resultList;
    }
    
    @SuppressWarnings("unchecked")
    private List<AccountEntity> getAccountList(final Criterion... criterions) {
    
        final Criteria criteria = CriteriaUtils.createCriteria(this.entityManager, AccountEntity.class);
        for(Criterion criterion :criterions){
            criteria.add(criterion);
        }
        final List<AccountEntity> accountList = criteria.getResultList();
        return accountList;
    }
    
    private AccountDto entityToDto(final AccountEntity accountEntity) {
    
        final AccountDto accountDto = new AccountDto();
        accountDto.setId(accountEntity.getId());
        accountDto.setUsername(accountEntity.getUsername());
        accountDto.setShaPasswordHash(accountEntity.getShaPasswordHash());
        accountDto.setGmlevel(accountEntity.getGmlevel());
        accountDto.setSessionKey(accountEntity.getSessionKey());
        accountDto.setV(accountEntity.getV());
        accountDto.setS(accountEntity.getS());
        accountDto.setEmail(accountEntity.getEmail());
        //accountDto.setJoindate(accountEntity.getJoindate());
        accountDto.setLastIp(accountEntity.getLastIp());
        accountDto.setFailedLogins(accountEntity.getFailedLogins());
        accountDto.setLocked(accountEntity.getLocked());
        //accountDto.setLastLogin(accountEntity.getLastLogin());
        accountDto.setActiveRealmId(accountEntity.getActiveRealmId());
        accountDto.setExpansion(accountEntity.getExpansion());
        accountDto.setMutetime(accountEntity.getMutetime());
        accountDto.setLocale(accountEntity.getLocale());
        accountDto.setLastServer(accountEntity.getLastServer());
        return accountDto;
    }
    
    private AccountEntity dtoToEntity(final AccountDto accountDto) {
    
        final AccountEntity accountEntity = findOrCreateAccountEntity(accountDto.getId());
        accountEntity.setId(accountDto.getId());
        accountEntity.setUsername(accountDto.getUsername());
        accountEntity.setShaPasswordHash(accountDto.getShaPasswordHash());
        accountEntity.setGmlevel(accountDto.getGmlevel());
        accountEntity.setSessionKey(accountDto.getSessionKey());
        accountEntity.setV(accountDto.getV());
        accountEntity.setS(accountDto.getS());
        accountEntity.setEmail(accountDto.getEmail());
        //accountEntity.setJoindate(accountDto.getJoindate());
        accountEntity.setLastIp(accountDto.getLastIp());
        accountEntity.setFailedLogins(accountDto.getFailedLogins());
        accountEntity.setLocked(accountDto.getLocked());
       // accountEntity.setLastLogin(accountDto.getLastLogin());
        accountEntity.setActiveRealmId(accountDto.getActiveRealmId());
        accountEntity.setExpansion(accountDto.getExpansion());
        accountEntity.setMutetime(accountDto.getMutetime());
        accountEntity.setLocale(accountDto.getLocale());
        accountEntity.setLastServer(accountDto.getLastServer());
        return accountEntity;
    }
    
    private AccountEntity findOrCreateAccountEntity(final Long id) {
    
        if (id == null) {
            return new AccountEntity();
        }
        return this.entityManager.find(AccountEntity.class, id);
    }
    
    @Override
    public Long createOrUpdateAccount(final AccountDto accountDto) {
    
        final AccountEntity accountEntity = dtoToEntity(accountDto);
        if (accountEntity.getId() == null) {
            this.entityManager.persist(accountEntity);
        } else {
            this.entityManager.merge(accountEntity);
        }
        this.entityManager.flush();
        final Long accountId = accountEntity.getId();
        accountDto.setId(accountId);
        return accountId;
    }
    
    @Override
    public void deleteAccount(final AccountDto accountDto) {
    
        final AccountEntity accountEntity = this.entityManager.find(AccountEntity.class, accountDto.getId());
        if (accountEntity == null) {
            return;
        }
        this.entityManager.remove(accountEntity);
    }
    
}
