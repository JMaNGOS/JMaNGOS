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
@DiscriminatorValue(value = "218")
public class PetTallstrider extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3480279039116422118L;

}
