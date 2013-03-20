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
public class PetRavager extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3530850634258466970L;

}
