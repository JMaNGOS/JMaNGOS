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
@DiscriminatorValue(value = "137")
public class LanguageThalassian extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 3071602925068914672L;

}
