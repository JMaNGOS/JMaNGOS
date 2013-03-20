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
@DiscriminatorValue(value = "653")
public class PetBat extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 166850713497747041L;

}
