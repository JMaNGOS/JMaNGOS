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
@DiscriminatorValue(value = "213")
public class PetCarrionBird extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1704439701001099282L;

}
