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
package org.jmangos.commons.service;

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
