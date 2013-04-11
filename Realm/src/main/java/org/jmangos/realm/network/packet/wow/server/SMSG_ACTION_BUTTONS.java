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
package org.jmangos.realm.network.packet.wow.server;

import java.util.Map;

import org.jmangos.commons.entities.CharacterButton;
import org.jmangos.commons.enums.ActionButtonMessageType;
import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_ACTION_BUTTONS.
 */
public class SMSG_ACTION_BUTTONS extends AbstractWoWServerPacket {

    /** The player. */
    private Player player;
    private ActionButtonMessageType type;
    private static int ACTION_BUTTON_COUNT = 144;

    public SMSG_ACTION_BUTTONS() {}

    /**
     * Instantiates a new SMSG_ACTION_BUTTONS.
     * 
     * @param player
     *        the player
     */
    public SMSG_ACTION_BUTTONS(final Player player, ActionButtonMessageType messageType) {

        this.type = messageType;
        this.player = player;
    }

    /**
     * (non-Javadoc)
     * 
     * @see org.jmangos.commons.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
        writeC(type.ordinal());
        if (type == ActionButtonMessageType.CLEAR) {
            return;
        }
        Map<Integer, CharacterButton> actionButtons =
                this.player.getCharacterData().getActionBittons();
        for (int i = 0; i < ACTION_BUTTON_COUNT; i++) {
            if (actionButtons.containsKey(i)) {
                CharacterButton button = actionButtons.get(i);
                writeD(button.getAction() | (button.getNativeButtonType() << 24));
            } else {
                writeD(0);
            }
        }
    }
}
