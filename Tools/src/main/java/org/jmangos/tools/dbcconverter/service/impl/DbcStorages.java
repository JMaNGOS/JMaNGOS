/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
    @Autowired
    SkillRaceClassInfoService skillRaceClassInfoService;
    @Autowired
    FactionService factionService;
    @Autowired
    WorldMapAreaService worldMapAreaService;
    @Autowired
    AreaTableService areaTableService;
    @Autowired
    MapService mapService;
    @Autowired
    ChrClassesService chrClassesService;
    @Autowired
    ChrRacesService chrRacesService;

    public void encode() {

        logger.info("Start encoding dbc files");
//        this.charOutfitService.saveAll();
//        this.skillLineAbilityService.saveAll();
//        this.skillRaceClassInfoService.saveAll();
//        this.spellService.saveAll();
//        this.factionService.saveAll();
//        this.worldMapAreaService.saveAll();
//        this.areaTableService.saveAll();
//        this.mapService.saveAll();
        chrClassesService.saveAll();
        chrRacesService.saveAll();
        logger.info("Finished encoding dbc files");
    }
}
