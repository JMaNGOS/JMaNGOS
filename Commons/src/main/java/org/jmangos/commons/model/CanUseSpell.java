/**
 * 
 */
package org.jmangos.commons.model;

import org.jmangos.commons.entities.SpellEntity;
import org.jmangos.commons.enums.ItemClass;

/**
 * @author MinimaJack
 * 
 */
public interface CanUseSpell {

    public boolean addToSpellContainer(SpellEntity spell);

    public void addProficiency(ItemClass itemclass, int mask);

    public void removeProficiency(ItemClass itemclass, int mask);
}
