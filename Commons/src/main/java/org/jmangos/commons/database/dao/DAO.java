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
package org.jmangos.commons.database.dao;

public interface DAO
{
	/**
	 * Unique identifier for DAO class, all subclasses must have same identifiers. Must return {@link Class#getName()}
	 * of abstract class
	 * 
	 * @return identifier of DAO class
	 */
	public String getClassName();
}
