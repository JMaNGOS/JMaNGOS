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
@DiscriminatorValue(value = "356")
public class SkillFishing extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 424932370729259250L;

}
