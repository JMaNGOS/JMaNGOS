package org.jmangos.realm.model;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.10. Time: 4:24
 */
public enum Races {
    DRAENEI(0x11),
    DWARF(0x03),
    GNOME(0x07),
    HUMAN(0x01),
    NIGHTELF(0x04),
    BLOODELF(0x10),
    ORC(0x02),
    TAUREN(0x06),
    TROLL(0x08),
    UNDEAD(0x05);
    
    private int value;
    
    Races(final int value) {
    
        this.value = value;
    }
    
    public void setValue(final int value) {
    
        this.value = value;
    }
    
    public int getValue() {
    
        return this.value;
    }
    
    public static Races get(final int value) {
    
        for (final Races val : values()) {
            if (val.getValue() == value) {
                return val;
            }
        }
        
        return null;
    }
}
