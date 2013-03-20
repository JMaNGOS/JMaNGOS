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
@DiscriminatorValue(value = "209")
public class PetCat extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3180547091178373553L;

}
