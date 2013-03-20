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
@DiscriminatorValue(value = "761")
public class PetFelguard extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6752809374659553701L;

}
