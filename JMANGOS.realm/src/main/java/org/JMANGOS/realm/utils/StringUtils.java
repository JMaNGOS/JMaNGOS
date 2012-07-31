/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.utils;

// TODO: Auto-generated Javadoc
/**
 * The Class StringUtils.
 */
public class StringUtils {
	 
 	/** The Constant HI_BYTE_MASK. */
 	private static final int HI_BYTE_MASK = 0xf0;
	  
  	/** The Constant LOW_BYTE_MASK. */
  	private static final int LOW_BYTE_MASK = 0x0f;

	  /** The Constant HEX_SYMBOLS. */
  	private static final char[] HEX_SYMBOLS = {
	    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
	  };

	  /**
  	 * Checks if is empty.
  	 *
  	 * @param sequence the sequence
  	 * @return true, if is empty
  	 */
  	public static boolean isEmpty(final CharSequence sequence) {
	    return sequence == null || sequence.length() <= 0;
	  }

	  /**
  	 * To hex string.
  	 *
  	 * @param data the data
  	 * @return the string
  	 */
  	public static String toHexString(final byte[] data) {
	    final StringBuffer builder = new StringBuffer(2 * data.length);
	    for (byte item : data) {
	      builder.append(HEX_SYMBOLS[(HI_BYTE_MASK & item) >>> 4]);
	      builder.append(HEX_SYMBOLS[(LOW_BYTE_MASK & item)]);
	    }
	    return builder.toString();
	  }
}
