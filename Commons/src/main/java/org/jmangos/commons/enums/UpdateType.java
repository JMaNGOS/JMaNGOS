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
package org.jmangos.commons.enums;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.09. Time: 15:17 To
 * change this template use
 * File | Settings | File Templates.
 */
public enum UpdateType implements UpdateField {
    VALUES(0x00),
    MOVEMENT(0x01),
    CREATE_OBJECT(0x02),
    CREATE_OBJECT2(0x03),
    OUT_OF_RANGE_OBJECTS(0x04),
    NEAR_OBJECTS(0x05);

    private int value;

    UpdateType(final int value) {

        this.value = value;
    }

    @Override
    public UpdateFieldType getType() {

        return null; // To change body of implemented methods use File |
                     // Settings | File Templates.
    }

    @Override
    public int getSize() {

        return 0; // To change body of implemented methods use File | Settings |
                  // File Templates.
    }

    @Override
    public int getValue() {

        return this.value;
    }

    public static UpdateField get(final int value) {

        for (final UpdateField pf : values()) {
            if (pf.getValue() == value) {
                return pf;
            }
        }
        // Not found :O
        return null;
    }
}
