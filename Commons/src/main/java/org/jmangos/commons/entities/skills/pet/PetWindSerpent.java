/**
 * 
 */
package org.jmangos.commons.entities.skills.pet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "656")
public class PetWindSerpent extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -7632449168525233890L;

}
