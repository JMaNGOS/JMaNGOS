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
package org.JMANGOS.common.threadpool;

import java.util.concurrent.ScheduledFuture;

import org.JMANGOS.common.service.Service;
import org.JMANGOS.common.threadpool.model.PoolStats;
import org.JMANGOS.common.threadpool.model.ThreadPoolType;

// TODO: Auto-generated Javadoc
/**
 * The Interface ThreadPoolManager.
 */
public interface ThreadPoolManager extends Service {

  /**
   * Schedule.
   *
   * @param r the r
   * @param delay the delay
   * @return the scheduled future
   */
  ScheduledFuture<?> schedule(Runnable r, long delay);

  /**
   * Schedule at fixed rate.
   *
   * @param r the r
   * @param delay the delay
   * @param period the period
   * @return the scheduled future
   */
  ScheduledFuture<?> scheduleAtFixedRate(Runnable r, long delay, long period);

  /**
   * Execute instant.
   *
   * @param r the r
   */
  void executeInstant(Runnable r);

  /**
   * Purges all thread pools.
   */
  void purge();

  /**
   * Fill pool stats.
   *
   * @param poolType the pool type
   * @return the pool stats
   */
  PoolStats fillPoolStats(ThreadPoolType poolType);

}
