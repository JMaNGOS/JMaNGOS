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
import org.jmangos.auth.dao.RealmDao;
import org.jmangos.auth.entities.RealmEntity;
import org.jmangos.auth.model.RealmDto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("realmDao")
public class RealmDaoImpl implements RealmDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public RealmDto readRealm(final Long id) {
    
        final RealmEntity realmEntity = this.entityManager.find(RealmEntity.class, id);
        return realmEntity != null ? entityToDto(realmEntity) : null;
    }
    
    @Override
    public List<RealmDto> readRealms(final Criterion... criterions) {
    
        final List<RealmDto> resultList = new ArrayList<RealmDto>();
        final List<RealmEntity> realmList = getRealmList(criterions);
        if (realmList != null) {
            for (final RealmEntity realmEntity : realmList) {
                resultList.add(entityToDto(realmEntity));
            }
        }
        return resultList;
    }
    
    @SuppressWarnings("unchecked")
    private List<RealmEntity> getRealmList(final Criterion... criterions) {
    
        final Criteria criteria = CriteriaUtils.createCriteria(this.entityManager, RealmEntity.class);
        for (final Criterion criterion : criterions) {
            criteria.add(criterion);
        }
        final List<RealmEntity> realmList = criteria.getResultList();
        return realmList;
    }
    
    private RealmDto entityToDto(final RealmEntity realmEntity) {
    
        final RealmDto realmDto = new RealmDto();
        realmDto.setId(realmEntity.getId());
        realmDto.setName(realmEntity.getName());
        realmDto.setAddress(realmEntity.getAddress());
        realmDto.setPort(realmEntity.getPort());
        realmDto.setIcon(realmEntity.getIcon());
        realmDto.setRealmflags(realmEntity.getRealmflags());
        realmDto.setTimezone(realmEntity.getTimezone());
        realmDto.setAllowedSecurityLevel(realmEntity.getAllowedSecurityLevel());
        realmDto.setPopulation(realmEntity.getPopulation());
        realmDto.setRealmbuilds(realmEntity.getRealmbuilds());
        return realmDto;
    }
    
    private RealmEntity dtoToEntity(final RealmDto realmDto) {
    
        final RealmEntity realmEntity = findOrCreateRealmEntity(realmDto.getId());
        realmEntity.setId(realmDto.getId());
        realmEntity.setName(realmDto.getName());
        realmEntity.setAddress(realmDto.getAddress());
        realmEntity.setPort(realmDto.getPort());
        realmEntity.setIcon(realmDto.getIcon());
        realmEntity.setRealmflags(realmDto.getRealmflags());
        realmEntity.setTimezone(realmDto.getTimezone());
        realmEntity.setAllowedSecurityLevel(realmDto.getAllowedSecurityLevel());
        realmEntity.setPopulation(realmDto.getPopulation());
        realmEntity.setRealmbuilds(realmDto.getRealmbuilds());
        return realmEntity;
    }
    
    private RealmEntity findOrCreateRealmEntity(final Long id) {
    
        if (id == null) {
            return new RealmEntity();
        }
        return this.entityManager.find(RealmEntity.class, id);
    }
    
    @Transactional
    @Override
    public Long createOrUpdateRealm(final RealmDto realmDto) {
    
        final RealmEntity realmEntity = dtoToEntity(realmDto);
        if (realmEntity.getId() == null) {
            this.entityManager.persist(realmEntity);
        } else {
            this.entityManager.merge(realmEntity);
        }
        this.entityManager.flush();
        final Long accountId = realmEntity.getId();
        realmDto.setId(accountId);
        return accountId;
    }
    
    @Transactional
    @Override
    public void deleteRealm(final RealmDto realmDto) {
    
        final RealmEntity realmEntity = this.entityManager.find(RealmEntity.class, realmDto.getId());
        if (realmEntity == null) {
            return;
        }
        this.entityManager.remove(realmEntity);
    }
    
}
