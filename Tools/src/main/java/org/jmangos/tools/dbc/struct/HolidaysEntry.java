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

public class HolidaysEntry extends DBCStruct<HolidaysEntry> {

    @XmlAttribute(name = "id", required = true)
    public final Unsigned32 id = new Unsigned32();
    @XmlAttribute(name = "duration")
    public final Unsigned32[] duration = array(new Unsigned32[10]); // 3-10,
                                                                    // empty
                                                                    // fields
    @XmlAttribute(name = "time")
    public final Unsigned32[] time = array(new Unsigned32[38]); // 3-10, empty
                                                                // fields
    @XmlAttribute(name = "NameId")
    public final Unsigned32 holidayNameId = new Unsigned32();         // 49, id for
                                                              // HolidayNames.dbc
    @XmlAttribute(name = "DescriptionId")
    public final Unsigned32 holidayDescriptionId = new Unsigned32();
    @XmlAttribute(name = "Skin")
    public final InternalString Skin = new InternalString();
    @XmlAttribute(name = "priority")
    public final Signed32 priority = new Signed32();           // 51
    @XmlAttribute(name = "calendarFilterType")
    public final Signed32 calendarFilterType = new Signed32();           // 51
    @XmlAttribute(name = "flags")
    public final Signed32 flags = new Signed32();           // 51

};
