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
package org.JMANGOS.common.model;

/**
 * The Class ManagedObject.
 *
 */
public class ManagedObject {

  /** The object id. */
  private final int objectId;

  /**
   * Instantiates a new managed object.
   *
   * @param objectId the object id
   */
  public ManagedObject(int objectId) {
    this.objectId = objectId;
  }

  /**
   * Gets the object id.
   *
   * @return objectId
   */
  public final int getObjectId() {
    return objectId;
  }
  
  /**
   * Sets the object id.
   *
   * @param objectId the object id
   * @return the int
   * @set objectId
   */
  public final int setObjectId(int objectId) {
    return objectId;
  }
}
