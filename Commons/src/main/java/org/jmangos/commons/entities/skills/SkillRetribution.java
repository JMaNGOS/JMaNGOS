/**
 * 
 */
package org.jmangos.commons.entities.skills;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "184")
public class SkillRetribution extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 7111534051553417997L;

}
