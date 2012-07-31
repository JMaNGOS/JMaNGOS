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

package org.JMANGOS.common.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IUStH
{
	
	/**
	 * Enables coder to manually modify statement or batch. Must execute batch or statement manually. Automatically
	 * recycles connection.
	 *
	 * @param stmt the stmt
	 * @throws SQLException the sQL exception
	 */
	void handleInsertUpdate(PreparedStatement stmt) throws SQLException;
}
