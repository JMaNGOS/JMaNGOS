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
package org.JMANGOS.common.network.netty.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.JMANGOS.common.network.model.State;


// TODO: Auto-generated Javadoc
/**
 * The Class PacketTemplate.
 */
@XmlRootElement(name = "packet")
@XmlAccessorType(XmlAccessType.FIELD)
public class PacketTemplate  {

  /** The template id. */
  @XmlAttribute(name = "id", required = true)
  private String templateId;

  /** The name. */
  @XmlAttribute(name = "name")
  private String name;

  /** The module. */
  @XmlAttribute(name = "module")
  private String module;

  /** The handler. */
  @XmlAttribute(name = "handler")
  private String handler;

  /** The state. */
  @XmlAttribute(name = "state")
  private State state = State.CONNECTED;


  /**
   * Gets the template id.
   *
   * @return the template id
   */
  public int getTemplateId() {
    return Integer.parseInt(templateId, 16);
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the module.
   *
   * @return the module
   */
  public String getModule() {
    return module;
  }

  /**
   * Gets the handler.
   *
   * @return the handler
   */
  public String getHandler() {
    return handler;
  }

  /**
   * Gets the state.
   *
   * @return the state
   */
  public State getState() {
	return state;
}


}
