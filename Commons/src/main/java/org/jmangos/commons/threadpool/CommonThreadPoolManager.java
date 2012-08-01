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
package org.jmangos.commons.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.jmangos.commons.threadpool.config.ThreadPoolConfig;
import org.jmangos.commons.threadpool.model.PoolStats;
import org.jmangos.commons.threadpool.model.ThreadPoolType;


// TODO: Auto-generated Javadoc
/**
 * The Class CommonThreadPoolManager.
 */
public class CommonThreadPoolManager implements ThreadPoolManager {

  /** The scheduled pool. */
  private ScheduledThreadPoolExecutor scheduledPool;
  
  /** The instant pool. */
  private ThreadPoolExecutor instantPool;

  /** The Constant MAX_DELAY. */
  private static final long MAX_DELAY = TimeUnit.NANOSECONDS.toMillis(Long.MAX_VALUE
      - System.nanoTime()) / 2;

  /* (non-Javadoc)
   * @see org.wowemu.common.service.Service#start()
   */
  @Override
  public void start() {
    int scheduledPoolSize = ThreadPoolConfig.GENERAL_POOL;
    scheduledPool = new ScheduledThreadPoolExecutor(scheduledPoolSize);
    scheduledPool.prestartAllCoreThreads();

    int instantPoolSize = ThreadPoolConfig.GENERAL_POOL;
    instantPool = new ThreadPoolExecutor(instantPoolSize, instantPoolSize, 0, TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(100000));
    instantPool.prestartAllCoreThreads();
  }

  /* (non-Javadoc)
   * @see org.wowemu.common.service.Service#stop()
   */
  @Override
  public void stop() {
	  instantPool.shutdownNow();
	  scheduledPool.shutdownNow();
	 /* try {
		scheduledPool.awaitTermination(MAX_DELAY, TimeUnit.NANOSECONDS);
		instantPool.awaitTermination(MAX_DELAY, TimeUnit.NANOSECONDS);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}*/
  }

  /**
   * Validate.
   *
   * @param delay the delay
   * @return the long
   */
  private final long validate(long delay) {
    return Math.max(0, Math.min(MAX_DELAY, delay));
  }

  /* (non-Javadoc)
   * @see org.wowemu.common.threadpool.ThreadPoolManager#schedule(java.lang.Runnable, long)
   */
  @Override
  public final ScheduledFuture<?> schedule(Runnable r, long delay) {
    return scheduledPool.schedule(new TaskExecutionWrapper(r), validate(delay),
        TimeUnit.MILLISECONDS);
  }

  /* (non-Javadoc)
   * @see org.wowemu.common.threadpool.ThreadPoolManager#scheduleAtFixedRate(java.lang.Runnable, long, long)
   */
  @Override
  public final ScheduledFuture<?> scheduleAtFixedRate(Runnable r, long delay, long period) {
    return scheduledPool.scheduleAtFixedRate(new TaskExecutionWrapper(r), validate(delay),
        validate(period), TimeUnit.MILLISECONDS);
  }

  /* (non-Javadoc)
   * @see org.wowemu.common.threadpool.ThreadPoolManager#executeInstant(java.lang.Runnable)
   */
  @Override
  public final void executeInstant(Runnable r) {
    instantPool.execute(new TaskExecutionWrapper(r));
  }

  /* (non-Javadoc)
   * @see org.wowemu.common.threadpool.ThreadPoolManager#purge()
   */
  @Override
  public void purge() {
    scheduledPool.purge();
    instantPool.purge();
  }

  /* (non-Javadoc)
   * @see org.wowemu.common.threadpool.ThreadPoolManager#fillPoolStats(org.wowemu.common.threadpool.model.ThreadPoolType)
   */
  @Override
  public PoolStats fillPoolStats(ThreadPoolType poolType) {
    ThreadPoolExecutor executor = null;
    switch (poolType) {
      case INSTANT:
        executor = instantPool;
        break;
      case SCHEDULED:
      default:
        executor = scheduledPool;
        break;
    }
    PoolStats stats = new PoolStats(poolType);
    stats.setActiveCount(executor.getActiveCount());
    stats.setCompletedTaskCount(executor.getCompletedTaskCount());
    stats.setCorePoolSize(executor.getCorePoolSize());
    stats.setLargestPoolSize(executor.getLargestPoolSize());
    stats.setMaximumPoolSize(executor.getMaximumPoolSize());
    stats.setPoolSize(executor.getPoolSize());
    stats.setQueueSize(executor.getQueue().size());
    stats.setTaskCount(executor.getTaskCount());
    return stats;
  }

}
