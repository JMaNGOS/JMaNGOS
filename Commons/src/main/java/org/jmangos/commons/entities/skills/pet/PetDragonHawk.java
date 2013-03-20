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
@DiscriminatorValue(value = "763")
public class PetDragonHawk extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7251815460702934270L;

}
