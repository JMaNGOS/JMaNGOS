/**
 * 
 */
package org.jmangos.realm.services;

import java.util.List;

import org.jmangos.commons.entities.FieldsItem;
import org.jmangos.commons.entities.ItemPrototype;

/**
 * @author MinimaJack
 * 
 */
public interface ItemService {

    FieldsItem readItem(Long id);

    List<FieldsItem> readItems();

    Long createOrUpdateItem(FieldsItem item);

    void deleteItem(FieldsItem item);

    FieldsItem createItem(ItemPrototype itemProto, int itemCount);

}
