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
package org.JMANGOS.common.service;

// TODO: Auto-generated Javadoc
/**
 * The Interface Service.
 */
public interface Service {
	  /**
	   * Starts the service. Method returns only after service completely started.
	   */
	  void start();

	  /**
	   * Stops the service. Method returns only after service completely stopped.
	   */
	  void stop();
	}
