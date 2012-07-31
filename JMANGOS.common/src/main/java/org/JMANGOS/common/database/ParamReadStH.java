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

public interface ParamReadStH extends ReadStH
{
	
	/**
	 * Enables coder to manually modify statement parameters.
	 *
	 * @param stmt the new params
	 * @throws SQLException the sQL exception
	 */
	public void setParams(PreparedStatement stmt) throws SQLException;
}
