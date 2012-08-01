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
package org.jmangos.realm.utils;

import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class Utils.
 */
public class Utils {
	
	/**
	 * Time to bit fields.
	 *
	 * @param millisec the millisec
	 * @return the int
	 */
	public static final int TimeToBitFields(Long millisec) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millisec);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		int dow = calendar.get(Calendar.DAY_OF_WEEK);
		int dom = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		return ((year - 2000) << 24) | (month << 20) | ((dom - 1) << 14)
				| ((dow - 1) << 11) | (hour << 6) | min;
	}
}
