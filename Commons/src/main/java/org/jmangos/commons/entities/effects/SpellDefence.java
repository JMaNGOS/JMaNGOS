package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("37")
public class SpellDefence extends SpellEffectEntity {

    public SpellDefence() {

    }

}
