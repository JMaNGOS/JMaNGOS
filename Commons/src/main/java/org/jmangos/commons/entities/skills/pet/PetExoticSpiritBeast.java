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
@DiscriminatorValue(value = "788")
public class PetExoticSpiritBeast extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8872167218826517184L;

}
