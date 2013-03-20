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
@DiscriminatorValue(value = "786")
public class PetExoticRhino extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2606720659731170426L;

}
