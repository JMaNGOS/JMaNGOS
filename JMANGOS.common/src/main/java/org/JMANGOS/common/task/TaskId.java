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

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskId.
 *
 */
public interface TaskId {

  /**
   * Name.
   *
   * @return the string
   */
  String name();

  /**
   * Gets the priority.
   *
   * @return priority of this task
   */
  TaskPriority getPriority();
}
