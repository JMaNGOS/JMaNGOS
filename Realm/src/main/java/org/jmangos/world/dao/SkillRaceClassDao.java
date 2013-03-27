/**
 * 
 */
package org.jmangos.world.dao;

import org.jmangos.commons.entities.SkillRaceClassInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author MinimaJack
 * 
 */
@Repository
@Transactional(readOnly = true)
public interface SkillRaceClassDao
        extends JpaRepository<SkillRaceClassInfoEntity, Integer>,
        JpaSpecificationExecutor<SkillRaceClassInfoEntity> {

}
