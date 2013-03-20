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
@DiscriminatorValue(value = "186")
public class SkillMining extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 9023796835823313359L;

}
