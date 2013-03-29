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
