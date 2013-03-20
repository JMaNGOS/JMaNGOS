/**
 * 
 */
package org.jmangos.commons.entities.skills.weapon;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "46")
public class SkillGuns extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3624394728753024234L;

}
