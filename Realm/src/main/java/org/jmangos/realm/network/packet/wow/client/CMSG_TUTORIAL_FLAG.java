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
package org.jmangos.realm.network.packet.wow.client;

import java.nio.BufferUnderflowException;

import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket;
import org.springframework.stereotype.Component;

/**
 * The Class CMSG_TUTORIAL_FLAG.
 */
@Component
public class CMSG_TUTORIAL_FLAG extends AbstractWoWClientPacket {
    

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
    
        final int Flag = readD();
        final int wInt = (Flag / 32);
        if (wInt >= 8) {
            return;
        }
       // final int rInt = (Flag % 32);
        
        // TODO:FIXME
       // int tutorials = 0;// getAccount().getTutorials(wInt); /* disabled by paalgyula */
       // tutorials |= (1 << rInt);
        // getAccount().setTutorials(tutorials, wInt); /* disabled by paalgyula */
        
    }
    

    @Override
    protected void runImpl() {
    
    }
}
