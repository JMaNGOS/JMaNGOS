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
/*
 * Copyright (C) 2011 WoWEmu
 * 
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */
package org.jmangos.commons.model;

import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * The Class BanIp.
 */
@Entity
@Table(name="ip_banned")
public class BanIp {

	/** Returns ip mask. */
    @Id
    @IndexColumn(name="ip")
    @Column(name="ip", length = 18, unique = true, nullable = false)
	private String ip;

	/** Returns expiration time. */
    @Column(name="banned_time", nullable = true)
	private Timestamp timeEnd = null;

    public BanIp() {
    }

    public BanIp(String ip, Timestamp timeEnd) {
        this.ip = ip;
        this.timeEnd = timeEnd;
    }

    /**
	 * Checks if ban is still active.
	 * 
	 * @return true if ban is still active
	 */
    public boolean isActive() {
		return timeEnd.before(Calendar.getInstance().getTime());
	}

	/**
	 * Returns ip.
	 * 
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Sets ip mask.
	 * 
	 * @param ip
	 *            the new ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Returns expiration time of ban.
	 * 
	 * @return expiration time of ban
	 */
	public Timestamp getTimeEnd() {
		return timeEnd;
	}

	/**
	 * Sets expiration time of ban.
	 * 
	 * @param timeEnd
	 *            expiration time of ban
	 */
	public void setTimeEnd(Timestamp timeEnd) {
		this.timeEnd = timeEnd;
	}

	/**
	 * Returns true if this ip ban is equal to another. Based on {@link #ip}
	 * 
	 * @param o
	 *            another ip ban
	 * @return true if ban's are equals
	 */
	@Override
    //TODO: implement CDIR
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof BanIp))
			return false;

		BanIp banIp = (BanIp) o;

		return !(ip != null ? !ip.equals(banIp.ip) : banIp.ip != null);
	}

	/**
	 * Returns ban's hashcode. Based on mask
	 * 
	 * @return ban's hashcode
	 */
	@Override
	public int hashCode() {
		return ip != null ? ip.hashCode() : 0;
	}
}
