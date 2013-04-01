/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 *  
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
