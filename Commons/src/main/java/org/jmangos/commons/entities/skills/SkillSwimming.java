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
@DiscriminatorValue(value = "155")
public class SkillSwimming extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 2201113114615897530L;

}
