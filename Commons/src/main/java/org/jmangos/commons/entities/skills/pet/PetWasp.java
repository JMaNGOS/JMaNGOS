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
@DiscriminatorValue(value = "785")
public class PetWasp extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3509288228776556047L;

}
