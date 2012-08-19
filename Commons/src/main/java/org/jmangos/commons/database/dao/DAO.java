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
package org.jmangos.commons.database.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface DAO {
    
    static final Logger log = LoggerFactory.getLogger(DAO.class);
    
    /**
     * Unique identifier for DAO class, all subclasses must have same identifiers. Must return
     * {@link Class#getName()} of abstract class
     * 
     * @return identifier of DAO class
     */
    public String getClassName();
}
