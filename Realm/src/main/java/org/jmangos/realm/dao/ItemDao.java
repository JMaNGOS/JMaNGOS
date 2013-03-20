/**
 * 
 */
package org.jmangos.realm.dao;

import java.util.List;

import org.jmangos.commons.entities.FieldsItem;

/**
 * @author MinimaJack
 * 
 */
public interface ItemDao {

    FieldsItem readItem(Long id);

    List<FieldsItem> readItems();

    Long createOrUpdateItem(FieldsItem givenItem);

    void deleteItem(FieldsItem givenItem);

}
