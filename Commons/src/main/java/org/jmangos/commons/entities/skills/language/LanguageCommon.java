/**
 * 
 */
package org.jmangos.commons.entities.skills.language;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@Table(name = "character_skills")
@DiscriminatorValue(value = "98")
public class LanguageCommon extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = -3026973105559555040L;

}
