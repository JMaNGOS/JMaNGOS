package org.jmangos.realm.services;

public interface SimpleStoragesService {
    
    /**
     * Gets the xp for level.
     * 
     * @param level
     * @return needed experience
     */
    public abstract Integer getXpForLevel(byte level);
    
}