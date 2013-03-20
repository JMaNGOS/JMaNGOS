package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("121")
public class WeaponDamageNormalized extends SpellEffectEntity {

    public WeaponDamageNormalized() {

    }

}
