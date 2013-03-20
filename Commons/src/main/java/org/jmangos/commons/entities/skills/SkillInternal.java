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
@DiscriminatorValue(value = "769")
public class SkillInternal extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4025992262414457069L;

}
