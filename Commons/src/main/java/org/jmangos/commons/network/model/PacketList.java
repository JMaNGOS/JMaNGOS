/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.commons.network.model;

import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class PacketList.
 */
@XmlRootElement(name = "opcodelist")
@XmlAccessorType(XmlAccessType.NONE)
public class PacketList {

    /** The Constant log. */
    private static final Logger log = LoggerFactory.getLogger(PacketList.class);

    /** The data. */
    public TIntObjectHashMap<PacketTemplate> data = new TIntObjectHashMap<PacketTemplate>();

    /** The templates. */
    @XmlElement(name = "packet")
    private List<PacketTemplate> templates;

    /** The direction. */
    @XmlAttribute(name = "direction")
    private ChannelDirection direction;

    /** String representing package of {@link NetworkPacket} location. */
    @XmlAttribute(name = "package")
    private String packageName;

    /** String representing bundle of {@link NetworkPacket} location. */
    @XmlAttribute(name = "provider")
    private String provider;

    /**
     * String representing package of {@link AbstractPacketManager} location<br>
     * Value is optional, if not specified - the value of {@code packageName}
     * will be used.
     */
    @XmlAttribute(name = "hpackage")
    private String hpackageName;

    /**
     * String representing bundle of {@link AbstractPacketManager} location
     * Value is optional, if
     * not specified - the value of {@code provider} will be used.
     */
    @XmlAttribute(name = "hprovider")
    private String hprovider;

    /**
     * After Unmarshal.
     * 
     * @param u
     *        the u
     * @param parent
     *        the parent
     */
    void afterUnmarshal(final Unmarshaller u, final Object parent) {

        if (this.templates == null) {
            log.info("no TemplatesLoaded " + this.direction);
            return;
        }
        for (final PacketTemplate t : this.templates) {
            this.data.put(t.getTemplateId(), t);
        }
        log.info("Packets: " + this.direction + " " + this.templates.size());
        this.templates.clear();
    }

    /**
     * Gets the package name.
     * 
     * @return the package name
     */
    public String getPackageName() {

        return this.packageName;
    }

    /**
     * Gets the provider.
     * 
     * @return the provider
     */
    public String getProvider() {

        return this.provider;
    }

    /**
     * Gets the hpackage name.
     * 
     * @return the hpackageName
     */
    public String getHpackageName() {

        return this.hpackageName;
    }

    /**
     * Gets the hprovider.
     * 
     * @return the hprovider
     */
    public String getHprovider() {

        return this.hprovider;
    }

    /**
     * Gets the real hprovider.
     * 
     * @return hprovider or provider
     */
    public String getRealHprovider() {

        return this.hprovider != null ? this.hprovider : this.provider;
    }

    /**
     * Gets the real hpackage name.
     * 
     * @return hpackageName or packageName
     */
    public String getRealHpackageName() {

        return this.hpackageName != null ? this.hpackageName : this.packageName;
    }

    /**
     * Gets the direction.
     * 
     * @return the direction
     */
    public final ChannelDirection getDirection() {

        return this.direction;
    }

}
