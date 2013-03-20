/**
 * 
 */
package org.jmangos.world.dao;

import java.util.List;

import org.jmangos.commons.entities.SpellEntity;

/**
 * @author MinimaJack
 * 
 */
public interface SpellDao {

    SpellEntity readSpell(Integer id);

    List<SpellEntity> readSpells();

    Integer createOrUpdateSpell(SpellEntity givenSpell);

    void deleteSpell(SpellEntity givenSpell);

}
