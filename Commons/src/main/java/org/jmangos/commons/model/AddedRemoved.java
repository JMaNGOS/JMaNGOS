/**
 * 
 */
package org.jmangos.commons.model;

/**
 * @author MinimaJack
 * 
 */
public interface AddedRemoved {

    public void onAdd(CanUseSpell player);

    public void onRemove(CanUseSpell player);
}
