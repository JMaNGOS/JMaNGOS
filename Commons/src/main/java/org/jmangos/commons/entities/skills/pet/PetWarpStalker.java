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
@DiscriminatorValue(value = "766")
public class PetWarpStalker extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -9128426133519005916L;

}
