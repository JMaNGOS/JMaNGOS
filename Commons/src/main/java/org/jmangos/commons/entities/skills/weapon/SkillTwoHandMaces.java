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
@DiscriminatorValue(value = "160")
public class SkillTwoHandMaces extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5975895717433494916L;

}
