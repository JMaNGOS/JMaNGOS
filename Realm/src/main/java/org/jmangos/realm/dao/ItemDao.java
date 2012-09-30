/**
 * 
 */
package org.jmangos.realm.dao;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.entities.FieldsItem;

/**
 * @author MinimaJack
 * 
 */
public interface ItemDao {

    FieldsItem readItem(Long id);

    List<FieldsItem> readItems(Criterion... criterions);

    Long createOrUpdateItem(FieldsItem givenItem);

    void deleteItem(FieldsItem givenItem);

}
