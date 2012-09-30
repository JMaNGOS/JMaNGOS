package org.jmangos.commons.dataholder;

/**
 * 
 * @author MinimaJack
 * 
 * @param <T>
 */
public interface Visitable<T> {

    /**
     * @param visitor
     */
    void iterate(Visitor<T> visitor);

}
