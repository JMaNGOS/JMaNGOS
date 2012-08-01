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
package org.jmangos.commons.task;

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
