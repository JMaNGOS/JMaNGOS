package org.jmangos.commons.entities.effects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSkill;
import org.jmangos.commons.entities.SpellEffectEntity;
import org.jmangos.commons.entities.skills.language.LanguageCommon;
import org.jmangos.commons.entities.skills.language.LanguageDarnassian;
import org.jmangos.commons.entities.skills.language.LanguageDraconic;
import org.jmangos.commons.entities.skills.language.LanguageDraenei;
import org.jmangos.commons.entities.skills.language.LanguageDwarven;
import org.jmangos.commons.entities.skills.language.LanguageGnomish;
import org.jmangos.commons.entities.skills.language.LanguageGutterSpeak;
import org.jmangos.commons.entities.skills.language.LanguageOrcish;
import org.jmangos.commons.entities.skills.language.LanguageTaurahe;
import org.jmangos.commons.entities.skills.language.LanguageThalassian;
import org.jmangos.commons.entities.skills.language.LanguageTitan;
import org.jmangos.commons.entities.skills.language.LanguageTroll;
import org.jmangos.commons.model.CanUseSpell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@DiscriminatorValue("39")
public class Language extends SpellEffectEntity {

    private static final Logger logger = LoggerFactory.getLogger(Language.class);

    public Language() {

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
        logger.info("Set current skill value for language {} = 300", getEffectMiscValue());

        if (player instanceof CharacterData) {
            Class<? extends CharacterSkill> langSkill =
                    getSkillIdByLanguageId(getEffectMiscValue());
            CharacterSkill languageSkill =
                    ((CharacterData) player).getSkillInfoBySkillClass(langSkill);
            if (languageSkill != null) {
                languageSkill.setMaxValue(300);
                // Maximize for common language
                if (langSkill.equals(LanguageCommon.class)) {
                    languageSkill.setCurrentValue(300);
                }
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

    private Class<? extends CharacterSkill> getSkillIdByLanguageId(final int language) {
        switch (language) {
            case 1:
                return LanguageOrcish.class;
            case 2:
                return LanguageDarnassian.class;
            case 3:
                return LanguageTaurahe.class;
            case 6:
                return LanguageDwarven.class;
            case 7:
                return LanguageCommon.class;
            case 9:
                return LanguageTitan.class;
            case 10:
                return LanguageThalassian.class;
            case 11:
                return LanguageDraconic.class;
            case 13:
                return LanguageGnomish.class;
            case 14:
                return LanguageTroll.class;
            case 33:
                return LanguageGutterSpeak.class;
            case 35:
                return LanguageDraenei.class;
            default:
                return LanguageCommon.class;
        }
    }
}
