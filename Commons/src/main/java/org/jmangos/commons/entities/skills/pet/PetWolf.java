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
@DiscriminatorValue(value = "208")
public class PetWolf extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -62243397267918612L;

}
