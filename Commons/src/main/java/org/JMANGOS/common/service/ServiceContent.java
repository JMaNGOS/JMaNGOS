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
package org.JMANGOS.common.service;

import com.google.inject.Injector;


// TODO: Auto-generated Javadoc
/**
 * The Class ServiceContent.
 */
public final class ServiceContent {

		  /** The injector. */
  		private static Injector injector;

		  /**
  		 * Sets the injector.
  		 *
  		 * @param injector the injector to set
  		 * @return instance
  		 */
		  public static final void setInjector(Injector injector) {
		    ServiceContent.injector = injector;
		  }

		  /**
  		 * Gets the injector.
  		 *
  		 * @return the injector
  		 */
		  public static final Injector getInjector() {
		    return injector;
		  }

		}
