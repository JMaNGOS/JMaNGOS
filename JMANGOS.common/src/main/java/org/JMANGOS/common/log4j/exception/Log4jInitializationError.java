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
/**
 * 
 */
package org.JMANGOS.common.log4j.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class Log4jInitializationError.
 *
 * @author admin
 */
public class Log4jInitializationError extends Error {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1728238531809040537L;

	/**
	 * Creates new Error.
	 */
	public Log4jInitializationError() {
	}

	/**
	 * Creates new error.
	 *
	 * @param message error description
	 */
	public Log4jInitializationError(String message) {
		super(message);
	}

	/**
	 * Creates new error.
	 *
	 * @param message error description
	 * @param cause reason of this error
	 */
	public Log4jInitializationError(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates new error.
	 *
	 * @param cause reason of this error
	 */
	public Log4jInitializationError(Throwable cause) {
		super(cause);
	}
}
