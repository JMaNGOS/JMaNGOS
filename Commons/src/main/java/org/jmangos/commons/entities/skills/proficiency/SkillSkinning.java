/**
 * 
 */
package org.jmangos.commons.entities.skills.proficiency;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "393")
public class SkillSkinning extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1477640361957199545L;

}
