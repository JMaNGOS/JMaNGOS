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
@DiscriminatorValue(value = "141")
public class LanguageOldTongue extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 1521488589118960286L;

}
