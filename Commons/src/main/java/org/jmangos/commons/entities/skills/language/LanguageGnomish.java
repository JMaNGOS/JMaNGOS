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
@DiscriminatorValue(value = "313")
public class LanguageGnomish extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -4994477629374279357L;

}
