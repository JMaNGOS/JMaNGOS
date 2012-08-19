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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class TaskExecutionWrapper.
 */
public class TaskExecutionWrapper implements Runnable {
    
    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(TaskExecutionWrapper.class);
    
    /** The runnable. */
    private final Runnable      runnable;
    
    /**
     * Instantiates a new task execution wrapper.
     * 
     * @param runnable
     *            the runnable
     */
    public TaskExecutionWrapper(final Runnable runnable) {
    
        this.runnable = runnable;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
    
        try {
            this.runnable.run();
        } catch (final Exception e) {
            log.error("Exception during execution of the task", e);
        }
    }
}
