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
package org.jmangos.auth.wow.services.impl;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.auth.dao.AccountDao;
import org.jmangos.auth.entities.AccountEntity;
import org.jmangos.auth.wow.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountDao accountDao;
    
    @Override
    public AccountEntity readAccount(final Long id) {
    
        return this.accountDao.readAccount(id);
    }
    
    @Override
    public List<AccountEntity> readAccounts(final Criterion... criterions) {
    
        return this.accountDao.readAccounts(criterions);
    }
    
    @Override
    public Long createOrUpdateAccount(final AccountEntity accountEntity) {
    
        return this.accountDao.createOrUpdateAccount(accountEntity);
    }
    
    @Override
    public void deleteAccount(final AccountEntity accountEntity) {
    
        this.accountDao.deleteAccount(accountEntity);
    }
    
}
