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
@DiscriminatorValue(value = "270")
public class PetTalents extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1674017024980444454L;

}
