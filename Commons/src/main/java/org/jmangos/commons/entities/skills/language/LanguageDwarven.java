/**
 * 
 */
package org.jmangos.commons.entities.skills.language;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "111")
public class LanguageDwarven extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -4846558702141225873L;

}
