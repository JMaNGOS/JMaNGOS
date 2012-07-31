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
package org.JMANGOS.common.dataholder;

import org.JMANGOS.common.service.Service;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataLoadService.
 *
 * @param <T> the generic type
 */
public interface DataLoadService<T> extends Service{

  /**
   * Initial loading of data (on startup).
   *
   * @return the t
   */
  public T load();

  /**
   * Reloading of data (after <method>load()</method> was executed).
   *
   * @return the t
   */
  public T reload();

  /**
   * Save of modified data.
   */
  public void save();

  /**
   * Retrieves already loaded data or null.
   *
   * @return the t
   */
  public T get();
}
