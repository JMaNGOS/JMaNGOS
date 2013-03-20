package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSkill;
import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.model.CanUseSpell;

@Entity
@DiscriminatorValue("26")
public class Defence extends SpellEffectEntity {

    public Defence() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.entities.SpellEffectEntity#onAdd(org.jmangos.commons
     * .model.CanUseSpell)
     */
    @Override
    public void onAdd(CanUseSpell player) {
        if (player instanceof CharacterData) {
            final CharacterData cd = ((CharacterData) player);
            int curValue = (cd.getLevel() - 1) * 5;
            if (curValue <= 0) {
                curValue = 1;
            }
            Integer skillId = getSpell().getSkillId();
            CharacterSkill skInfo = cd.getSkillInfoBySkillId(skillId);
            if (skInfo != null) {
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
    public void onRemove(CanUseSpell player) {
        // TODO Auto-generated method stub
        super.onRemove(player);
    }

}
