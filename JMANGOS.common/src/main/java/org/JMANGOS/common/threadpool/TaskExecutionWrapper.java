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

import org.apache.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Class TaskExecutionWrapper.
 */
public class TaskExecutionWrapper implements Runnable {

  /** The Constant log. */
  private static final Logger log = Logger.getLogger(TaskExecutionWrapper.class);

  /** The runnable. */
  private Runnable runnable;

  /**
   * Instantiates a new task execution wrapper.
   *
   * @param runnable the runnable
   */
  public TaskExecutionWrapper(Runnable runnable) {
    this.runnable = runnable;
  }

  /* (non-Javadoc)
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {
    try {
      runnable.run();
    } catch (Exception e) {
      log.error("Exception during execution of the task", e);
    }
  }
}
