package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSkill;
import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.model.CanUseSpell;

@Entity
@DiscriminatorValue("25")
public class Weapon extends SpellEffectEntity {

    public Weapon() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.entities.SpellEffectEntity#onAdd(org.jmangos.commons
     * .model.CanUseSpell)
     */
    @Override
    public void onAdd(final CanUseSpell player) {
        if (player instanceof CharacterData) {
            int curValue = 0;
            final CharacterData cd = ((CharacterData) player);
            Integer skillId = getSpell().getSkillId();
            CharacterSkill skInfo = cd.getSkillInfoBySkillId(skillId);

            if (skillId != null && skInfo != null && skillId == 162) {
                curValue = (cd.getLevel() - 1) * 5;
                if (curValue <= 0) {
                    curValue = 1;
                }
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
    public void onRemove(final CanUseSpell player) {
        // TODO Auto-generated method stub
        super.onRemove(player);
    }

}
