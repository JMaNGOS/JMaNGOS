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

public class AreaTriggerEntry extends DBCStruct<AreaTriggerEntry> {
	@XmlAttribute(name="id", required=true)
    public final Unsigned32 id= new Unsigned32(); 
	@XmlAttribute(name="mapid", required=true)
    public final Unsigned32 mapid= new Unsigned32(); 
	@XmlAttribute(name="x", required=true)
    public final Float32 x= new Float32(); 
	@XmlAttribute(name="y", required=true)
    public final Float32 y= new Float32(); 
	@XmlAttribute(name="z", required=true)
    public final Float32 z= new Float32(); 
	@XmlAttribute(name="radius", required=true)
    public final Float32 radius= new Float32(); 
	@XmlAttribute(name="box_x", required=true)
    public final Float32 box_x= new Float32(); 
	@XmlAttribute(name="box_y", required=true)
    public final Float32 box_y= new Float32(); 
	@XmlAttribute(name="box_z", required=true)
    public final Float32 box_z= new Float32(); 
	@XmlAttribute(name="box_orientation", required=true)
    public final Float32 box_orientation= new Float32(); 
}
