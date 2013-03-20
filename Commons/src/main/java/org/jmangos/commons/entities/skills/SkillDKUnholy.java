/**
 * 
 */
package org.jmangos.commons.entities.skills;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "772")
public class SkillDKUnholy extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7247463476207103812L;

}
