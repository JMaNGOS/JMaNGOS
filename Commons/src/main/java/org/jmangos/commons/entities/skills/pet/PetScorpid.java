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
@DiscriminatorValue(value = "236")
public class PetScorpid extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3268336718234027914L;

}
