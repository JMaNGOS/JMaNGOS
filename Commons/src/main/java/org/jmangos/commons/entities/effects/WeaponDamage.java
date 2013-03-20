package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("58")
public class WeaponDamage extends SpellEffectEntity {

    public WeaponDamage() {

    }

}
