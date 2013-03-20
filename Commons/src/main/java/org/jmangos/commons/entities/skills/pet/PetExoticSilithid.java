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
@DiscriminatorValue(value = "783")
public class PetExoticSilithid extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -7253259683366644241L;

}
