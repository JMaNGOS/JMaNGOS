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
    public void onAdd(CanUseSpell player) {

        logger.info("Must add aura due to spell {} {}", getSpell().getId(),
                getSpell().getSpellName());
        AuraType type = AuraType.get(getEffectApplyAuraName());
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
    public void onRemove(CanUseSpell player) {

        // TODO Auto-generated method stub
    }

}
