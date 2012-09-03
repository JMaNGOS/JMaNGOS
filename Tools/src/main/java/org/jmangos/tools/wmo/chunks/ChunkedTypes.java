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
package org.jmangos.tools.wmo.chunks;

public enum ChunkedTypes {
    MVER("REVM"),
    MOHD("DHOM"),
    MOTX("XTOM"),
    MOMT("TMOM"),
    MOGN("NGOM"),
    MOGI("IGOM"),
    MOSB("BSOM"),
    MOPV("VPOM"),
    MOPT("TPOM"),
    MOPR("RPOM"),
    MOVV("VVOM"),
    MOVB("BVOM"),
    MOLT("TLOM"),
    MODS("SDOM"),
    MODN("NDOM"),
    MODD("DDOM"),
    MFOG("GOFM"),
    MCVP("PVCM"),
    // group
    MOGP("PGOM"),
    MOPY("YPOM"),
    MOVI("IVOM"),
    MOVT("TVOM"),
    MONR("RNOM"),
    MOTV("VTOM"),
    MOBA("ABOM"),
    
    MOLR("RLOM"),
    MODR("RDOM"),
    MOBN("NBOM"),
    MOBR("RBOM"),
    MPBV("VBPM"),
    MPBP("PBPM"),
    MPBI("IBPM"),
    MPBG("GBPM"),
    MOCV("VCOM"),
    MLIQ("QILM"),
    MORI("IROM"),
    MORB("BROM");
    
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
