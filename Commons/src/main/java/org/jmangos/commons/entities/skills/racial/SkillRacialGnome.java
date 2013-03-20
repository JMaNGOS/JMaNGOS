/**
 * 
 */
package org.jmangos.commons.entities.skills.racial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "753")
public class SkillRacialGnome extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4948471563820539985L;

}
