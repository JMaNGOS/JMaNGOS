/**
 * 
 */
package org.jmangos.realm.services;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.entities.ItemEntity;

/**
 * @author MinimaJack
 * 
 */
public interface ItemService {
    
    ItemEntity readItem(Integer id);
    
    List<ItemEntity> readItems(Criterion... criterions);
    
    Integer createOrUpdateItem(ItemEntity itemEntity);
    
    void deleteItem(ItemEntity itemEntity);
    
}
