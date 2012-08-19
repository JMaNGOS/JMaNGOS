package org.jmangos.realm.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jmangos.commons.service.Service;
import org.jmangos.realm.dbc.dataholder.DBCDataLoader;
import org.jmangos.realm.dbc.struct.CharStartOutfitEntry;
import org.jmangos.realm.model.player.CharacterStartOutfit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.12. Time:
 * 14:54
 */
@Component
public class DBCStorage implements Service {
    
    /** The Constant logger. */
    private static final Logger log           = LoggerFactory.getLogger(DBCStorage.class);
    
    List<CharacterStartOutfit>  outfitEntries = new ArrayList<CharacterStartOutfit>();
    
    @PostConstruct
    @Override
    public void start() {
    
        this.outfitEntries.clear();
        CharStartOutfitEntry entry = DBCDataLoader.loadStaticData(CharStartOutfitEntry.class, "dbc/Charstartoutfit.dbc");
        do {
            this.outfitEntries.add(new CharacterStartOutfit(entry));
        } while ((entry = entry.next()) != null);
        
        log.info("Loaded DBC: Charstartoutfit.dbc with {} entries.", this.outfitEntries.size());
    }
    
    @Override
    public void stop() {
    
    }
    
    public List<CharacterStartOutfit> getOutfitEntries() {
    
        return this.outfitEntries;
    }
}
