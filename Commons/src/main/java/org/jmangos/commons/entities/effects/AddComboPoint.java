package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("80")
public class AddComboPoint extends SpellEffectEntity {

    public AddComboPoint() {

    }

}
