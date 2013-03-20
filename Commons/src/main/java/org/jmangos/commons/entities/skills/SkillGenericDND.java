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
@DiscriminatorValue(value = "183")
public class SkillGenericDND extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8175012077490940952L;

}
