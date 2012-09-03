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
package org.jmangos.tools.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.jmangos.tools.dbc.dataholder.DBCStruct;

enum MapTypes // Lua_IsInInstance
{
    MAP_COMMON, // none
    MAP_INSTANCE, // party
    MAP_RAID, // raid
    MAP_BATTLEGROUND, // pvp
    MAP_ARENA; // arena
};

public class MapEntry extends DBCStruct<MapEntry> {
    
    @XmlAttribute(name = "id", required = true)
    public final Unsigned32          id                      = new Unsigned32();         // 0
    @XmlAttribute(name = "internalname")
    public final InternalString      internalname            = new InternalString();     // 1
                                                                                          // unused
    @XmlAttribute(name = "mapType", required = true)
    public final Unsigned32          mapType                 = new Unsigned32();         // 2
    public final Unsigned32          mapFlags                = new Unsigned32();         // 3 some
                                                                                          // kind of
                                                                                          // flags
                                                                                          // (0x100
                                                                                          // -
                                                                                          // CAN_CHANGE_PLAYER_DIFFICULTY)
    public final Unsigned32          isPvP                   = new Unsigned32();         // 4 0 or
                                                                                          // 1 for
                                                                                          // battlegrounds
                                                                                          // (not
                                                                                          // arenas)
    @XmlAttribute(name = "name", required = true)
    public final MultiInternalString name                    = new MultiInternalString(); // 5-20
    @XmlAttribute(name = "linkedZone", required = true)
    public final Unsigned32          linkedZone              = new Unsigned32();         // 22
                                                                                          // common
                                                                                          // zone
                                                                                          // for
                                                                                          // instance
                                                                                          // and
                                                                                          // continent
                                                                                          // map
    @XmlAttribute(name = "hordeIntro")
    public final MultiInternalString hordeIntro              = new MultiInternalString(); // 23-38
                                                                                          // text
                                                                                          // for PvP
                                                                                          // Zones
    @XmlAttribute(name = "allianceIntro")
    public final MultiInternalString allianceIntro           = new MultiInternalString(); // 40-55
                                                                                          // text
                                                                                          // for PvP
                                                                                          // Zones
    @XmlAttribute(name = "multimapId", required = true)
    public final Unsigned32          multimapId              = new Unsigned32();         // 57
                                                                                          // index
                                                                                          // in
                                                                                          // LoadingScreens.dbc
    public final Float32             BattlefieldMapIconScale = new Float32();            // 58
                                                                                          // BattlefieldMapIconScale
    @XmlAttribute(name = "ghostEntranceMap", required = true)
    public final Signed32            ghostEntranceMap        = new Signed32();           // 59
                                                                                          // map_id
                                                                                          // of
                                                                                          // entrance
                                                                                          // map in
                                                                                          // ghost
                                                                                          // mode
                                                                                          // (continent
                                                                                          // always
                                                                                          // and in
                                                                                          // most
                                                                                          // cases =
                                                                                          // normal
                                                                                          // entrance)
    @XmlAttribute(name = "ghostEntranceX", required = true)
    public final Float32             ghostEntranceX          = new Float32();            // 60
                                                                                          // entrance
                                                                                          // x
                                                                                          // coordinate
                                                                                          // in
                                                                                          // ghost
                                                                                          // mode
                                                                                          // (in
                                                                                          // most
                                                                                          // cases =
                                                                                          // normal
                                                                                          // entrance)
    @XmlAttribute(name = "ghostEntranceY", required = true)
    public final Float32             ghostEntranceY          = new Float32();            // 61
                                                                                          // entrance
                                                                                          // y
                                                                                          // coordinate
                                                                                          // in
                                                                                          // ghost
                                                                                          // mode
                                                                                          // (in
                                                                                          // most
                                                                                          // cases =
                                                                                          // normal
                                                                                          // entrance)
    @XmlAttribute(name = "timeOfDayOverride")
    public final Signed32            timeOfDayOverride       = new Signed32();           // 62 time
                                                                                          // of day
                                                                                          // override
    @XmlAttribute(name = "addon", required = true)
    public final Unsigned32          addon                   = new Unsigned32();         // 63
                                                                                          // expansion
    @XmlAttribute(name = "unktime")
    public final Unsigned32          unktime                 = new Unsigned32();         // 63
                                                                                          // expansion
    @XmlAttribute(name = "maxPlayers")
    public final Unsigned32          maxPlayers              = new Unsigned32();         // 65 max
                                                                                          // players
                                                                                          
    public boolean isMountAllowed() {
    
        return !isDungeon() || (this.id.get() == 209) || (this.id.get() == 269) || (this.id.get() == 309) || /**
         * 
         * 
         * TanarisInstance, CavernsOfTime, Zul'gurub
         */
        (this.id.get() == 509) || (this.id.get() == 534) || (this.id.get() == 560) || /**
         * AhnQiraj,
         * HyjalPast, HillsbradPast
         */
        (this.id.get() == 568) || (this.id.get() == 580) || (this.id.get() == 595) || /**
         * ZulAman,
         * Sunwell Plateau, Culling of Stratholme
         */
        (this.id.get() == 603) || (this.id.get() == 615) || (this.id.get() == 616);
        /** Ulduar, The Obsidian Sanctum, The Eye Of Eternity */
    }
    
    private boolean isDungeon() {
    
        return (this.mapType.get() == MapTypes.MAP_INSTANCE.ordinal()) || (this.mapType.get() == MapTypes.MAP_RAID.ordinal());
    }
}
