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
@DiscriminatorValue(value = "315")
public class LanguageTroll extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -5157424958667262513L;

}
