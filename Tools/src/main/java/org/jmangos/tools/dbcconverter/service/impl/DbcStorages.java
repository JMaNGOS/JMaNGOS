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
    CharOutfitService charOutfitService;
    @Autowired
    SpellService spellService;
    @Autowired
    SkillLineAbilityService skillLineAbilityService;
    public void encode() {

        logger.info("Start encoding dbc files");
       // this.charOutfitService.saveAll();
        //this.spellService.saveAll();
        this.skillLineAbilityService.saveAll();
        logger.info("Finished encoding dbc files");
    }
}
