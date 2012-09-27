/**
 * 
 */
package org.jmangos.realm.model;

/**
 * @author MinimaJack
 * 
 */
public class UnitRegenModifier {
    
    private float flat;
    
    private float interrupted;
    
    public UnitRegenModifier() {
    
    }
    
    /**
     * @return the flat
     */
    public final float getFlat() {
    
        return this.flat;
    }
    
    /**
     * @param flat
     *            the flat to set
     */
    public final void setFlat(final float flat) {
    
        this.flat = flat;
    }
    
    /**
     * @return the interrupted
     */
    public final float getInterrupted() {
    
        return this.interrupted;
    }
    
    /**
     * @param interrupted
     *            the interrupted to set
     */
    public final void setInterrupted(final float interrupted) {
    
        this.interrupted = interrupted;
    }
    
}
