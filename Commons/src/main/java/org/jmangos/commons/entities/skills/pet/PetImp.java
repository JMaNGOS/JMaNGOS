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
@DiscriminatorValue(value = "189")
public class PetImp extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 8253719117522806032L;

}
