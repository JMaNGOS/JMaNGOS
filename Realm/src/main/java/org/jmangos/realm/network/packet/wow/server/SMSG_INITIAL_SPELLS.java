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

import java.util.Map.Entry;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.commons.entities.CharacterSpell;
import org.jmangos.commons.model.player.Player;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

// TODO: Auto-generated Javadoc
/**
 * The Class SMSG_INITIAL_SPELLS.
 */
public class SMSG_INITIAL_SPELLS extends AbstractWoWServerPacket {

    /** The player. */
    private Player player;

    /**
     * Instantiates a new sMS g_ initia l_ spells.
     */
    public SMSG_INITIAL_SPELLS() {

    }

    /**
     * Instantiates a new sMS g_ initia l_ spells.
     * 
     * @param player
     *        the player
     */
    public SMSG_INITIAL_SPELLS(final Player player) {

        this.player = player;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @Override
    public void writeImpl() {
        final CharacterData cd = this.player.getCharacterData();
        writeC(cd.getGender().getValue());
        writeH(cd.getSpells().size());
        for (final Entry<Integer, CharacterSpell> spellEn : cd.getSpells().entrySet()) {
            writeD(spellEn.getValue().getSpellId());
            writeH(0);
        }
        writeD(0);

    }

}
