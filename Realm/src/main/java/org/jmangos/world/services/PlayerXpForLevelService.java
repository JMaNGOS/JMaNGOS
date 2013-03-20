package org.jmangos.world.services;

import java.util.List;

import org.jmangos.commons.entities.PlayerXpForLevel;

public interface PlayerXpForLevelService {

    public PlayerXpForLevel readPlayerXpForLevel(Byte level);

    public List<PlayerXpForLevel> readPlayerLevelInfos();

    public Byte createOrUpdatePlayerLevelInfo(PlayerXpForLevel playerLevelInfo);

    public void deletePlayerXpForLevel(PlayerXpForLevel playerLevelInfo);

}
