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
@DiscriminatorValue(value = "109")
public class LanguageOrcish extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3701345579947072305L;

}
