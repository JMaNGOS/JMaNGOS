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
@DiscriminatorValue(value = "176")
public class SkillThrown extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8629236850039633020L;

}
