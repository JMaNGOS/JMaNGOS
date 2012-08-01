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
package org.jmangos.commons.database;

import java.sql.CallableStatement;
import java.sql.SQLException;


/**
 * The Interface CallReadStH.
 *
 */
public interface CallReadStH extends ReadStH
{
	
	/**
	 * Sets the params.
	 *
	 * @param stmt the new params
	 * @throws SQLException the sQL exception
	 */
	public void setParams(CallableStatement stmt) throws SQLException;
}
