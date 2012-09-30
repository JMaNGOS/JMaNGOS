/**
 * 
 */
package org.jmangos.commons.dataholder;

/**
 * @author MinimaJack
 * 
 */
public interface Visitor<T> {

    void visit(T member);
}
