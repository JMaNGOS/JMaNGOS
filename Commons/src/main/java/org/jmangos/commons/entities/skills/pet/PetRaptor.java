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
@DiscriminatorValue(value = "217")
public class PetRaptor extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8251708871505560661L;

}
