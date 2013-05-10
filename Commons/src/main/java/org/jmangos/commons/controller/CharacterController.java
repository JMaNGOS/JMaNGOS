package org.jmangos.commons.controller;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.enums.*;
import org.springframework.transaction.annotation.Transactional;

public interface CharacterController {

    @Transactional("realm")
    public abstract CharCreateCode createCharacter(long accountId, String charName, Races race,
            Classes clazz, Gender gender, int skin, int face, int hairStyle, int hairColor,
            int facialHair);

    @Transactional("realm")
    public abstract CharCreateCode updateCharacter(long characterId, String charNewName,
            Gender gender, int skin, int face, int hairStyle, int hairColor, int facialHair);

    public abstract CharDeleteCode deleteCharacter(long guid);

    public abstract CharacterData loadCharacterByGuid(Long guid);

    /**
     * <b>Don't drop</b><br />
     * <i>Exist only for Test</i>
     * 
     * @param characterName
     * @return Player
     */
    public abstract CharacterData loadCharacterByName(String characterName);

    public abstract void update(CharacterData pl);

}
