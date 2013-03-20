/**
 * 
 */
package org.jmangos.world.services.impl;

import java.util.List;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;
import org.jmangos.world.dao.SkillLineAbilityDao;
import org.jmangos.world.services.SkillLineAbilityService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author MinimaJack
 * 
 */
public class SkillLineAbilityServiceImpl implements SkillLineAbilityService {

    @Autowired
    SkillLineAbilityDao skillLineAbilityDao;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.test.services.SkillLineAbilityService#
     * getAbilitiesForRaceClassSkill(org.jmangos
     * .realm.model.enums.Races, org.jmangos.realm.model.enums.Classes, int)
     */
    @Override
    public List<SkillLineAbilityEntity> getAbilitiesForRaceClassSkill(final Races race,
            final Classes clazz, final int skill) {
        return this.skillLineAbilityDao.getAbilitiesForRaceClassSkill(race, clazz, skill);
    }

}
