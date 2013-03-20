/**
 * 
 */
package org.jmangos.world.services;

import java.util.List;

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.Races;

/**
 * @author MinimaJack
 * 
 */
public interface SkillService {

    abstract List<SkillRaceClassInfoEntity> getSkillsForRaceClass(Races race, Classes clazz);
}
