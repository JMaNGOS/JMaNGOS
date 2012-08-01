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
