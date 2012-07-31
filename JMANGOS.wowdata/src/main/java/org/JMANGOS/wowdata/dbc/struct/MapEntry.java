/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.wowdata.dbc.struct;

import javax.xml.bind.annotation.XmlAttribute;

import org.JMANGOS.wowdata.dbc.dataholder.DBCStruct;

enum MapTypes                                               // Lua_IsInInstance
{
    MAP_COMMON        ,                               // none
    MAP_INSTANCE      ,                               // party
    MAP_RAID          ,                               // raid
    MAP_BATTLEGROUND  ,                               // pvp
    MAP_ARENA         ;                               // arena
};
public class MapEntry extends DBCStruct<MapEntry> {
	@XmlAttribute(name = "id", required=true)
	public final Unsigned32 id = new Unsigned32();         	     // 0
	@XmlAttribute(name = "internalname")
	public final InternalString internalname = new InternalString();        	     // 1 unused
	@XmlAttribute(name = "mapType", required=true)
	public final Unsigned32 mapType = new Unsigned32();      	     // 2
	public final Unsigned32 mapFlags = new Unsigned32();      	     // 3 some kind of flags (0x100 - CAN_CHANGE_PLAYER_DIFFICULTY)
	public final Unsigned32 isPvP = new Unsigned32();         	     // 4 0 or 1 for battlegrounds (not arenas)
	@XmlAttribute(name = "name", required=true)
	public final MultiInternalString name   = new MultiInternalString(); 	  		 // 5-20
	@XmlAttribute(name = "linkedZone", required=true)
    public final Unsigned32 linkedZone = new Unsigned32();        // 22 common zone for instance and continent map
	@XmlAttribute(name = "hordeIntro")
    public final MultiInternalString hordeIntro   = new MultiInternalString();     // 23-38 text for PvP Zones
	@XmlAttribute(name = "allianceIntro")
    public final MultiInternalString allianceIntro   = new MultiInternalString();  // 40-55 text for PvP Zones
	@XmlAttribute(name = "multimapId", required=true)
    public final Unsigned32 multimapId = new Unsigned32();        // 57 index in  LoadingScreens.dbc
    public final Float32 BattlefieldMapIconScale = new Float32();  // 58 BattlefieldMapIconScale
    @XmlAttribute(name = "ghostEntranceMap", required=true)
    public final Signed32 ghostEntranceMap = new Signed32();     // 59 map_id of entrance map in ghost mode (continent always and in most cases = normal entrance)
    @XmlAttribute(name = "ghostEntranceX", required=true)
    public final Float32 ghostEntranceX = new Float32();         // 60 entrance x coordinate in ghost mode  (in most cases = normal entrance)
    @XmlAttribute(name = "ghostEntranceY", required=true)
    public final Float32 ghostEntranceY = new Float32();         // 61 entrance y coordinate in ghost mode  (in most cases = normal entrance)
    @XmlAttribute(name = "timeOfDayOverride")
    public final Signed32 timeOfDayOverride = new Signed32();  // 62 time of day override
    @XmlAttribute(name = "addon", required=true)
    public final Unsigned32 addon = new Unsigned32();              // 63 expansion
    @XmlAttribute(name = "unktime")
    public final Unsigned32 unktime = new Unsigned32();            // 63 expansion
    @XmlAttribute(name = "maxPlayers")
    public final Unsigned32 maxPlayers = new Unsigned32();         // 65 max players

   public  boolean IsMountAllowed() 
    {
		return !IsDungeon() ||
            id.get()==209 || id.get()==269 || id.get()==309 ||       /** TanarisInstance, CavernsOfTime, Zul'gurub */
            id.get()==509 || id.get()==534 || id.get()==560 ||       /**  AhnQiraj, HyjalPast, HillsbradPast*/
            id.get()==568 || id.get()==580 || id.get()==595 ||       /**  ZulAman, Sunwell Plateau, Culling of Stratholme*/
            id.get()==603 || id.get()==615 || id.get()==616;         /** Ulduar, The Obsidian Sanctum, The Eye Of Eternity*/
    }
   private boolean IsDungeon() {
	   return mapType.get() == MapTypes.MAP_INSTANCE.ordinal() || mapType.get() == MapTypes.MAP_RAID.ordinal();
   }
}
