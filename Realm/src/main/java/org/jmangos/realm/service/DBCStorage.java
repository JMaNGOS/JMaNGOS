package org.jmangos.realm.service;

import org.apache.log4j.Logger;
import org.jmangos.commons.service.Service;
import org.jmangos.realm.dbc.dataholder.DBCDataLoader;
import org.jmangos.realm.dbc.struct.CharStartOutfitEntry;
import org.jmangos.realm.model.player.CharacterStartOutfit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.12.
 * Time: 14:54
 */
public class DBCStorage implements Service {
    Logger log = Logger.getLogger( getClass() );

    List<CharacterStartOutfit> outfitEntries = new ArrayList<CharacterStartOutfit>();

    @Override
    public void start() {
        outfitEntries.clear();
        CharStartOutfitEntry entry = DBCDataLoader.loadStaticData(CharStartOutfitEntry.class, "dbc/Charstartoutfit.dbc");
        do {
            outfitEntries.add( new CharacterStartOutfit( entry ));
        } while ( (entry = entry.next()) != null );

        log.info( String.format( "Loaded DBC: Charstartoutfit.dbc with [%d] entries.", outfitEntries.size() ) );
    }

    @Override
    public void stop() {}

    public List<CharacterStartOutfit> getOutfitEntries() {
        return outfitEntries;
    }
}
