/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSkill;
import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.model.CanUseSpell;

@Entity
@DiscriminatorValue("25")
public class Weapon extends SpellEffectEntity {

    public Weapon() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.entities.SpellEffectEntity#onAdd(org.jmangos.commons
     * .model.CanUseSpell)
     */
    @Override
    public void onAdd(final CanUseSpell player) {
        if (player instanceof CharacterData) {
            int curValue = 0;
            final CharacterData cd = ((CharacterData) player);
            final Integer skillId = getSpell().getSkillId();
            final CharacterSkill skInfo = cd.getSkillInfoBySkillId(skillId);

            if ((skillId != null) && (skInfo != null) && (skillId == 162)) {
                curValue = (cd.getLevel() - 1) * 5;
                if (curValue <= 0) {
                    curValue = 1;
                }
                skInfo.setCurrentValue(curValue);
                skInfo.setMaxValue(cd.getLevel() * 5);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.entities.SpellEffectEntity#onRemove(org.jmangos.commons
     * .model.CanUseSpell)
     */
    @Override
    public void onRemove(final CanUseSpell player) {
        // TODO Auto-generated method stub
        super.onRemove(player);
    }

}
