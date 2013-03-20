package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSkill;
import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.enums.ItemClass;
import org.jmangos.commons.enums.ItemSubClassArmor;
import org.jmangos.commons.model.CanUseSpell;

@Entity
@DiscriminatorValue("60")
public class Proficiency extends SpellEffectEntity {

    public Proficiency() {

    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.SpellEffectEntity#canApply(org.jmangos.commons
     *      .model.CanUseSpell)
     */
    @Override
    public boolean canApply(CanUseSpell player) {
        ItemClass clazz = ItemClass.get(getSpell().getEquippedItemClass());
        int submask = getSpell().getEquippedItemSubClassMask();
        switch (clazz) {
            case ARMOR:
                switch (ItemSubClassArmor.getFirstByMask(submask)) {
                // Can use plate only after 40 level
                    case PLATE:
                        if (player instanceof CharacterData) {
                            if (((CharacterData) player).getLevel() < 40) {
                                return false;
                            }
                        }
                    default:
                    break;
                }
                ;
            break;
            default:
            break;
        }
        return true;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.SpellEffectEntity#onAdd(org.jmangos.commons.model.CanUseSpell)
     */
    @Override
    public void onAdd(final CanUseSpell player) {
        if (player instanceof CharacterData) {
            int curValue = 0;
            final CharacterData cd = ((CharacterData) player);
            ItemClass clazz = ItemClass.get(getSpell().getEquippedItemClass());
            int submask = getSpell().getEquippedItemSubClassMask();
            Integer skillId = getSpell().getSkillId();
            CharacterSkill skInfo = cd.getSkillInfoBySkillId(skillId);

            if (skillId != null && skInfo != null && skillId == 183) {
                skInfo.setCurrentValue(cd.getLevel() * 5);
                skInfo.setMaxValue(cd.getLevel() * 5);
            } else if (skInfo != null) {
                switch (clazz) {
                    case ARMOR:
                        skInfo.setCurrentValue(1);
                        skInfo.setMaxValue(1);
                    break;
                    case WEAPON:
                        curValue = (cd.getLevel() - 1) * 5;
                        if (curValue <= 0) {
                            curValue = 1;
                        }
                        skInfo.setCurrentValue(curValue);
                        skInfo.setMaxValue(cd.getLevel() * 5);
                    break;
                    default:
                    break;
                }
            }
            cd.addProficiency(clazz, submask);
        }
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.SpellEffectEntity#onRemove(org.jmangos.commons
     *      .model.CanUseSpell )
     */
    @Override
    public void onRemove(final CanUseSpell player) {

        player.removeProficiency(ItemClass.get(getSpell().getEquippedItemClass()),
                getSpell().getEquippedItemSubClassMask());
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.entities.SpellEffectEntity#apply(org.jmangos.commons.
     *      entities.SpellEntity )
     */
    @Override
    public void apply() {

    }

}
