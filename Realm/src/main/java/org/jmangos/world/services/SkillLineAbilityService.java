/**
 * 
 */
package org.jmangos.world.services;

import java.util.List;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * @author MinimaJack
 * 
 */
public interface SkillLineAbilityService {

    abstract List<SkillLineAbilityEntity> getAbilitiesForRaceClassSkill(Races race, Classes clazz,
            int skill);
}
