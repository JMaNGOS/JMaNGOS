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
@DiscriminatorValue(value = "207")
public class PetDoomguard extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 5675929628596374673L;

}
