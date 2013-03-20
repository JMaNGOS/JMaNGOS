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
@DiscriminatorValue(value = "775")
public class PetMoth extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1650048197202525287L;

}
