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

import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.enums.AuraType;
import org.jmangos.commons.enums.SpellAttributes;
import org.jmangos.commons.model.CanUseSpell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@DiscriminatorValue("6")
public class ApplyAura extends SpellEffectEntity {

    private static final Logger logger = LoggerFactory.getLogger(ApplyAura.class);

    public ApplyAura() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.entities.SpellEffectEntity#onAdd(org.jmangos.commons.
     * model.CanUseSpell)
     */
    @Override
    public void onAdd(final CanUseSpell player) {

        logger.info("Must add aura due to spell {} {}", getSpell().getId(),
                getSpell().getSpellName());
        final AuraType type = AuraType.get(getEffectApplyAuraName());
        if (getSpell().isPassive()) {
            logger.info("Add persist aura : {} type: {}", getSpell().getSpellName(), type);
        } else {
            logger.info("Add spell to apply aura: {} type: {}", getSpell().getSpellName(), type);
        }
        logger.info("Attributes {}", SpellAttributes.getAllInString(getSpell().getAttributes()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.entities.SpellEffectEntity#onRemove(org.jmangos.commons
     * .model.CanUseSpell
     * )
     */
    @Override
    public void onRemove(final CanUseSpell player) {

        // TODO Auto-generated method stub
    }

}
