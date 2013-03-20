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
@DiscriminatorValue(value = "780")
public class PetExoticChimaera extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1381697373171999953L;

}
