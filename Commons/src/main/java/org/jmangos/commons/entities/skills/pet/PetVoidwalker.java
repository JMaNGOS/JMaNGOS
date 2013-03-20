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
@DiscriminatorValue(value = "204")
public class PetVoidwalker extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -12893745405622963L;

}
