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
@DiscriminatorValue(value = "654")
public class PetHyena extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -8826954990650364905L;

}
