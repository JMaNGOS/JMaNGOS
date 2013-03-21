package org.jmangos.world.dao;

import org.jmangos.commons.entities.PlayerXpForLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface PlayerXpForLevelDao extends JpaRepository<PlayerXpForLevel, Byte> {

}
