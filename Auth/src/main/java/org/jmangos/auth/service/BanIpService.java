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
package org.jmangos.auth.service;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jmangos.auth.config.Config;
import org.jmangos.auth.dao.BanIpDAO;
import org.jmangos.commons.config.Compatiple;
import org.jmangos.commons.model.BanIp;
import org.jmangos.commons.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class BanIpService.
 * 
 * @author MinimaJack
 */
@Component
public class BanIpService implements Service {
    
    /**
     * Logger for this class.
     */
    private static final Logger log = LoggerFactory.getLogger(BanIpService.class);
    
    @Inject
    private Config              config;
    
    /** The ban ip dao. */
    @Inject
    private BanIpDAO            banIpDAO;
    
    /** List of banned ip addresses. */
    private List<BanIp>         banList;
    
    /**
     * 
     * @see org.jmangos.commons.service.Service#start()
     */
    @PostConstruct
    @Override
    public void start() {
    
        update();
        log.debug("BannedIpService loaded {} IP bans.", this.banList.size());
    }
    
    /**
     * Update.
     */
    private void update() {
    
        this.banList = this.banIpDAO.getAllBans();
    }
    
    /**
     * Checks if is banned.
     * 
     * @param ip
     *            the ip
     * @return true, if is banned
     */
    public boolean isBanned(final String ip) {
    
        // if auth server run in compatible mode...all ban info need get from
        // DB.
        if (this.config.COMPATIBLE == Compatiple.MANGOS) {
            final BanIp result = this.banIpDAO.getBan(ip);
            if (result != null) {
                return true;
            }
        } else {
            for (final BanIp ipBan : this.banList) {
                if (ipBan.isActive() && ip.equals(ipBan.getIp())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Ban ip.
     * 
     * @param ip
     *            the ip
     * @return true, if successful
     */
    public boolean banIp(final String ip) {
    
        return banIp(ip, null);
    }
    
    /**
     * Bans ip.
     * 
     * @param ip
     *            ip to ban
     * @param expireTime
     *            ban expiration time
     * @return was ip banned or not
     */
    public boolean banIp(final String ip, final Timestamp expireTime) {
    
        final BanIp ipBan = new BanIp();
        ipBan.setIp(ip);
        ipBan.setTimeEnd(expireTime);
        if (this.banIpDAO.insert(ipBan) != null) {
            this.banList.add(ipBan);
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
    public boolean addBan(final BanIp ipBan) {
    
        if (this.banIpDAO.insert(ipBan) != null) {
            this.banList.add(ipBan);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Removes ip ban.
     * 
     * @param ip
     *            ip to unban
     * @return returns true if ip was successfully unbanned
     */
    public boolean unbanIp(final String ip) {
    
        final Iterator<BanIp> it = this.banList.iterator();
        while (it.hasNext()) {
            final BanIp ipBan = it.next();
            if (ipBan.getIp().equals(ip)) {
                if (this.banIpDAO.remove(ipBan)) {
                    it.remove();
                    return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @see org.jmangos.commons.service.Service#stop()
     */
    @Override
    public void stop() {
    
        this.banList.clear();
    }
}
