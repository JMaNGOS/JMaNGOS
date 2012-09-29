/**
 * 
 */
package org.jmangos.auth.realm.container;

import org.jmangos.commons.dataholder.IdKeyContainer;
import org.jmangos.commons.model.RealmInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author MinimaJack
 * 
 */
public class RealmServersContainer extends IdKeyContainer<RealmInfo> {
    
    /** Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(RealmServersContainer.class);
    
    @Override
    public void onDataNotPresentEvent(final long objectId) {
    
        logger.error("Realm with id {} not exist in container.", objectId);
        
    }
    
    @Override
    public void onDataAlreadyAddedEvent(final long objectId) {
    
        logger.error("Realm server already in container. Duplicate Id : {}", objectId);
        
    }
}
