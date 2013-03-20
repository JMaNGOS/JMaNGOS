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
@DiscriminatorValue(value = "673")
public class LanguageGutterSpeak extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -1199942567532852471L;

}
