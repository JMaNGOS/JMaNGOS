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
package org.JMANGOS.login.service;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.JMANGOS.common.config.Compatiple;
import org.JMANGOS.common.service.Service;
import org.JMANGOS.login.config.Config;
import org.JMANGOS.login.dao.BanIpDAO;
import org.JMANGOS.login.model.BanIp;

// TODO: Auto-generated Javadoc
/**
 * The Class BanIpService.
 */
public class BanIpService implements Service {
	/**
	 * Logger for this class.
	 */
	private static final Logger log = Logger.getLogger(BanIpService.class);
	
	/** The ban ip dao. */
	@Inject
	private BanIpDAO banIpDAO;
	
	/** List of banned ip addresses. */
	private static Set<BanIp> banList;

	/*
	 * (non-Javadoc)
	 * @see org.wowemu.common.service.Service#start()
	 */
	@Override
	public void start() {
		update();
		log.debug("BannedIpService loaded " + banList.size() + " IP bans.");
	}

	/**
	 * Update.
	 */
	private void update() {
		banList = banIpDAO.getAllBans();
	}

	/**
	 * Checks if is banned.
	 *
	 * @param ip the ip
	 * @return true, if is banned
	 */
	public boolean isBanned(String ip) {
		if (Config.COMPATIBLE == Compatiple.MANGOS) {
			BanIp result = banIpDAO.getBan(ip);
			if (result != null) {
				return true;
			}
		} else {
			for (BanIp ipBan : banList) {
				if (ipBan.isActive() && ip.equals(ipBan.getIp()))
					return true;
			}
		}
		return false;
	}

	/**
	 * Ban ip.
	 *
	 * @param ip the ip
	 * @return true, if successful
	 */
	public boolean banIp(String ip) {
		return banIp(ip, null);
	}

	/**
	 * Bans ip.
	 *
	 * @param ip ip to ban
	 * @param expireTime ban expiration time
	 * @return was ip banned or not
	 */
	public boolean banIp(String ip, Long expireTime) {
		BanIp ipBan = new BanIp();
		ipBan.setIp(ip);
		ipBan.setTimeEnd(expireTime);
		if (banIpDAO.insert(ipBan)) {
			banList.add(ipBan);
			return true;
		}
		return false;
	}

	/**
	 * Adds ip ban.
	 * 
	 * @param ipBan
	 *            banned ip to add
	 * @return was it updated or not
	 */
	public boolean addBan(BanIp ipBan) {
		if (banIpDAO.insert(ipBan)) {
			banList.add(ipBan);
			return true;
		} else
			return false;
	}

	/**
	 * Removes ip ban.
	 * 
	 * @param ip
	 *            ip to unban
	 * @return returns true if ip was successfully unbanned
	 */
	public boolean unbanIp(String ip) {
		Iterator<BanIp> it = banList.iterator();
		while (it.hasNext()) {
			BanIp ipBan = it.next();
			if (ipBan.getIp().equals(ip)) {
				if (banIpDAO.remove(ipBan)) {
					it.remove();
					return true;
				} else
					break;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.wowemu.common.service.Service#stop()
	 */
	@Override
	public void stop() {
		banList.clear();
	}
}
