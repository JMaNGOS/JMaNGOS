package org.jmangos.world.dao;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.world.entities.PlayerXpForLevel;

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
    public abstract List<PlayerXpForLevel> readPlayerXpForLevels(Criterion... criterions);
    
    public abstract Byte createOrUpdatePlayerLevelInfo(PlayerXpForLevel playerXpForLevel);
    
    public abstract void deletePlayerXpForLevel(PlayerXpForLevel playerXpForLevel);
    
}