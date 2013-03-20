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
@DiscriminatorValue(value = "251")
public class PetTurtle extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3533129694714908639L;

}
