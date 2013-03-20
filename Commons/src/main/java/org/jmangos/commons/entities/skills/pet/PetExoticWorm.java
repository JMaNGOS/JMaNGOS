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
@DiscriminatorValue(value = "784")
public class PetExoticWorm extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1117960748226315252L;

}
