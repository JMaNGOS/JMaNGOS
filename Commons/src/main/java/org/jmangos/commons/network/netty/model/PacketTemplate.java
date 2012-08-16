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
package org.jmangos.commons.network.netty.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.jmangos.commons.network.model.State;

/**
 * The Class PacketTemplate.
 */
@XmlRootElement(name = "packet")
@XmlAccessorType(XmlAccessType.FIELD)
public class PacketTemplate {
    
    /** The template id. */
    @XmlAttribute(name = "id", required = true)
    private String      templateId;
    
    /** The name. */
    @XmlAttribute(name = "name")
    private String      name;
    
    /** The module. */
    @XmlAttribute(name = "module")
    private String      module;
    
    /** The handler. */
    @XmlAttribute(name = "handler")
    private String      handler;
    
    /** The state. */
    @XmlAttribute(name = "state")
    private final State state = State.CONNECTED;
    
    /**
     * Gets the template id.
     * 
     * @return the template id
     */
    public int getTemplateId() {
    
        return Integer.parseInt(this.templateId, 16);
    }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
    
        return this.name;
    }
    
    /**
     * Gets the module.
     * 
     * @return the module
     */
    public String getModule() {
    
        return this.module;
    }
    
    /**
     * Gets the handler.
     * 
     * @return the handler
     */
    public String getHandler() {
    
        return this.handler;
    }
    
    /**
     * Gets the state.
     * 
     * @return the state
     */
    public State getState() {
    
        return this.state;
    }
    
}
