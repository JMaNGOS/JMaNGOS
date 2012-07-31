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
package org.JMANGOS.realm.model.base.update;

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
