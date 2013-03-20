/**
 * 
 */
package org.jmangos.commons.entities.skills.racial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterSkill;

/**
 * @author MinimaJack
 * 
 */
@Entity
@DiscriminatorValue(value = "101")
public class SkillRacialDwarven extends CharacterSkill {

    /**
     * 
     */
    private static final long serialVersionUID = 5498374330701019536L;

}
