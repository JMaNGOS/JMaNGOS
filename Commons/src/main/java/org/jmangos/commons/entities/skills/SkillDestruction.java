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
@DiscriminatorValue(value = "593")
public class SkillDestruction extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8008767447960981359L;

}
