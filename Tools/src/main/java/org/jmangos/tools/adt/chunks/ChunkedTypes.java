/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.tools.adt.chunks;

public enum ChunkedTypes {
    MVER("REVM"),
    MHDR("RDHM"),
    MCIN("NICM"),
    MTEX("XETM"),
    MMDX("XDMM"),
    MMID("DIMM"),
    MWMO("OMWM"),
    MWID("DIWM"),
    MDDF("FDDM"),
    MODF("FDOM"),
    MH2O("O2HM"),
    MCNK("KNCM"), ;
    
    private String value;
    
    ChunkedTypes(final String val) {
    
        setValue(val);
    }
    
    public void setValue(final String value) {
    
        this.value = value;
    }
    
    public String getValue() {
    
        return this.value;
    }
    
    public static ChunkedTypes get(final String value) {
    
        for (final ChunkedTypes ch : ChunkedTypes.values()) {
            if (value.equals(ch.getValue())) {
                return ch;
            }
        }
        return null;
        
    }
}
