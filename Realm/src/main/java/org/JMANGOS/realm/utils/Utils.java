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
package org.JMANGOS.realm.utils;

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
