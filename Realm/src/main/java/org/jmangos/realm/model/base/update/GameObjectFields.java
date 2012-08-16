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
package org.jmangos.realm.model.base.update;

// TODO: Auto-generated Javadoc
/**
 * The Class GameObjectFields.
 */
public class GameObjectFields extends ObjectFields {
    
    /** The OBJEC t_ fiel d_ create d_ by. */
    public static int OBJECT_FIELD_CREATED_BY                   = OBJECT_END + 0x0000; // Size: 2, Type: LONG, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ displayid. */
    public static int GAMEOBJECT_DISPLAYID                      = OBJECT_END + 0x0002; // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ flags. */
    public static int GAMEOBJECT_FLAGS                          = OBJECT_END + 0x0003; // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ parentrotation. */
    public static int GAMEOBJECT_PARENTROTATION                 = OBJECT_END + 0x0004; // Size: 4, Type: FLOAT, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ dynamic. */
    public static int GAMEOBJECT_DYNAMIC                        = OBJECT_END + 0x0008; // Size: 1, Type: TWO_SHORT, Flags: DYNAMIC
    
    /** The GAMEOBJEC t_ faction. */
    public static int GAMEOBJECT_FACTION                        = OBJECT_END + 0x0009; // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ level. */
    public static int GAMEOBJECT_LEVEL                          = OBJECT_END + 0x000A; // Size: 1, Type: INT, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ byte s_1. */
    public static int GAMEOBJECT_BYTES_1                        = OBJECT_END + 0x000B; // Size: 1, Type: BYTES, Flags: PUBLIC
    
    /** The GAMEOBJEC t_ end. */
    public static int GAMEOBJECT_END                            = OBJECT_END + 0x000C;
}
