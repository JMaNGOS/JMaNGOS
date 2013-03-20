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
@DiscriminatorValue(value = "140")
public class LanguageTitan extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 326693579309381227L;

}
