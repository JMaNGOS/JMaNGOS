package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.model.CanUseSpell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@DiscriminatorValue("3")
public class PeriodicDamage extends SpellEffectEntity {

    private static final Logger logger = LoggerFactory.getLogger(PeriodicDamage.class);

    public PeriodicDamage() {

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
        logger.info("Spell with spelleffect PeriodicDamage used");
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
