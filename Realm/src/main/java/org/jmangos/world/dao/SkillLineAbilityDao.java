/**
 * 
 */
package org.jmangos.world.dao;

import java.util.List;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * @author MinimaJack
 * 
 */
public interface SkillLineAbilityDao {

    SkillLineAbilityEntity readSkillLineAbility(Integer id);

    List<SkillLineAbilityEntity> getAbilitiesForRaceClassSkill(final Races race,
            final Classes clazz, final int skill);

    void deleteSkillLineAbility(SkillLineAbilityEntity givenSkillLineAbilityEntity);

}
