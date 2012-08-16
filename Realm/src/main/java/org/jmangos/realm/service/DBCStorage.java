package org.jmangos.realm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jmangos.commons.service.Service;
import org.jmangos.realm.dbc.dataholder.DBCDataLoader;
import org.jmangos.realm.dbc.struct.CharStartOutfitEntry;
import org.jmangos.realm.model.player.CharacterStartOutfit;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.12. Time:
 * 14:54
 */
public class DBCStorage implements Service {
    
    Logger                     log           = Logger.getLogger(getClass());
    
    List<CharacterStartOutfit> outfitEntries = new ArrayList<CharacterStartOutfit>();
    
    @Override
    public void start() {
    
        this.outfitEntries.clear();
        CharStartOutfitEntry entry = DBCDataLoader.loadStaticData(CharStartOutfitEntry.class, "dbc/Charstartoutfit.dbc");
        do {
            this.outfitEntries.add(new CharacterStartOutfit(entry));
        } while ((entry = entry.next()) != null);
        
        this.log.info(String.format("Loaded DBC: Charstartoutfit.dbc with [%d] entries.", this.outfitEntries.size()));
    }
    
    @Override
    public void stop() {
    
    }
    
    public List<CharacterStartOutfit> getOutfitEntries() {
    
        return this.outfitEntries;
    }
}
