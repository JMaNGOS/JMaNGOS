/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.commons.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.jmangos.commons.threadpool.config.ThreadPoolConfig;
import org.jmangos.commons.threadpool.model.PoolStats;
import org.jmangos.commons.threadpool.model.ThreadPoolType;
import org.springframework.stereotype.Component;

/**
 * The Class CommonThreadPoolManager.
 */
@Component
public class CommonThreadPoolManager implements ThreadPoolManager {
    
    /** The scheduled pool. */
    private ScheduledThreadPoolExecutor scheduledPool;
    
    /** The instant pool. */
    private ThreadPoolExecutor          instantPool;
    
    /** The Constant MAX_DELAY. */
    private static final long           MAX_DELAY = TimeUnit.NANOSECONDS.toMillis(Long.MAX_VALUE - System.nanoTime()) / 2;
    
    /**
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {
    
        final int scheduledPoolSize = ThreadPoolConfig.GENERAL_POOL;
        this.scheduledPool = new ScheduledThreadPoolExecutor(scheduledPoolSize);
        this.scheduledPool.prestartAllCoreThreads();
        
        final int instantPoolSize = ThreadPoolConfig.GENERAL_POOL;
        this.instantPool = new ThreadPoolExecutor(instantPoolSize, instantPoolSize, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100000));
        this.instantPool.prestartAllCoreThreads();
    }
    
    /**
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        this.instantPool.shutdownNow();
        this.scheduledPool.shutdownNow();
        /*
         * try { scheduledPool.awaitTermination(MAX_DELAY, TimeUnit.NANOSECONDS);
         * instantPool.awaitTermination(MAX_DELAY, TimeUnit.NANOSECONDS); } catch
         * (InterruptedException e) { e.printStackTrace(); }
         */
    }
    
    /**
     * Validate.
     * 
     * @param delay
     *            the delay
     * @return the long
     */
    private final long validate(final long delay) {
    
        return Math.max(0, Math.min(MAX_DELAY, delay));
    }
    
    /**
     * @see org.jmangos.commons.threadpool.ThreadPoolManager#schedule(java.lang.Runnable, long)
     */
    @Override
    public final ScheduledFuture<?> schedule(final Runnable r, final long delay) {
    
        return this.scheduledPool.schedule(new TaskExecutionWrapper(r), validate(delay), TimeUnit.MILLISECONDS);
    }
    
    /**
     * @see org.jmangos.commons.threadpool.ThreadPoolManager#scheduleAtFixedRate(java.lang.Runnable,
     *      long, long)
     */
    @Override
    public final ScheduledFuture<?> scheduleAtFixedRate(final Runnable r, final long delay, final long period) {
    
        return this.scheduledPool.scheduleAtFixedRate(new TaskExecutionWrapper(r), validate(delay), validate(period), TimeUnit.MILLISECONDS);
    }
    
    /**
     * @see org.jmangos.commons.threadpool.ThreadPoolManager#executeInstant(java.lang.Runnable)
     */
    @Override
    public final void executeInstant(final Runnable r) {
    
        this.instantPool.execute(new TaskExecutionWrapper(r));
    }
    
    /**
     * @see org.jmangos.commons.threadpool.ThreadPoolManager#purge()
     */
    @Override
    public void purge() {
    
        this.scheduledPool.purge();
        this.instantPool.purge();
    }
    
    /**
     * @see org.jmangos.commons.threadpool.ThreadPoolManager#fillPoolStats(org.jmangos.commons.threadpool.model.ThreadPoolType)
     */
    @Override
    public PoolStats fillPoolStats(final ThreadPoolType poolType) {
    
        ThreadPoolExecutor executor = null;
        switch (poolType) {
            case INSTANT:
                executor = this.instantPool;
                break;
            case SCHEDULED:
            default:
                executor = this.scheduledPool;
                break;
        }
        final PoolStats stats = new PoolStats(poolType);
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
