/**
 * 
 */
package org.jmangos.world.dao;

import org.jmangos.commons.entities.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MinimaJack
 * 
 */
@Repository
@Transactional(readOnly = true)
public interface SpellDao extends JpaRepository<SpellEntity, Integer> {

}
