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
package org.JMANGOS.common.threadpool.model;

// TODO: Auto-generated Javadoc
/**
 * The Class PoolStats.
 *
 */
public class PoolStats {

  /** The pool type. */
  private ThreadPoolType poolType;

  /** The active count. */
  private int activeCount;
  
  /** The core pool size. */
  private int corePoolSize;
  
  /** The pool size. */
  private int poolSize;
  
  /** The largest pool size. */
  private int largestPoolSize;
  
  /** The maximum pool size. */
  private int maximumPoolSize;
  
  /** The completed task count. */
  private long completedTaskCount;
  
  /** The queue size. */
  private int queueSize;
  
  /** The task count. */
  private long taskCount;

  /**
   * Instantiates a new pool stats.
   *
   * @param poolType the pool type
   */
  public PoolStats(ThreadPoolType poolType) {
    this.poolType = poolType;
  }

  /**
   * Gets the pool type.
   *
   * @return the pool type
   */
  public ThreadPoolType getPoolType() {
    return poolType;
  }

  /**
   * Gets the active count.
   *
   * @return the activeCount
   */
  public int getActiveCount() {
    return activeCount;
  }

  /**
   * Sets the active count.
   *
   * @param activeCount the activeCount to set
   */
  public void setActiveCount(int activeCount) {
    this.activeCount = activeCount;
  }

  /**
   * Gets the core pool size.
   *
   * @return the corePoolSize
   */
  public int getCorePoolSize() {
    return corePoolSize;
  }

  /**
   * Sets the core pool size.
   *
   * @param corePoolSize the corePoolSize to set
   */
  public void setCorePoolSize(int corePoolSize) {
    this.corePoolSize = corePoolSize;
  }

  /**
   * Gets the pool size.
   *
   * @return the poolSize
   */
  public int getPoolSize() {
    return poolSize;
  }

  /**
   * Sets the pool size.
   *
   * @param poolSize the poolSize to set
   */
  public void setPoolSize(int poolSize) {
    this.poolSize = poolSize;
  }

  /**
   * Gets the largest pool size.
   *
   * @return the largestPoolSize
   */
  public int getLargestPoolSize() {
    return largestPoolSize;
  }

  /**
   * Sets the largest pool size.
   *
   * @param largestPoolSize the largestPoolSize to set
   */
  public void setLargestPoolSize(int largestPoolSize) {
    this.largestPoolSize = largestPoolSize;
  }

  /**
   * Gets the maximum pool size.
   *
   * @return the maximumPoolSize
   */
  public int getMaximumPoolSize() {
    return maximumPoolSize;
  }

  /**
   * Sets the maximum pool size.
   *
   * @param maximumPoolSize the maximumPoolSize to set
   */
  public void setMaximumPoolSize(int maximumPoolSize) {
    this.maximumPoolSize = maximumPoolSize;
  }

  /**
   * Gets the completed task count.
   *
   * @return the completedTaskCount
   */
  public long getCompletedTaskCount() {
    return completedTaskCount;
  }

  /**
   * Sets the completed task count.
   *
   * @param completedTaskCount the completedTaskCount to set
   */
  public void setCompletedTaskCount(long completedTaskCount) {
    this.completedTaskCount = completedTaskCount;
  }

  /**
   * Gets the queue size.
   *
   * @return the queueSize
   */
  public int getQueueSize() {
    return queueSize;
  }

  /**
   * Sets the queue size.
   *
   * @param queueSize the queueSize to set
   */
  public void setQueueSize(int queueSize) {
    this.queueSize = queueSize;
  }

  /**
   * Gets the task count.
   *
   * @return the taskCount
   */
  public long getTaskCount() {
    return taskCount;
  }

  /**
   * Sets the task count.
   *
   * @param taskCount the taskCount to set
   */
  public void setTaskCount(long taskCount) {
    this.taskCount = taskCount;
  }

}
