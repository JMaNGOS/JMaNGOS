/**
 * 
 */
package org.jmangos.world.services;

import java.util.List;

import org.jmangos.commons.entities.SpellEntity;

/**
 * @author MinimaJack
 * 
 */
public interface SpellService {

    SpellEntity getSpellById(Integer id);

    List<SpellEntity> readSpells();

}
