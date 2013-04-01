/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.model.base.update;

import org.jmangos.commons.network.model.UpdateField;

/**
 * Created with IntelliJ IDEA. User: paalgyula E-Mail: paalgyula@gmail.com Date:
 * 2012.08.14. Time:
 * 11:36
 */
public class UpdateFieldUtils {

    public static UpdateField getField(final int code) {

        if (code < ObjectFields.OBJECT_END) {
            return ObjectFields.get(code);
        } else if (code < UnitField.UNIT_END) {
            return UnitField.get(code);
        } else if (code < PlayerFields.PLAYER_END) {
            return PlayerFields.get(code);
        } else {
            return null;
        }
    }
}
