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
@DiscriminatorValue(value = "39")
public class SkillSubtlety extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8348846291889951844L;

}
