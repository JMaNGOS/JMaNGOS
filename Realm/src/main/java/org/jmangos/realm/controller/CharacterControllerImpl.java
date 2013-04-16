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
package org.jmangos.realm.controller;

import java.util.List;
import java.util.Set;

import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.dataholder.Visitor;
import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.entities.CharacterButton;
import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterPositionerHolder;
import org.jmangos.commons.entities.CharacterPowers;
import org.jmangos.commons.entities.CharacterReputation;
import org.jmangos.commons.entities.CharacterSkill;
import org.jmangos.commons.entities.FactionDataEntity;
import org.jmangos.commons.entities.FactionEntity;
import org.jmangos.commons.entities.FieldsItem;
import org.jmangos.commons.entities.ItemPrototype;
import org.jmangos.commons.entities.PlayerClassLevelInfo;
import org.jmangos.commons.entities.PlayerCreateAction;
import org.jmangos.commons.entities.PlayerLevelInfo;
import org.jmangos.commons.entities.Playercreateinfo;
import org.jmangos.commons.entities.SkillLineAbilityEntity;
import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.jmangos.commons.entities.SpellEntity;
import org.jmangos.commons.entities.pk.PlayercreateinfoPK;
import org.jmangos.commons.enums.ActionButtonType;
import org.jmangos.commons.enums.CharCreateCode;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.EquipmentSlots;
import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.enums.ItemFlags;
import org.jmangos.commons.enums.ModelType;
import org.jmangos.commons.enums.Powers;
import org.jmangos.commons.enums.Races;
import org.jmangos.commons.enums.Stats;
import org.jmangos.commons.service.SkillFactory;
import org.jmangos.realm.network.packet.wow.server.SMSG_INITIALIZE_FACTIONS;
import org.jmangos.realm.service.FactionStorages;
import org.jmangos.realm.service.PlayerClassLevelInfoStorages;
import org.jmangos.realm.service.PlayerLevelStorages;
import org.jmangos.realm.service.PlayerXpForLevelStorages;
import org.jmangos.realm.services.CharacterService;
import org.jmangos.realm.services.ItemService;
import org.jmangos.world.services.CharStartOutfitService;
import org.jmangos.world.services.ItemPrototypeService;
import org.jmangos.world.services.PlayerCreateInfoService;
import org.jmangos.world.services.SkillLineAbilityService;
import org.jmangos.world.services.SkillService;
import org.jmangos.world.services.SpellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CharacterControllerImpl implements CharacterController {

    /** The Constant logger. */
    private static final Logger log = LoggerFactory.getLogger(CharacterControllerImpl.class);

    @Autowired
    private CharacterService characterService;

    @Autowired
    private PlayerCreateInfoService playerCreateInfoService;

    @Autowired
    private CharStartOutfitService charStartOutfitService;

    @Autowired
    ItemService itemService;

    @Autowired
    SkillService skillService;

    @Autowired
    SpellService spellService;

    @Autowired
    SkillLineAbilityService skillLineAbilityService;

    @Autowired
    ItemPrototypeService itemPrototypeService;

    /** The player level storages. */
    @Autowired
    private PlayerLevelStorages playerLevelStorages;

    @Autowired
    private FactionStorages factionStorages;

    @Autowired
    private PlayerClassLevelInfoStorages playerClassLevelInfoStorages;

    @Autowired
    PlayerXpForLevelStorages playerXpForLevelStorages;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.realm.controller.CharacterControllers#createCharacter(long,
     * java.lang.String, org.jmangos.commons.enums.Races,
     * org.jmangos.commons.enums.Classes, org.jmangos.commons.enums.Gender, int,
     * int, int, int, int)
     */
    @Override
    @Transactional("realm")
    public CharCreateCode createCharacter(final long accountId, final String charName,
            final Races race, final Classes clazz, final Gender gender, final int skin,
            final int face, final int hairStyle, final int hairColor, final int facialHair) {

        if (this.characterService.existWithName(charName)) {
            CharacterControllerImpl.log.debug("Username already exists: {}", charName);
            return CharCreateCode.NAME_IN_USE;
        }

        final Playercreateinfo info =
                this.playerCreateInfoService.readPlayerCreateInfo(new PlayercreateinfoPK(race,
                        clazz));

        if (info == null) {
            log.error("Player create template not found for: " + clazz + " " + race);
            return CharCreateCode.ERROR;
        }

        final CharacterData characterData = new CharacterData();
        // Set account id
        characterData.setAccount(accountId);

        // Set name
        characterData.setName(charName);

        // Set Class/Race/Gender
        characterData.setClazz(clazz);
        characterData.setRace(race);
        characterData.setGender(gender);
        characterData.setPowerType(characterData.getPowerType().ordinal() - 1); // -1
                                                                                // health

        characterData.setLevel(1);

        // Skin, Face, Hair(style,color)
        characterData.setPlayerBytes(skin | (face << 8) | (hairStyle << 16) | (hairColor << 24));

        // Hair(facial), Bankslot
        characterData.setPlayerBytes2((facialHair /* | (0xEE << 8) */| (0x02 << 24)));

        // character.setExploredZones(Integer.toString(info.getZone()));
        // character.setKnownTitles("0");

        final PlayerClassLevelInfo classInfo = this.playerClassLevelInfoStorages.get(clazz, 1);

        // TODO: make a config to create some inital value
        characterData.setMoney(0);

        characterData.setXp(0);

        final CharacterPowers up = new CharacterPowers();
        characterData.setPowers(up);

        addDefaultPowerToCharacter(characterData);

        characterData.setPower(Powers.HEALTH, classInfo.getBasehealth());
        characterData.setPower(characterData.getPowerType(), classInfo.getBasemana());

        characterData.setLevel(1);
        // First login
        characterData.setAtLoginFlag(0x1);

        final CharacterPositionerHolder mh = new CharacterPositionerHolder();

        mh.setMap(info.getMap());
        mh.setZone(info.getZone());
        mh.setPosition(info.getPosition().clone());
        mh.updateHomeBindDataToCurrentData();

        characterData.setMovement(mh);

        this.characterService.createOrUpdateCharacter(characterData);

        createStartItemToCharacter(characterData);

        createStartSkillAndSpellToCharacter(characterData);

        createStartActionButtonsToCharacter(characterData, info.getActions());

        initFactionToCharacter(characterData);

        this.characterService.createOrUpdateCharacter(characterData);
        return CharCreateCode.SUCCESS;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.realm.controller.CharacterControllers#updateCharacter(long,
     * java.lang.String, org.jmangos.commons.enums.Gender, int, int, int, int,
     * int)
     */
    @Override
    @Transactional("realm")
    public CharCreateCode updateCharacter(final long characterId, final String charNewName,
            final Gender gender, final int skin, final int face, final int hairStyle,
            final int hairColor, final int facialHair) {

        final CharacterData characterData = loadCharacterByGuid(characterId);

        if (!characterData.getName().equals(charNewName) &&
            this.characterService.existWithName(charNewName)) {
            CharacterControllerImpl.log.debug("Username already exists: {}", charNewName);
            return CharCreateCode.NAME_IN_USE;
        }

        characterData.setName(charNewName);

        // Skin, Face, Hair(style,color)
        characterData.setPlayerBytes(skin | (face << 8) | (hairStyle << 16) | (hairColor << 24));

        // Hair(facial), Bankslot
        characterData.setPlayerBytes2((facialHair /* | (0xEE << 8) */| (0x02 << 24)));
        characterData.setGender(gender);

        // this.characterService.createOrUpdateCharacter(characterData);

        return CharCreateCode.SUCCESS;
    }

    private void createStartActionButtonsToCharacter(final CharacterData characterData,
            final Set<PlayerCreateAction> actions) {
        for (final PlayerCreateAction action : actions) {
            boolean valid = true;
            switch (ActionButtonType.get(action.getType())) {
                case SPELL:
                    if (!characterData.getSpells().containsKey(action.getAction())) {
                        valid = false;
                    }
                break;

                default:
                break;
            }
            if (valid) {
                final CharacterButton chB = new CharacterButton();
                chB.setAction(action.getAction());
                chB.setButton(action.getButton());
                chB.setButtonType(action.getType());
                chB.setSpec(0);
                characterData.addActionButton(chB);
            }
        }

    }

    private void initFactionToCharacter(final CharacterData characterData) {
        for (int i = 0; i < SMSG_INITIALIZE_FACTIONS.MINIMAL_FACTION_COUNT; i++) {
            if (this.factionStorages.get().containsKey(i)) {
                final FactionEntity rData = this.factionStorages.get().get(i);
                final CharacterReputation chR = new CharacterReputation();
                chR.setFaction(i);
                chR.setStanding(0);
                final int raceMask = characterData.getRace().getMask();
                final int classMask = characterData.getRace().getMask();
                rData.iterate(new Visitor<FactionDataEntity>() {

                    @Override
                    public void visit(final FactionDataEntity member) {
                        if (((member.getRaceMask() == 0) || ((member.getRaceMask() & raceMask) > 0)) &&
                            ((member.getClassMask() == 0) || ((member.getClassMask() & classMask) > 0))) {
                            chR.setFlags(member.getFlags());
                        }
                    }
                });
                characterData.getReputations().put(i, chR);

            }
        }
    }

    /**
     * Add default power to character
     * 
     * @param characterData
     */
    private void addDefaultPowerToCharacter(final CharacterData characterData) {

        for (final Powers power : Powers.PLAYER_CREATE_POWERS) {
            switch (power) {
                case ENERGY:
                    characterData.setPower(power, 100);
                    characterData.setCreatePower(power, 100);
                    characterData.setMaxPower(power, 100);
                break;
                case RAGE:
                    characterData.setPower(power, 1000);
                    characterData.setCreatePower(power, 1000);
                    characterData.setMaxPower(power, 1000);
                break;
                case FOCUS:
                    characterData.setPower(power, 100);
                    characterData.setCreatePower(power, 100);
                    characterData.setMaxPower(power, 100);
                break;
                case RUNE:
                    characterData.setPower(power, 8);
                    characterData.setCreatePower(power, 8);
                    characterData.setMaxPower(power, 8);
                break;
                default:
                break;
            }
        }
    }

    /**
     * Add starting items to character
     * 
     * @param characterData
     */
    private void createStartItemToCharacter(final CharacterData characterData) {

        final List<CharStartOutfitEntity> startItems =
                this.charStartOutfitService.readCharStartOutfitEntities(characterData.getRace(),
                        characterData.getClazz(), characterData.getGender());

        for (final CharStartOutfitEntity startItem : startItems) {

            final ItemPrototype itemProto =
                    this.itemPrototypeService.readItemPrototype(startItem.getProtoId());
            if (itemProto == null) {
                CharacterControllerImpl.log.warn(
                        "CharStartOutfit contains item info, but not exist item's prototype for them. Item proto: {}",
                        startItem.getProtoId());
                continue;
            }
            final int stackCount = itemProto.getBuyCount();
            final FieldsItem item = this.itemService.createItem(itemProto, stackCount);
            item.setFlags(ItemFlags.JUST_CREATED.getValue());
            if (startItem.getSlot() < EquipmentSlots.values().length) {
                characterData.equipItem(EquipmentSlots.get(startItem.getSlot()), item);
            } else {
                characterData.addToInventory(item);
            }
        }
    }

    /**
     * Add starting skill and spells to character
     * 
     * @param characterData
     */
    private void createStartSkillAndSpellToCharacter(final CharacterData characterData) {

        final List<SkillRaceClassInfoEntity> skills =
                this.skillService.getSkillsForRaceClass(characterData.getRace(),
                        characterData.getClazz());
        for (final SkillRaceClassInfoEntity skillRaceClassInfo : skills) {
            final Integer addedSkill = skillRaceClassInfo.getSkillLine();
            CharacterControllerImpl.log.debug("Add skill {}", addedSkill);
            if (characterData.getSkillInfoBySkillId(addedSkill) != null) {
                continue;
            }
            final CharacterSkill chSkill = SkillFactory.getSkillById(addedSkill);
            if (chSkill != null) {
                chSkill.setSkillId(addedSkill);
                characterData.addSkillInfo(chSkill);
                final List<SkillLineAbilityEntity> spells =
                        this.skillLineAbilityService.getAbilitiesForRaceClassSkill(
                                characterData.getRace(), characterData.getClazz(), addedSkill);
                for (final SkillLineAbilityEntity skillLineAbility : spells) {
                    final Integer addedSpell = skillLineAbility.spellId;
                    final SpellEntity spell = this.spellService.getSpellById(addedSpell);
                    if (spell != null) {
                        spell.setSkillId(addedSkill);
                        characterData.addSpell(spell);
                    } else {
                        log.warn("Can't find spell prototype {}. Added with skill {}. ",
                                addedSpell, addedSkill);
                    }
                }
            } else {
                log.warn(
                        "Can't instantiate skill {} with SkillFactory. Skill skiped. Maby skill not added to factory.",
                        addedSkill);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.realm.controller.CharacterControllers#loadCharacterByGuid
     * (java.lang.Long)
     */
    @Override
    public CharacterData loadCharacterByGuid(final Long guid) {

        final CharacterData characterData = this.characterService.readCharacter(guid);
        if (characterData != null) {
            final PlayerClassLevelInfo classInfo =
                    this.playerClassLevelInfoStorages.get(characterData.getClazz(),
                            characterData.getLevel());
            final PlayerLevelInfo playerLevelInfo =
                    this.playerLevelStorages.get(characterData.getRace(), characterData.getClazz(),
                            characterData.getLevel());
            /**
             * Avoid hibernate bug
             */
            characterData.initBitsForCollections();

            for (final Stats stat : Stats.values()) {
                final int statValue = playerLevelInfo.getStats(stat);
                characterData.setStat(stat, statValue);
                characterData.setCreateStat(stat, statValue);
            }

            /**
             * from FieldsUnit
             */
            characterData.setBaseHealth(classInfo.getBasehealth());
            characterData.setBaseMana(classInfo.getBasemana());

            characterData.setCreatePower(Powers.HEALTH, classInfo.getBasehealth());
            characterData.setMaxPower(Powers.HEALTH, classInfo.getBasehealth());

            if (characterData.getPowerType() == Powers.MANA) {
                characterData.setCreatePower(characterData.getPowerType(), classInfo.getBasemana());
                characterData.setMaxPower(characterData.getPowerType(), classInfo.getBasemana());
            }
            initModelForCharacter(characterData);
            characterData.setMaxLevel(80);
            characterData.setNextLevelXp(this.playerXpForLevelStorages.getXpForLevel((byte) characterData.getLevel()));
            characterData.setWatchedFactionIndex(0xFFFFFFFF);
            characterData.updateMaxPowers();
        }
        return characterData;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.realm.controller.CharacterControllers#loadCharacterByName
     * (java.lang.String)
     */
    @Override
    public CharacterData loadCharacterByName(final String characterName) {

        final CharacterData characterData =
                this.characterService.readCharacterByName(characterName);
        if (characterData != null) {
            return loadCharacterByGuid(characterData.getGuid());
        }
        return null;
    }

    private void initModelForCharacter(final CharacterData characterData) {

        final byte gender = characterData.getGender().getValue();
        int model = 0;
        switch (characterData.getRace()) {
            case HUMAN:
                model = 49 + gender;
            break;
            case DWARF:
                model = 53 + gender;
            break;
            case NIGHTELF:
                model = 55 + gender;
            break;
            case GNOME:
                model = 1563 + gender;
            break;
            case DRAENEI:
                model = 16125 + gender;
            break;
            case ORC:
                model = 51 + gender;
            break;
            case UNDEAD:
                model = 57 + gender;
            break;
            case TAUREN:
                model = 59 + gender;
            break;
            case TROLL:
                model = 1478 + gender;
            break;
            case BLOODELF:
                model = 15476 - gender;
            break;
            default:
            break;
        }
        characterData.setDisplayId(ModelType.CURRENT, model);
        characterData.setDisplayId(ModelType.NATIVE, model);
    }

    @Override
    public void update(CharacterData pl) {
        long curtime = System.currentTimeMillis();
        if ((curtime - pl.getLastSaveTime()) > 2000) {
            log.info("Saving character: {}", pl.getName());
            this.characterService.createOrUpdateCharacter(pl);
            pl.setLastSaveTime(curtime);
        }
        // TODO: update character info, stats etc..

    }

}
