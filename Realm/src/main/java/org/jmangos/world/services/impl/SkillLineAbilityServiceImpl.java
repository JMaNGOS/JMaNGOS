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
package org.jmangos.world.services.impl;

import java.util.List;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.dao.SkillLineAbilityDao;
import org.jmangos.world.dao.specification.SkillLineAbilitySpecs;
import org.jmangos.world.services.SkillLineAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @author MinimaJack
 * 
 */
@Service("skillLineAbilityService")
public class SkillLineAbilityServiceImpl implements SkillLineAbilityService {

    @Autowired
    SkillLineAbilityDao skillLineAbilityDao;

    @Override
    @Cacheable(cacheName = "abilitiesForRaceClassSkillCache")
    public List<SkillLineAbilityEntity> getAbilitiesForRaceClassSkill(final Races race,
            final Classes clazz, final int skill) {
        return this.skillLineAbilityDao.findAll(Specifications.where(
                SkillLineAbilitySpecs.isClassMatchToClassMask(clazz)).and(
                SkillLineAbilitySpecs.isLearnOnGetSkill()).and(
                SkillLineAbilitySpecs.isRaceMatchToRaceMask(race)).and(
                SkillLineAbilitySpecs.isSkill(skill)));
    }

}
