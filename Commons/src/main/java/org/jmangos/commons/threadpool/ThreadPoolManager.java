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

import java.util.concurrent.ScheduledFuture;

import org.jmangos.commons.service.Service;
import org.jmangos.commons.threadpool.model.PoolStats;
import org.jmangos.commons.threadpool.model.ThreadPoolType;

/**
 * The Interface ThreadPoolManager.
 */
public interface ThreadPoolManager extends Service {
    
    /**
     * Schedule.
     * 
     * @param r
     *            the r
     * @param delay
     *            the delay
     * @return the scheduled future
     */
    ScheduledFuture<?> schedule(Runnable r, long delay);
    
    /**
     * Schedule at fixed rate.
     * 
     * @param r
     *            the r
     * @param delay
     *            the delay
     * @param period
     *            the period
     * @return the scheduled future
     */
    ScheduledFuture<?> scheduleAtFixedRate(Runnable r, long delay, long period);
    
    /**
     * Execute instant.
     * 
     * @param r
     *            the r
     */
    void executeInstant(Runnable r);
    
    /**
     * Purges all thread pools.
     */
    void purge();
    
    /**
     * Fill pool stats.
     * 
     * @param poolType
     *            the pool type
     * @return the pool stats
     */
    PoolStats fillPoolStats(ThreadPoolType poolType);
    
}
