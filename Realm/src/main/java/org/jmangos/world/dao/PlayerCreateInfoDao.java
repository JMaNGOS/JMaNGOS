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
package org.jmangos.world.dao;

import org.jmangos.commons.entities.Playercreateinfo;
import org.jmangos.commons.entities.pk.PlayercreateinfoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * <ol>
 * <li><b>Class:</b> <tt>PlayerCreateInfoDao</tt> is {@link JpaRepository} to
 * get value of start position, orientation, map and action for player class and
 * race.
 * <li><b>Key:</b> is {@link PlayercreateinfoPK}
 * <li><b>Value:</b> is {@link Playercreateinfo}
 * </ol>
 * </p>
 * 
 * @author MinimaJack
 */
@Repository
@Transactional(readOnly = true)
public interface PlayerCreateInfoDao extends JpaRepository<Playercreateinfo, PlayercreateinfoPK> {

}
