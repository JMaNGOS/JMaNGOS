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
@DiscriminatorValue(value = "764")
public class PetNetherRay extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6310565584164211232L;

}
