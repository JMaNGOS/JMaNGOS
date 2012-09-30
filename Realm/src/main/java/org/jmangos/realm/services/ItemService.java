/**
 * 
 */
package org.jmangos.realm.services;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.entities.FieldsItem;
import org.jmangos.world.entities.ItemPrototype;

/**
 * @author MinimaJack
 * 
 */
public interface ItemService {

    FieldsItem readItem(Long id);

    List<FieldsItem> readItems(Criterion... criterions);

    Long createOrUpdateItem(FieldsItem item);

    void deleteItem(FieldsItem item);

    FieldsItem createItem(ItemPrototype itemProto, int itemCount);

}
