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
/*
 * Copyright (C) 2011 WoWEmu
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */
package org.JMANGOS.realm.utils;

import org.apache.log4j.Logger;
import org.JMANGOS.common.database.DatabaseFactory;

import com.google.inject.Inject;

// TODO: Auto-generated Javadoc
/**
 * The Class ShutdownHook.
 */
public class ShutdownHook extends Thread
{
	
	/** The DF. */
	@Inject
	private DatabaseFactory DF;
	
	/** Logger for this class. */
	private static final Logger	log			= Logger.getLogger(ShutdownHook.class);

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		try
		{
			log.info("Shutdown DatabaseFactory");
			DF.stop();
		}
		catch (Throwable t)
		{
			log.error("Can't shutdown DatabaseFactory", t);
		}

	}
}
