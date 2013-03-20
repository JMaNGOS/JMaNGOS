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
@DiscriminatorValue(value = "138")
public class LanguageDraconic extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -141167614435527355L;

}
