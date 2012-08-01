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
package org.JMANGOS.common.task;

import java.util.concurrent.Future;

import javolution.util.FastMap;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskManager.
 *
 */
public class TaskManager {

  /** all tasks. */
  private FastMap<TaskId, Future<?>> tasks = new FastMap<TaskId, Future<?>>().shared();

  /**
   * Gets the task.
   *
   * @param taskId the task id
   * @return the task
   */
  public Future<?> getTask(TaskId taskId) {
    return tasks.get(taskId);
  }

  /**
   * Checks for task.
   *
   * @param taskId the task id
   * @return true, if successful
   */
  public boolean hasTask(TaskId taskId) {
    return tasks.containsKey(taskId);
  }

  /**
   * Cancel task.
   *
   * @param taskId the task id
   */
  public void cancelTask(TaskId taskId) {
    Future<?> task = tasks.remove(taskId);
    if (task != null) {
      task.cancel(false);
    }
  }

  /**
   * If task already exist - it will be canceled.
   *
   * @param taskId the task id
   * @param task the task
   */
  public void addTask(TaskId taskId, Future<?> task) {
    cancelTask(taskId);
    tasks.put(taskId, task);
  }

  /**
   * If task already exist - it will not be replaced.
   *
   * @param taskId the task id
   * @param task the task
   */
  public void addNewTask(TaskId taskId, Future<?> task) {
    tasks.putIfAbsent(taskId, task);
  }

  /**
   * Cancel all tasks and remove from map.
   */
  public void cancelAllTasks() {
    for (TaskId taskId : tasks.keySet()) {
      Future<?> task = tasks.remove(taskId);
      if (task != null) {
        task.cancel(true);
      }
    }
  }

  /**
   * Cancel all tasks and remove from map based on task's priority.
   *
   * @param priority the priority
   */
  public void cancelAllTasks(TaskPriority priority) {
    for (TaskId taskId : tasks.keySet()) {
      if (taskId.getPriority().ordinal() >= priority.ordinal()) {
        Future<?> task = tasks.remove(taskId);
        if (task != null) {
          task.cancel(true);
        }
      }
    }
  }
}
