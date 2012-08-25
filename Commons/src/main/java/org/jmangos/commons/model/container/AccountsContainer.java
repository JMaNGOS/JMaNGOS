package org.jmangos.commons.model.container;

import org.jmangos.commons.dataholder.IdNameKeyContainer;
import org.jmangos.commons.model.AccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountsContainer extends IdNameKeyContainer<AccountInfo> {
    
    /** Constant logger. */
    private static final Logger logger = LoggerFactory.getLogger(AccountsContainer.class);
    
    @Override
    public void onDataNotPresentEvent(final int objectId) {
    
        logger.error("Account with id {} not exist in container.", objectId);
        
    }
    
    @Override
    public void onDataAlreadyAddedEvent(final int objectId) {
    
        logger.error("Account data already in container. Duplicate Id : {}", objectId);
        
    }
    
}
