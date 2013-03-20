package org.jmangos.world.dao;

import java.util.List;

import org.jmangos.commons.entities.PlayerXpForLevel;

public interface PlayerXpForLevelDao {

    /**
     * 
     * @return PlayerXpForLevel
     */
    public abstract PlayerXpForLevel readXpForLevel(Byte id);

    /**
     * 
     * @param criterions
     * @return
     */
    public abstract List<PlayerXpForLevel> readPlayerXpForLevels();

    public abstract Byte createOrUpdatePlayerLevelInfo(PlayerXpForLevel playerXpForLevel);

    public abstract void deletePlayerXpForLevel(PlayerXpForLevel playerXpForLevel);

}
