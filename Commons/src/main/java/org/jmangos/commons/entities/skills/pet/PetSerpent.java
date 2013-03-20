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
@DiscriminatorValue(value = "768")
public class PetSerpent extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5720378718301609451L;

}
