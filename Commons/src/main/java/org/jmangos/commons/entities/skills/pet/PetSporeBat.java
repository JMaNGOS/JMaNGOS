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
@DiscriminatorValue(value = "765")
public class PetSporeBat extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3504801315014683791L;

}
