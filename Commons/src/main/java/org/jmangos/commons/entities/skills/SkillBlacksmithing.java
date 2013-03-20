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
@DiscriminatorValue(value = "164")
public class SkillBlacksmithing extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6769076864512843699L;

}
