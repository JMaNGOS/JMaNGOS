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
@DiscriminatorValue(value = "203")
public class PetSpider extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1758597725073404684L;

}
