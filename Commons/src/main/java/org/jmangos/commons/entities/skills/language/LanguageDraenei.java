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
@DiscriminatorValue(value = "759")
public class LanguageDraenei extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7200233592590591025L;

}
