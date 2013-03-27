/**
 * 
 */
package org.jmangos.realm.dao;

import org.jmangos.commons.entities.FieldsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MinimaJack
 * 
 */
@Repository
@Transactional("realm")
public interface ItemDao extends JpaRepository<FieldsItem, Long> {

}
