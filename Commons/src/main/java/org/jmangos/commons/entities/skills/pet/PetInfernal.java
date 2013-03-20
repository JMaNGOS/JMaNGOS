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
@DiscriminatorValue(value = "206")
public class PetInfernal extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3055765596813093599L;

}
