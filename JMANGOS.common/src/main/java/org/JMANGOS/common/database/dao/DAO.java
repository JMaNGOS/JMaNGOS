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

package org.JMANGOS.common.database.dao;

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
