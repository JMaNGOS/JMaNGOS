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
@DiscriminatorValue(value = "655")
public class PetBirdOfPrey extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7804193699377184321L;

}
