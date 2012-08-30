package org.jmangos.world.services;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.world.entities.PlayerXpForLevel;

public interface PlayerXpForLevelService {
    
    public PlayerXpForLevel readPlayerXpForLevel(Byte level);
    
    public List<PlayerXpForLevel> readPlayerLevelInfos(final Criterion... criterions);
    
    public Byte createOrUpdatePlayerLevelInfo(PlayerXpForLevel playerLevelInfo);
    
    public void deletePlayerXpForLevel(PlayerXpForLevel playerLevelInfo);
    
}