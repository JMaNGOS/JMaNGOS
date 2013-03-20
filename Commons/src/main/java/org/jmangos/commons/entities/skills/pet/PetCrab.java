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
@DiscriminatorValue(value = "214")
public class PetCrab extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 5319563624879800998L;

}
