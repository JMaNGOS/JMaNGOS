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
package org.JMANGOS.common.database;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface ReadStH
{
	
	/**
	 * Allows coder to read data after query execution. Automatically recycles connection and closes ResultSet.
	 *
	 * @param rset the rset
	 * @throws SQLException the sQL exception
	 */
	public void handleRead(ResultSet rset) throws SQLException;
}
