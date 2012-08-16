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
package org.jmangos.commons.threadpool.model;

/**
 * The Class PoolStats.
 * 
 */
public class PoolStats {
    
    /** The pool type. */
    private final ThreadPoolType poolType;
    
    /** The active count. */
    private int                  activeCount;
    
    /** The core pool size. */
    private int                  corePoolSize;
    
    /** The pool size. */
    private int                  poolSize;
    
    /** The largest pool size. */
    private int                  largestPoolSize;
    
    /** The maximum pool size. */
    private int                  maximumPoolSize;
    
    /** The completed task count. */
    private long                 completedTaskCount;
    
    /** The queue size. */
    private int                  queueSize;
    
    /** The task count. */
    private long                 taskCount;
    
    /**
     * Instantiates a new pool stats.
     * 
     * @param poolType
     *            the pool type
     */
    public PoolStats(final ThreadPoolType poolType) {
    
        this.poolType = poolType;
    }
    
    /**
     * Gets the pool type.
     * 
     * @return the pool type
     */
    public ThreadPoolType getPoolType() {
    
        return this.poolType;
    }
    
    /**
     * Gets the active count.
     * 
     * @return the activeCount
     */
    public int getActiveCount() {
    
        return this.activeCount;
    }
    
    /**
     * Sets the active count.
     * 
     * @param activeCount
     *            the activeCount to set
     */
    public void setActiveCount(final int activeCount) {
    
        this.activeCount = activeCount;
    }
    
    /**
     * Gets the core pool size.
     * 
     * @return the corePoolSize
     */
    public int getCorePoolSize() {
    
        return this.corePoolSize;
    }
    
    /**
     * Sets the core pool size.
     * 
     * @param corePoolSize
     *            the corePoolSize to set
     */
    public void setCorePoolSize(final int corePoolSize) {
    
        this.corePoolSize = corePoolSize;
    }
    
    /**
     * Gets the pool size.
     * 
     * @return the poolSize
     */
    public int getPoolSize() {
    
        return this.poolSize;
    }
    
    /**
     * Sets the pool size.
     * 
     * @param poolSize
     *            the poolSize to set
     */
    public void setPoolSize(final int poolSize) {
    
        this.poolSize = poolSize;
    }
    
    /**
     * Gets the largest pool size.
     * 
     * @return the largestPoolSize
     */
    public int getLargestPoolSize() {
    
        return this.largestPoolSize;
    }
    
    /**
     * Sets the largest pool size.
     * 
     * @param largestPoolSize
     *            the largestPoolSize to set
     */
    public void setLargestPoolSize(final int largestPoolSize) {
    
        this.largestPoolSize = largestPoolSize;
    }
    
    /**
     * Gets the maximum pool size.
     * 
     * @return the maximumPoolSize
     */
    public int getMaximumPoolSize() {
    
        return this.maximumPoolSize;
    }
    
    /**
     * Sets the maximum pool size.
     * 
     * @param maximumPoolSize
     *            the maximumPoolSize to set
     */
    public void setMaximumPoolSize(final int maximumPoolSize) {
    
        this.maximumPoolSize = maximumPoolSize;
    }
    
    /**
     * Gets the completed task count.
     * 
     * @return the completedTaskCount
     */
    public long getCompletedTaskCount() {
    
        return this.completedTaskCount;
    }
    
    /**
     * Sets the completed task count.
     * 
     * @param completedTaskCount
     *            the completedTaskCount to set
     */
    public void setCompletedTaskCount(final long completedTaskCount) {
    
        this.completedTaskCount = completedTaskCount;
    }
    
    /**
     * Gets the queue size.
     * 
     * @return the queueSize
     */
    public int getQueueSize() {
    
        return this.queueSize;
    }
    
    /**
     * Sets the queue size.
     * 
     * @param queueSize
     *            the queueSize to set
     */
    public void setQueueSize(final int queueSize) {
    
        this.queueSize = queueSize;
    }
    
    /**
     * Gets the task count.
     * 
     * @return the taskCount
     */
    public long getTaskCount() {
    
        return this.taskCount;
    }
    
    /**
     * Sets the task count.
     * 
     * @param taskCount
     *            the taskCount to set
     */
    public void setTaskCount(final long taskCount) {
    
        this.taskCount = taskCount;
    }
    
}
