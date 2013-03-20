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
@DiscriminatorValue(value = "115")
public class LanguageTaurahe extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 4558704965812571814L;

}
