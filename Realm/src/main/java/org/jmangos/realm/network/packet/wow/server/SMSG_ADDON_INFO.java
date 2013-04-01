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

import java.util.List;

import org.jmangos.commons.model.AddonInfo;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * The Class SMSG_ADDON_INFO.
 */
public class SMSG_ADDON_INFO extends AbstractWoWServerPacket {

    // Public key
    private final byte[] publicKey = new byte[] {
        (byte) 0xC3, (byte) 0x5B, (byte) 0x50, (byte) 0x84, (byte) 0xB9, (byte) 0x3E, (byte) 0x32,
        (byte) 0x42, (byte) 0x8C, (byte) 0xD0, (byte) 0xC7, (byte) 0x48, (byte) 0xFA, (byte) 0x0E,
        (byte) 0x5D, (byte) 0x54, (byte) 0x5A, (byte) 0xA3, (byte) 0x0E, (byte) 0x14, (byte) 0xBA,
        (byte) 0x9E, (byte) 0x0D, (byte) 0xB9, (byte) 0x5D, (byte) 0x8B, (byte) 0xEE, (byte) 0xB6,
        (byte) 0x84, (byte) 0x93, (byte) 0x45, (byte) 0x75, (byte) 0xFF, (byte) 0x31, (byte) 0xFE,
        (byte) 0x2F, (byte) 0x64, (byte) 0x3F, (byte) 0x3D, (byte) 0x6D, (byte) 0x07, (byte) 0xD9,
        (byte) 0x44, (byte) 0x9B, (byte) 0x40, (byte) 0x85, (byte) 0x59, (byte) 0x34, (byte) 0x4E,
        (byte) 0x10, (byte) 0xE1, (byte) 0xE7, (byte) 0x43, (byte) 0x69, (byte) 0xEF, (byte) 0x7C,
        (byte) 0x16, (byte) 0xFC, (byte) 0xB4, (byte) 0xED, (byte) 0x1B, (byte) 0x95, (byte) 0x28,
        (byte) 0xA8, (byte) 0x23, (byte) 0x76, (byte) 0x51, (byte) 0x31, (byte) 0x57, (byte) 0x30,
        (byte) 0x2B, (byte) 0x79, (byte) 0x08, (byte) 0x50, (byte) 0x10, (byte) 0x1C, (byte) 0x4A,
        (byte) 0x1A, (byte) 0x2C, (byte) 0xC8, (byte) 0x8B, (byte) 0x8F, (byte) 0x05, (byte) 0x2D,
        (byte) 0x22, (byte) 0x3D, (byte) 0xDB, (byte) 0x5A, (byte) 0x24, (byte) 0x7A, (byte) 0x0F,
        (byte) 0x13, (byte) 0x50, (byte) 0x37, (byte) 0x8F, (byte) 0x5A, (byte) 0xCC, (byte) 0x9E,
        (byte) 0x04, (byte) 0x44, (byte) 0x0E, (byte) 0x87, (byte) 0x01, (byte) 0xD4, (byte) 0xA3,
        (byte) 0x15, (byte) 0x94, (byte) 0x16, (byte) 0x34, (byte) 0xC6, (byte) 0xC2, (byte) 0xC3,
        (byte) 0xFB, (byte) 0x49, (byte) 0xFE, (byte) 0xE1, (byte) 0xF9, (byte) 0xDA, (byte) 0x8C,
        (byte) 0x50, (byte) 0x3C, (byte) 0xBE, (byte) 0x2C, (byte) 0xBB, (byte) 0x57, (byte) 0xED,
        (byte) 0x46, (byte) 0xB9, (byte) 0xAD, (byte) 0x8B, (byte) 0xC6, (byte) 0xDF, (byte) 0x0E,
        (byte) 0xD6, (byte) 0x0F, (byte) 0xBE, (byte) 0x80, (byte) 0xB3, (byte) 0x8B, (byte) 0x1E,
        (byte) 0x77, (byte) 0xCF, (byte) 0xAD, (byte) 0x22, (byte) 0xCF, (byte) 0xB7, (byte) 0x4B,
        (byte) 0xCF, (byte) 0xFB, (byte) 0xF0, (byte) 0x6B, (byte) 0x11, (byte) 0x45, (byte) 0x2D,
        (byte) 0x7A, (byte) 0x81, (byte) 0x18, (byte) 0xF2, (byte) 0x92, (byte) 0x7E, (byte) 0x98,
        (byte) 0x56, (byte) 0x5D, (byte) 0x5E, (byte) 0x69, (byte) 0x72, (byte) 0x0A, (byte) 0x0D,
        (byte) 0x03, (byte) 0x0A, (byte) 0x85, (byte) 0xA2, (byte) 0x85, (byte) 0x9C, (byte) 0xCB,
        (byte) 0xFB, (byte) 0x56, (byte) 0x6E, (byte) 0x8F, (byte) 0x44, (byte) 0xBB, (byte) 0x8F,
        (byte) 0x02, (byte) 0x22, (byte) 0x68, (byte) 0x63, (byte) 0x97, (byte) 0xBC, (byte) 0x85,
        (byte) 0xBA, (byte) 0xA8, (byte) 0xF7, (byte) 0xB5, (byte) 0x40, (byte) 0x68, (byte) 0x3C,
        (byte) 0x77, (byte) 0x86, (byte) 0x6F, (byte) 0x4B, (byte) 0xD7, (byte) 0x88, (byte) 0xCA,
        (byte) 0x8A, (byte) 0xD7, (byte) 0xCE, (byte) 0x36, (byte) 0xF0, (byte) 0x45, (byte) 0x6E,
        (byte) 0xD5, (byte) 0x64, (byte) 0x79, (byte) 0x0F, (byte) 0x17, (byte) 0xFC, (byte) 0x64,
        (byte) 0xDD, (byte) 0x10, (byte) 0x6F, (byte) 0xF3, (byte) 0xF5, (byte) 0xE0, (byte) 0xA6,
        (byte) 0xC3, (byte) 0xFB, (byte) 0x1B, (byte) 0x8C, (byte) 0x29, (byte) 0xEF, (byte) 0x8E,
        (byte) 0xE5, (byte) 0x34, (byte) 0xCB, (byte) 0xD1, (byte) 0x2A, (byte) 0xCE, (byte) 0x79,
        (byte) 0xC3, (byte) 0x9A, (byte) 0x0D, (byte) 0x36, (byte) 0xEA, (byte) 0x01, (byte) 0xE0,
        (byte) 0xAA, (byte) 0x91, (byte) 0x20, (byte) 0x54, (byte) 0xF0, (byte) 0x72, (byte) 0xD8,
        (byte) 0x1E, (byte) 0xC7, (byte) 0x89, (byte) 0xD2 };

    private final List<AddonInfo> addonInfos;

    public SMSG_ADDON_INFO(final List<AddonInfo> addonInfos) {

        this.addonInfos = addonInfos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.wowemu.common.network.model.SendablePacket#writeImpl()
     */
    @SuppressWarnings("unused")
    @Override
    protected void writeImpl() {

        for (final AddonInfo addon : this.addonInfos) {
            final int state = 2; // 2
            writeC(state);

            final int unk1 = 1;
            writeC(unk1);

            final boolean unk2 = (addon.getCRC() != 0x4c1c776d); // CRC check
            writeC(unk2);
            if (unk2) {
                writeB(this.publicKey);
            }

            writeD(0x00);
            final int unk3 = 0; // ?
            writeC(unk3);

            if (unk3 > 0) {
                // String?!
                writeC(0);
            }
        }

        final int count = 0; // BannedCount
        writeD(count);
        for (int i = 0; i < count; i++) {
            // TODO: implement banned addons
        }
    }
}
