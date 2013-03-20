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
@DiscriminatorValue(value = "139")
public class LanguageDemonTongue extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -6989098002508514035L;

}
