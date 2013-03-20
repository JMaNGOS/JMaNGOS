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
@DiscriminatorValue(value = "205")
public class PetSuccubus extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1132539475939074979L;

}
