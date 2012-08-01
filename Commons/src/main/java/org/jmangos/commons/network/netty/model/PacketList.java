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
package org.jmangos.commons.network.netty.model;

import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;
import org.jmangos.commons.network.netty.model.PacketTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class PacketList.
 */
@XmlRootElement(name = "opcodelist")
@XmlAccessorType(XmlAccessType.NONE)
public class PacketList {

	/** The Constant log. */
	private static final Logger log = Logger.getLogger(PacketList.class);

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
	 * Value is optional, if not specified - the value of {@code provider} will
	 * be used.
	 */
	@XmlAttribute(name = "hprovider")
	private String hprovider;

	/**
	 * After Unmarshal.
	 * 
	 * @param u
	 *            the u
	 * @param parent
	 *            the parent
	 */
	void afterUnmarshal(Unmarshaller u, Object parent) {
		if (templates == null) {
			log.info("no TemplatesLoaded " + direction);
			return;
		}
		for (PacketTemplate t : templates) {
			data.put(t.getTemplateId(), t);
		}
		log.info("Packets: " + direction + " " + templates.size());
		templates.clear();
	}

	/**
	 * Gets the package name.
	 * 
	 * @return the package name
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * Gets the provider.
	 * 
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * Gets the hpackage name.
	 * 
	 * @return the hpackageName
	 */
	public String getHpackageName() {
		return hpackageName;
	}

	/**
	 * Gets the hprovider.
	 * 
	 * @return the hprovider
	 */
	public String getHprovider() {
		return hprovider;
	}

	/**
	 * Gets the real hprovider.
	 * 
	 * @return hprovider or provider
	 */
	public String getRealHprovider() {
		return hprovider != null ? hprovider : provider;
	}

	/**
	 * Gets the real hpackage name.
	 * 
	 * @return hpackageName or packageName
	 */
	public String getRealHpackageName() {
		return hpackageName != null ? hpackageName : packageName;
	}

	/**
	 * Gets the direction.
	 * 
	 * @return the direction
	 */
	public final ChannelDirection getDirection() {
		return direction;
	}

}
