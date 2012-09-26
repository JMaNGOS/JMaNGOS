package org.jmangos.realm.model.enums;

/**
 * <ul>
 * <li><b>RESTED</b></li>
 * <li><b>NORMAL</b></li>
 * <li><b>RAF_LINKED</b> - unused??</li>
 * </ul>
 * 
 * @author MinimaJack
 * 
 */
public enum RestState {
    RESTED((byte) 0x01),
    NORMAL((byte) 0x02),
    RAF_LINKED((byte) 0x04);
    
    private byte value;
    
    RestState(final byte val) {
    
        this.value = val;
    }
    
    /**
     * @return the value
     */
    public final byte getValue() {
    
        return this.value;
    }
    
    /**
     * @param value
     *            the value to set
     */
    public final void setValue(final byte value) {
    
        this.value = value;
    }
    
}
