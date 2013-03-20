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
@DiscriminatorValue(value = "212")
public class PetCrocilisk extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 6477982969790366272L;

}
