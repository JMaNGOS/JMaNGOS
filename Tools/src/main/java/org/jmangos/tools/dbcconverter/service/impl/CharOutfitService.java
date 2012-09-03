/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javolution.io.Struct.Signed32;

import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;
import org.jmangos.tools.dbc.struct.CharStartOutfitEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "charOutfitService")
public class CharOutfitService extends AbstractDbcService<CharStartOutfitEntity, CharStartOutfitEntry> {
    
    CharOutfitService() {
    
        super();
    }
    
    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;
    
    @Override
    public void save(final CharStartOutfitEntity charStartOutfitEntity) {
    
        if (charStartOutfitEntity.getCharStartOutfitEntityPk() == null) {
            this.entityManager.persist(charStartOutfitEntity);
        } else {
            this.entityManager.merge(charStartOutfitEntity);
        }
        
    }
    
    @Override
    public void saveAll() {
    
        CharStartOutfitEntry entry = getEntry();
        do {
            int numbItem = 0;
            for (final Signed32 itemDisplayId : entry.ItemDisplayId) {
                if (itemDisplayId.get() > 0) {
                    final CharStartOutfitEntity tf = new CharStartOutfitEntity();
                    final CharStartOutfitEntityPk pk = new CharStartOutfitEntityPk();
                    pk.setClazz(entry.clazz.get());
                    pk.setGender(entry.gender.get());
                    pk.setRace(entry.race.get());
                    pk.setItemInventorySlot(entry.ItemInventorySlot[numbItem].get());
                    
                    tf.setItemId(entry.ItemId[numbItem].get());
                    tf.setItemDisplayId(entry.ItemDisplayId[numbItem].get());
                    tf.setCharStartOutfitEntityPk(pk);
                    this.entityManager.merge(tf);
                }
                numbItem++;
            }
            
        } while ((entry = entry.next()) != null);
        
    }
    
    @Override
    public String getDbcPath() {
    
        return "./../realm/dbc/Charstartoutfit.dbc";
    }
    
}
