package org.jmangos.tools.dbcconverter.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "dbcStorages")
public class DbcStorages {
    
    private static final Logger logger = LoggerFactory.getLogger(DbcStorages.class);
    @Autowired
    CharOutfitService           charOutfitService;
    
    public void encode() {
    
        logger.info("Start encoding dbc files");
        this.charOutfitService.saveAll();
        logger.info("Finished encoding dbc files");
    }
}
