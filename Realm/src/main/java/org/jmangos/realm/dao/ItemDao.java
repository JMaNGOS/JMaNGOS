/**
 * 
 */
package org.jmangos.realm.dao;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.entities.ItemEntity;

/**
 * @author MinimaJack
 * 
 */
public interface ItemDao {
    
    ItemEntity readItem(Integer id);
    
    List<ItemEntity> readItems(Criterion... criterions);
    
    Integer createOrUpdateItem(ItemEntity givenItem);
    
    void deleteItem(ItemEntity givenItem);
    
}
