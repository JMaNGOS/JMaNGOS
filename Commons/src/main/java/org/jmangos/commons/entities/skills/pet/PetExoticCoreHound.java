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
@DiscriminatorValue(value = "787")
public class PetExoticCoreHound extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -2165567397248362584L;

}
