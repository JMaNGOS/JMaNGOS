/**
 * 
 */
package org.jmangos.world.dao;

import org.jmangos.commons.entities.SkillLineAbilityEntity;
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
public interface SkillLineAbilityDao
        extends JpaRepository<SkillLineAbilityEntity, Integer>,
        JpaSpecificationExecutor<SkillLineAbilityEntity> {

}
