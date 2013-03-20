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
@DiscriminatorValue(value = "113")
public class LanguageDarnassian extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1862483197959133675L;

}
