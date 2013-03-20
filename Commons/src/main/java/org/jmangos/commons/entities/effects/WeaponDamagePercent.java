package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("31")
public class WeaponDamagePercent extends SpellEffectEntity {

    public WeaponDamagePercent() {

    }

}
