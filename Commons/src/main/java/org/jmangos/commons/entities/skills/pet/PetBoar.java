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
@DiscriminatorValue(value = "211")
public class PetBoar extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7240807987747024139L;

}
