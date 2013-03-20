package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.SpellEffectEntity;

@Entity
@DiscriminatorValue("116")
public class RemoveInsignia extends SpellEffectEntity {

    public RemoveInsignia() {

    }

}
