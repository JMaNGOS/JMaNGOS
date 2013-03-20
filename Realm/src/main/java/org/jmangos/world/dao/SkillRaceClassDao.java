/**
 * 
 */
package org.jmangos.world.dao;

import java.util.List;

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * @author MinimaJack
 * 
 */
public interface SkillRaceClassDao {

    SkillRaceClassInfoEntity readSkillRaceClass(Integer id);

    List<SkillRaceClassInfoEntity> readSkillRaceClasses(final Races race, final Classes clazz);

    void deleteSkillRaceClass(SkillRaceClassInfoEntity givenSkillRaceClassInfoEntity);

}
