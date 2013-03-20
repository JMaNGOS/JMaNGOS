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
@DiscriminatorValue(value = "758")
public class PetEventRC extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1882483260872113239L;

}
