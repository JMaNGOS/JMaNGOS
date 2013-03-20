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
@DiscriminatorValue(value = "210")
public class PetBear extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 920499510976833326L;

}
