package org.jmangos.realm.controller;

import java.util.List;

import javax.inject.Inject;

import org.criteria4jpa.criterion.Criterion;
import org.criteria4jpa.criterion.Restrictions;
import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.enums.EquipmentSlots;
import org.jmangos.realm.domain.PlayercreateinfoPK;
import org.jmangos.realm.entities.CharacterData;
import org.jmangos.realm.entities.CharacterPositionerHolder;
import org.jmangos.realm.entities.CharacterPowers;
import org.jmangos.realm.entities.FieldsItem;
import org.jmangos.realm.entities.HomeBindData;
import org.jmangos.realm.entities.Position;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Gender;
import org.jmangos.realm.model.enums.ModelType;
import org.jmangos.realm.model.enums.Powers;
import org.jmangos.realm.model.enums.Races;
import org.jmangos.realm.model.enums.Stats;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CREATE;
import org.jmangos.realm.service.ItemStorages;
import org.jmangos.realm.service.PlayerClassLevelInfoStorages;
import org.jmangos.realm.service.PlayerLevelStorages;
import org.jmangos.realm.service.PlayerXpForLevelStorages;
import org.jmangos.realm.services.CharacterService;
import org.jmangos.realm.services.ItemService;
import org.jmangos.world.entities.ItemPrototype;
import org.jmangos.world.entities.PlayerClassLevelInfo;
import org.jmangos.world.entities.PlayerLevelInfo;
import org.jmangos.world.entities.Playercreateinfo;
import org.jmangos.world.services.CharStartOutfitService;
import org.jmangos.world.services.PlayercreateinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterController {

    /** The Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(CharacterController.class);

    @Inject
    private CharacterService characterService;

    @Inject
    private PlayercreateinfoService playercreateinfoService;

    @Autowired
    private CharStartOutfitService charStartOutfitService;

    @Autowired
    ItemService itemService;

    @Autowired
    ItemStorages itemStorages;

    /** The player level storages. */
    @Autowired
    private PlayerLevelStorages playerLevelStorages;

    @Autowired
    private PlayerClassLevelInfoStorages playerClassLevelInfoStorages;

    @Autowired
    PlayerXpForLevelStorages playerXpForLevelStorages;

    public SMSG_CHAR_CREATE.Code createCharacter(final long accountId, final String charName,
            final Races race, final Classes clazz, final Gender gender, final int skin,
            final int face, final int hairStyle, final int hairColor, final int facialHair) {

        final Criterion criterion = Restrictions.eq("name", charName);
        final List<CharacterData> characterDatas = this.characterService.readCharacters(criterion);
        if ((characterDatas != null) && !characterDatas.isEmpty()) {
            CharacterController.logger.warn("Username already exists: " + charName);
            return SMSG_CHAR_CREATE.Code.NAME_IN_USE;
        }

        final Playercreateinfo info =
                this.playercreateinfoService.readPlayercreateinfo(new PlayercreateinfoPK(
                        race.getValue(), clazz.getValue()));
        if (info == null) {
            logger.error("Player create template not found for: " + clazz + " " + race);
            return SMSG_CHAR_CREATE.Code.ERROR;
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
        // final PlayerLevelInfo playerLevelInfo =
        // this.playerLevelStorages.get(race, clazz, 1);
        final PlayerClassLevelInfo classInfo = this.playerClassLevelInfoStorages.get(clazz, 1);

        // TODO: make a config to create some inital value
        characterData.setMoney(0);

        characterData.setXp(0);

        final CharacterPowers up = new CharacterPowers();
        characterData.setPowers(up);

        for (final Powers power : Powers.PLAYER_CREATE_POWERS) {
            switch (power) {
                case ENERGY:
                    characterData.setPower(power, 100);
                break;
                case RAGE:
                    characterData.setPower(power, 1000);
                break;
                case FOCUS:
                    characterData.setPower(power, 100);
                break;
                case RUNE:
                    characterData.setPower(power, 8);
                break;
                default:
                    characterData.setPower(power, 0);
            }
        }
        characterData.setPower(Powers.HEALTH, classInfo.getBasehealth());
        characterData.setPower(characterData.getPowerType(), classInfo.getBasemana());

        characterData.setLevel(1);
        // First login
        characterData.setAtLoginFlag(0x1);

        final CharacterPositionerHolder mh = new CharacterPositionerHolder();

        mh.setMap(info.getMap());
        mh.setZone(info.getZone());

        final Position pos = new Position();
        pos.setX(info.getPositionX());
        pos.setY(info.getPositionY());
        pos.setZ(info.getPositionZ());
        pos.setO(info.getOrientation());
        mh.setPosition(pos);

        characterData.setMovement(mh);

        final HomeBindData hbd = new HomeBindData();
        hbd.setHomeBindAreaId(info.getZone());
        hbd.setHomeBindMapId(info.getMap());
        hbd.setPosition(mh.getPosition().clone());
        mh.setHomeBindData(hbd);

        this.characterService.createOrUpdateCharacter(characterData);

        final List<CharStartOutfitEntity> startItems =
                this.charStartOutfitService.readCharStartOutfitEntities(characterData.getRace(),
                        characterData.getClazz(), characterData.getGender().getValue());
        for (final CharStartOutfitEntity startItem : startItems) {

            final ItemPrototype itemProto = this.itemStorages.get(startItem.getProtoId());
            if (itemProto == null) {
                continue;
            }
            logger.info("Create item {}", startItem.getProtoId());
            final int stackCount = itemProto.getBuyCount();
            final FieldsItem item = this.itemService.createItem(itemProto, stackCount);

            if (startItem.getSlot() < EquipmentSlots.values().length) {
                characterData.equipItem(EquipmentSlots.get(startItem.getSlot()), item);
            } else {
                characterData.addToInventory(item);
            }
        }

        this.characterService.createOrUpdateCharacter(characterData);
        return SMSG_CHAR_CREATE.Code.SUCCESS;
    }

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
                int statValue = playerLevelInfo.getStats(stat);
                characterData.setStat(stat, statValue);
                characterData.setCreateStat(stat, statValue);
            }
            characterData.setBaseHealth(classInfo.getBasehealth());
            characterData.setBaseMana(classInfo.getBasemana());
            characterData.setCreatePower(Powers.HEALTH, classInfo.getBasehealth());
            characterData.setCreatePower(characterData.getPowerType(), classInfo.getBasemana());
            initModelForCharacter(characterData);
            characterData.setMaxLevel(80);
            characterData.setNextLevelXp(this.playerXpForLevelStorages.getXpForLevel((byte) characterData.getLevel()));
            characterData.setWatchedFactionIndex(0xFFFFFFFF);
            characterData.updateMaxPowers();
        }
        return characterData;
    }

    /**
     * <b>Don't drop</b><br />
     * <i>Exist only for Test</i>
     * 
     * @param characterName
     * @return Player
     */
    public CharacterData loadCharacterByName(final String characterName) {

        final Criterion criterion = Restrictions.eq("name", characterName);
        final List<CharacterData> characterDatas = this.characterService.readCharacters(criterion);
        if ((characterDatas != null) && !characterDatas.isEmpty()) {

            final CharacterData characterData = characterDatas.get(0);

            final PlayerClassLevelInfo classInfo =
                    this.playerClassLevelInfoStorages.get(characterData.getClazz(),
                            characterData.getLevel());

            characterData.setCreatePower(Powers.HEALTH, classInfo.getBasehealth());
            characterData.setCreatePower(characterData.getPowerType(), classInfo.getBasemana());
            characterData.setBaseHealth(classInfo.getBasehealth());
            characterData.setBaseMana(classInfo.getBasemana());
            /**
             * Avoid hibernate bug
             */
            characterData.initBitsForCollections();

            final PlayerLevelInfo playerLevelInfo =
                    this.playerLevelStorages.get(characterData.getRace(), characterData.getClazz(),
                            characterData.getLevel());
            for (final Stats stat : Stats.values()) {
                int statValue = playerLevelInfo.getStats(stat);
                characterData.setStat(stat, statValue);
                characterData.setCreateStat(stat, statValue);
            }

            characterData.updateMaxPowers();
            return characterData;
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

}
