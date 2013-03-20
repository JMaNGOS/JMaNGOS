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
@DiscriminatorValue(value = "188")
public class PetFelhunter extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8205675148935346418L;

}
