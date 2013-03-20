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
@DiscriminatorValue(value = "215")
public class PetGorilla extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3453996647505011002L;

}
