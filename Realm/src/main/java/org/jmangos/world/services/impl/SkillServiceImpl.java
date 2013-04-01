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

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.dao.SkillRaceClassDao;
import org.jmangos.world.dao.specification.SkillRaceClassSpecs;
import org.jmangos.world.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @author MinimaJack
 * 
 */
@Service("skillService")
public class SkillServiceImpl implements SkillService {

    @Autowired
    SkillRaceClassDao skillRaceClassDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.services.SkillService#getSkillsForRaceClass(org.jmangos.
     * realm.model.enums
     * .Races, org.jmangos.realm.model.enums.Classes)
     */
    @Override
    @Cacheable(cacheName = "skillsForRaceClassCache")
    public List<SkillRaceClassInfoEntity> getSkillsForRaceClass(final Races race,
            final Classes clazz) {
        return this.skillRaceClassDao.findAll(Specifications.where(
                SkillRaceClassSpecs.isClassMatchToClassMask(clazz)).and(
                SkillRaceClassSpecs.isRaceMatchToRaceMask(race)));
    }
}
