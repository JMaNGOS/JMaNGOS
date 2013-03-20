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
@DiscriminatorValue(value = "173")
public class SkillDaggers extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3635638269429154956L;

}
