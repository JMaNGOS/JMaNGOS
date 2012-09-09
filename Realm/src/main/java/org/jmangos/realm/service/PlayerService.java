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
package org.jmangos.realm.service;

import gnu.trove.map.hash.TLongObjectHashMap;

import javax.inject.Inject;
import javax.inject.Named;

import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.RealmServer;
import org.jmangos.realm.entities.CharacterEntity;
import org.jmangos.realm.model.base.WorldObject;
import org.jmangos.realm.model.base.update.ObjectFields;
import org.jmangos.realm.model.base.update.PlayerFields;
import org.jmangos.realm.model.base.update.UnitField;
import org.jmangos.realm.model.enums.Powers;
import org.jmangos.realm.model.enums.SpellSchools;
import org.jmangos.realm.model.enums.Stats;
import org.jmangos.realm.model.player.Player;
import org.jmangos.realm.model.unit.Units;
import org.jmangos.realm.network.packet.wow.server.MSG_SET_DUNGEON_DIFFICULTY;
import org.jmangos.realm.network.packet.wow.server.SMSG_ACTION_BUTTONS;
import org.jmangos.realm.network.packet.wow.server.SMSG_ALL_ACHIEVEMENT_DATA;
import org.jmangos.realm.network.packet.wow.server.SMSG_BINDPOINTUPDATE;
import org.jmangos.realm.network.packet.wow.server.SMSG_COMPRESSED_UPDATE_OBJECT;
import org.jmangos.realm.network.packet.wow.server.SMSG_EQUIPMENT_SET_LIST;
import org.jmangos.realm.network.packet.wow.server.SMSG_FEATURE_SYSTEM_STATUS;
import org.jmangos.realm.network.packet.wow.server.SMSG_INITIALIZE_FACTIONS;
import org.jmangos.realm.network.packet.wow.server.SMSG_INITIAL_SPELLS;
import org.jmangos.realm.network.packet.wow.server.SMSG_INIT_WORLD_STATES;
import org.jmangos.realm.network.packet.wow.server.SMSG_INSTANCE_DIFFICULTY;
import org.jmangos.realm.network.packet.wow.server.SMSG_LOGIN_SETTIMESPEED;
import org.jmangos.realm.network.packet.wow.server.SMSG_LOGIN_VERIFY_WORLD;
import org.jmangos.realm.network.packet.wow.server.SMSG_MOTD;
import org.jmangos.realm.network.packet.wow.server.SMSG_PLAYED_TIME;
import org.jmangos.realm.network.packet.wow.server.SMSG_POWER_UPDATE;
import org.jmangos.realm.network.packet.wow.server.SMSG_SPELL_GO;
import org.jmangos.realm.network.packet.wow.server.SMSG_TALENTS_INFO;
import org.jmangos.realm.network.packet.wow.server.SMSG_TIME_SYNC_REQ;
import org.jmangos.realm.services.CharacterService;
import org.jmangos.world.entities.PlayerClassLevelInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerService.
 */
@Component
public class PlayerService {
    
    /** The Constant logger. */
    private static final Logger               logger                         = LoggerFactory.getLogger(PlayerService.class);
    
    /** The Constant PLAYER_EXPLORED_ZONES_SIZE. */
    private static final int                  PLAYER_EXPLORED_ZONES_SIZE     = 128;
    
    /** The Constant KNOWN_TITLES_SIZE. */
    private static final int                  KNOWN_TITLES_SIZE              = 3;
    
    /** The Constant CONFIG_UINT32_MAX_PLAYER_LEVEL. */
    private static final int                  CONFIG_UINT32_MAX_PLAYER_LEVEL = 80;
    
    /** The sender. */
    @Inject
    @Named("nettyPacketSender")
    private AbstractPacketSender              sender;
    
    @Inject
    private CharacterService                  characterService;
    
    /** The player class level info storages. */
    @Inject
    private PlayerClassLevelInfoStorages      playerClassLevelInfoStorages;
    
    /** The player level storages. */
    @Inject
    private PlayerLevelStorages               playerLevelStorages;
    
    /** The simple storages. */
    @Inject
    private PlayerXpForLevelStorages          playerXpForLevelStorages;
    
    /** The item storages. */
    @Inject
    private ItemStorages                      itemStorages;
    
    /** The playerlist. */
    private static TLongObjectHashMap<Player> playerlist                     = new TLongObjectHashMap<Player>();
    
    /**
     * Prepare player.
     * 
     * @param chanel
     *            the chanel
     * @param guid
     *            the guid
     * @return the player
     */
    public Player preparePlayer(final NettyNetworkChannel chanel, final int guid) {
    
        final Player player = new Player(this.characterService.readCharacter(guid));
        player.setChannel(chanel);
        chanel.setActiveObject(player);
        return player;
    }
    
    /**
     * Send inicial packets.
     * 
     * @param player
     *            the player
     * @return the world object
     */
    public WorldObject sendInicialPackets(final Player player) {
    
        final byte[] taurenBytes = new byte[] { (byte) 0x55, (byte) 0x07, (byte) 0x00, (byte) 0x00, (byte) 0x78, (byte) 0x01, (byte) 0x85, (byte) 0x94,
                (byte) 0x4D, (byte) 0x48, (byte) 0x54, (byte) 0x51, (byte) 0x14, (byte) 0xC7, (byte) 0xEF, (byte) 0xBD, (byte) 0x33, (byte) 0x3E, (byte) 0x4D,
                (byte) 0x27, (byte) 0x4C, (byte) 0x4B, (byte) 0xAD, (byte) 0x4C, (byte) 0x1A, (byte) 0x61, (byte) 0x90, (byte) 0x31, (byte) 0x86, (byte) 0x7A,
                (byte) 0x19, (byte) 0x25, (byte) 0x4A, (byte) 0xE0, (byte) 0x33, (byte) 0xA2, (byte) 0xB1, (byte) 0x4D, (byte) 0x24, (byte) 0x54, (byte) 0x20,
                (byte) 0x06, (byte) 0x13, (byte) 0x11, (byte) 0xED, (byte) 0x06, (byte) 0x91, (byte) 0x16, (byte) 0x7D, (byte) 0xAC, (byte) 0xE6, (byte) 0xB5,
                (byte) 0x6D, (byte) 0xD3, (byte) 0xA6, (byte) 0x02, (byte) 0xA1, (byte) 0x2F, (byte) 0x97, (byte) 0xED, (byte) 0xDC, (byte) 0x64, (byte) 0x46,
                (byte) 0x0B, (byte) 0x41, (byte) 0xDA, (byte) 0x5A, (byte) 0xBB, (byte) 0x82, (byte) 0x88, (byte) 0x8C, (byte) 0x36, (byte) 0x6D, (byte) 0x5A,
                (byte) 0x84, (byte) 0xB4, (byte) 0x1B, (byte) 0xB2, (byte) 0xFF, (byte) 0xFF, (byte) 0x7E, (byte) 0x30, (byte) 0x77, (byte) 0xDE, (byte) 0x1B,
                (byte) 0xE8, (byte) 0x0D, (byte) 0xE7, (byte) 0x9E, (byte) 0xFB, (byte) 0xF5, (byte) 0x9B, (byte) 0x7B, (byte) 0xEE, (byte) 0x39, (byte) 0xF7,
                (byte) 0x9C, (byte) 0x7D, (byte) 0x42, (byte) 0x08, (byte) 0x15, (byte) 0xAB, (byte) 0xB2, (byte) 0xDC, (byte) 0x23, (byte) 0x44, (byte) 0x19,
                (byte) 0xDD, (byte) 0xCA, (byte) 0x34, (byte) 0x26, (byte) 0x38, (byte) 0x67, (byte) 0x54, (byte) 0x39, (byte) 0x03, (byte) 0xFD, (byte) 0x6B,
                (byte) 0x80, (byte) 0x83, (byte) 0xDA, (byte) 0x94, (byte) 0x44, (byte) 0xEB, (byte) 0x44, (byte) 0xC5, (byte) 0x61, (byte) 0x92, (byte) 0x09,
                (byte) 0x43, (byte) 0x6E, (byte) 0xC3, (byte) 0xDF, (byte) 0x90, (byte) 0xB9, (byte) 0xD6, (byte) 0xC9, (byte) 0x6E, (byte) 0x33, (byte) 0x33,
                (byte) 0x8E, (byte) 0x19, (byte) 0x8A, (byte) 0x8A, (byte) 0x87, (byte) 0x53, (byte) 0xEC, (byte) 0x30, (byte) 0xB7, (byte) 0x5B, (byte) 0x76,
                (byte) 0xAE, (byte) 0x8D, (byte) 0xDD, (byte) 0x66, (byte) 0x16, (byte) 0xE6, (byte) 0x09, (byte) 0x8A, (byte) 0x8A, (byte) 0x47, (byte) 0x53,
                (byte) 0xEC, (byte) 0x28, (byte) 0xB7, (byte) 0x5B, (byte) 0xF6, (byte) 0x7A, (byte) 0x0B, (byte) 0xF6, (byte) 0x00, (byte) 0x16, (byte) 0x29,
                (byte) 0x2A, (byte) 0xEE, (byte) 0x4D, (byte) 0xB1, (byte) 0xBD, (byte) 0x24, (byte) 0x2D, (byte) 0x3B, (byte) 0xDF, (byte) 0xC2, (byte) 0x66,
                (byte) 0xAE, (byte) 0x53, (byte) 0x54, (byte) 0x5C, (byte) 0xF0, (byte) 0xD8, (byte) 0x3C, (byte) 0x66, (byte) 0x44, (byte) 0x58, (byte) 0x60,
                (byte) 0x6B, (byte) 0xD9, (byte) 0xA3, (byte) 0x7B, (byte) 0xD9, (byte) 0x6D, (byte) 0xB6, (byte) 0x99, (byte) 0xBE, (byte) 0x6A, (byte) 0xF0,
                (byte) 0x81, (byte) 0xC7, (byte) 0x73, (byte) 0xAF, (byte) 0x08, (byte) 0x03, (byte) 0xAD, (byte) 0x8C, (byte) 0xBF, (byte) 0x26, (byte) 0x76,
                (byte) 0x71, (byte) 0xD0, (byte) 0xCC, (byte) 0x37, (byte) 0xEC, (byte) 0xEE, (byte) 0xF0, (byte) 0xD8, (byte) 0xBC, (byte) 0xA6, (byte) 0x3A,
                (byte) 0x74, (byte) 0x6B, (byte) 0xD8, (byte) 0xC2, (byte) 0x20, (byte) 0x07, (byte) 0xCD, (byte) 0x2C, (byte) 0xCF, (byte) 0x56, (byte) 0x71,
                (byte) 0xA7, (byte) 0xC7, (byte) 0x19, (byte) 0x40, (byte) 0x5F, (byte) 0xD1, (byte) 0xDA, (byte) 0xFC, (byte) 0x26, (byte) 0xC1, (byte) 0xD1,
                (byte) 0x75, (byte) 0x2A, (byte) 0xEE, (byte) 0x4A, (byte) 0x31, (byte) 0x5D, (byte) 0x06, (byte) 0xD5, (byte) 0x71, (byte) 0x7D, (byte) 0xA4,
                (byte) 0x1D, (byte) 0xD6, (byte) 0x38, (byte) 0xCB, (byte) 0x30, (byte) 0x39, (byte) 0x8F, (byte) 0xE1, (byte) 0xC9, (byte) 0x42, (byte) 0xE4,
                (byte) 0x3C, (byte) 0x66, (byte) 0xAD, (byte) 0xC5, (byte) 0x39, (byte) 0x3B, (byte) 0xF8, (byte) 0x54, (byte) 0x3C, (byte) 0xE6, (byte) 0x71,
                (byte) 0x06, (byte) 0x18, (byte) 0xF3, (byte) 0xB8, (byte) 0xE5, (byte) 0x04, (byte) 0xC7, (byte) 0x37, (byte) 0xA9, (byte) 0xE2, (byte) 0x49,
                (byte) 0x8F, (byte) 0xC9, (byte) 0x73, (byte) 0x77, (byte) 0x38, (byte) 0xC9, (byte) 0xD6, (byte) 0xDE, (byte) 0xE9, (byte) 0xF8, (byte) 0x7F,
                (byte) 0xE3, (byte) 0x30, (byte) 0xEE, (byte) 0xF1, (byte) 0x06, (byte) 0xE4, (byte) 0x9B, (byte) 0xC4, (byte) 0xA7, (byte) 0xEF, (byte) 0x27,
                (byte) 0x13, (byte) 0xBC, (byte) 0x39, (byte) 0xB3, (byte) 0x3F, (byte) 0xC5, (byte) 0xF4, (byte) 0x7B, (byte) 0x4C, (byte) 0xD2, (byte) 0x27,
                (byte) 0x7C, (byte) 0xFF, (byte) 0x2A, (byte) 0x1E, (byte) 0x4A, (byte) 0x31, (byte) 0x43, (byte) 0x1E, (byte) 0x93, (byte) 0xF4, (byte) 0xBD,
                (byte) 0x39, (byte) 0x67, (byte) 0x24, (byte) 0xC5, (byte) 0x8C, (byte) 0x78, (byte) 0xCC, (byte) 0xCB, (byte) 0x84, (byte) 0x3F, (byte) 0xCC,
                (byte) 0x39, (byte) 0xC5, (byte) 0x14, (byte) 0x53, (byte) 0xF4, (byte) 0x98, (byte) 0xA4, (byte) 0x0F, (byte) 0x4D, (byte) 0xBC, (byte) 0xB2,
                (byte) 0x49, (byte) 0x26, (byte) 0xCC, (byte) 0x7A, (byte) 0xCC, (byte) 0x03, (byte) 0xDD, (byte) 0x6F, (byte) 0xC4, (byte) 0x98, (byte) 0x11,
                (byte) 0x75, (byte) 0x6F, (byte) 0x31, (byte) 0x23, (byte) 0x65, (byte) 0x76, (byte) 0xD1, (byte) 0xEC, (byte) 0x15, (byte) 0x57, (byte) 0xEA,
                (byte) 0x42, (byte) 0xDC, (byte) 0x0C, (byte) 0x4E, (byte) 0xBE, (byte) 0x1F, (byte) 0x58, (byte) 0x5B, (byte) 0xD8, (byte) 0x38, (byte) 0x7B,
                (byte) 0xEF, (byte) 0xF2, (byte) 0x99, (byte) 0xA5, (byte) 0x95, (byte) 0xFB, (byte) 0x91, (byte) 0x59, (byte) 0xCA, (byte) 0x43, (byte) 0x6F,
                (byte) 0x41, (byte) 0x1E, (byte) 0x46, (byte) 0x8B, (byte) 0x87, (byte) 0x9E, (byte) 0x40, (byte) 0x37, (byte) 0xC6, (byte) 0x5B, (byte) 0xDD,
                (byte) 0xE7, (byte) 0xA3, (byte) 0x8D, (byte) 0x3F, (byte) 0x33, (byte) 0xD1, (byte) 0x31, (byte) 0x6C, (byte) 0x3C, (byte) 0xD2, (byte) 0x27,
                (byte) 0x6A, (byte) 0x3D, (byte) 0x7D, (byte) 0x62, (byte) 0xFD, (byte) 0xF3, (byte) 0x37, (byte) 0xF1, (byte) 0x5B, (byte) 0xE2, (byte) 0x41,
                (byte) 0x5F, (byte) 0x08, (byte) 0x44, (byte) 0x76, (byte) 0xB3, (byte) 0xC3, (byte) 0xBC, (byte) 0x1F, (byte) 0x2C, (byte) 0x9B, (byte) 0xEF,
                (byte) 0x55, (byte) 0x11, (byte) 0xB5, (byte) 0xA8, (byte) 0xBE, (byte) 0x8D, (byte) 0x07, (byte) 0x55, (byte) 0xDF, (byte) 0xF9, (byte) 0xD0,
                (byte) 0xED, (byte) 0x66, (byte) 0x5B, (byte) 0xEA, (byte) 0x77, (byte) 0xD5, (byte) 0x2F, (byte) 0xAF, (byte) 0xAB, (byte) 0x2D, (byte) 0x57,
                (byte) 0x5A, (byte) 0x4F, (byte) 0xE6, (byte) 0x7F, (byte) 0xD4, (byte) 0x84, (byte) 0xB2, (byte) 0x17, (byte) 0xB7, (byte) 0x3B, (byte) 0x02,
                (byte) 0xF1, (byte) 0x97, (byte) 0xBD, (byte) 0x48, (byte) 0x0F, (byte) 0x6B, (byte) 0x6C, (byte) 0xA7, (byte) 0x20, (byte) 0xCE, (byte) 0x01,
                (byte) 0x4C, (byte) 0xB2, (byte) 0x40, (byte) 0x4A, (byte) 0x79, (byte) 0x1B, (byte) 0x73, (byte) 0x37, (byte) 0x20, (byte) 0xD4, (byte) 0x3F,
                (byte) 0x11, (byte) 0x05, (byte) 0xF6, (byte) 0x19, (byte) 0x0C, (byte) 0x26, (byte) 0xB4, (byte) 0x4E, (byte) 0x4C, (byte) 0x34, (byte) 0x97,
                (byte) 0x90, (byte) 0x35, (byte) 0x1F, (byte) 0xDB, (byte) 0x8D, (byte) 0x8C, (byte) 0x5E, (byte) 0xAD, (byte) 0xE0, (byte) 0x6F, (byte) 0xD6,
                (byte) 0xA7, (byte) 0x4E, (byte) 0x63, (byte) 0x9D, (byte) 0x32, (byte) 0xDB, (byte) 0x3E, (byte) 0x37, (byte) 0x3D, (byte) 0xDB, (byte) 0x7E,
                (byte) 0x77, (byte) 0x9A, (byte) 0xFF, (byte) 0x77, (byte) 0x18, (byte) 0xE3, (byte) 0x1E, (byte) 0xC8, (byte) 0x41, (byte) 0x08, (byte) 0xAF,
                (byte) 0x37, (byte) 0x00, (byte) 0x79, (byte) 0x0B, (byte) 0xB1, (byte) 0x81, (byte) 0xEF, (byte) 0x39, (byte) 0x81, (byte) 0x3E, (byte) 0x93,
                (byte) 0x76, (byte) 0xB5, (byte) 0x3A, (byte) 0x18, (byte) 0xAD, (byte) 0x56, (byte) 0xE7, (byte) 0x23, (byte) 0x32, (byte) 0x6D, (byte) 0x99,
                (byte) 0x40, (byte) 0xC2, (byte) 0x6E, (byte) 0x49, (byte) 0xBB, (byte) 0xB6, (byte) 0x95, (byte) 0xB1, (byte) 0x2F, (byte) 0x07, (byte) 0x03,
                (byte) 0xC2, (byte) 0xDD, (byte) 0xA6, (byte) 0x58, (byte) 0xB3, (byte) 0xF8, (byte) 0xB2, (byte) 0x88, (byte) 0xB2, (byte) 0x18, (byte) 0xB2,
                (byte) 0xA8, (byte) 0xB1, (byte) 0x38, (byte) 0xB1, (byte) 0xC0, (byte) 0x60, (byte) 0x2B, (byte) 0xBF, (byte) 0xB2, (byte) 0x2B, (byte) 0xD4,
                (byte) 0xC3, (byte) 0x76, (byte) 0xEC, (byte) 0x0A, (byte) 0xA8, (byte) 0xCE, (byte) 0x6D, (byte) 0xAC, (byte) 0x17, (byte) 0xEC, (byte) 0xBC,
                (byte) 0x2B, (byte) 0x50, (byte) 0xFA, (byte) 0x4E, (byte) 0x98, (byte) 0x77, (byte) 0xC5, (byte) 0xC3, (byte) 0x15, (byte) 0x04, (byte) 0x97,
                (byte) 0xE4, (byte) 0x2E, (byte) 0x69, (byte) 0x5D, (byte) 0x22, (byte) 0xBA, (byte) 0x84, (byte) 0x72, (byte) 0x49, (byte) 0xE2, (byte) 0x1E,
                (byte) 0xBE, (byte) 0x7B, (byte) 0xCC, (byte) 0x45, (byte) 0xFB, (byte) 0xFF, (byte) 0xB8, (byte) 0x03, (byte) 0xBF, (byte) 0x72, (byte) 0x09,
                (byte) 0xB6, (byte) 0xDF, (byte) 0x81, (byte) 0xAD, (byte) 0xF4, (byte) 0x81, (byte) 0xC4, (byte) 0xAF, (byte) 0xA4, (byte) 0x75, (byte) 0xB7,
                (byte) 0x38, (byte) 0x65, (byte) 0x75, (byte) 0x05, (byte) 0xBA, (byte) 0x0B, (byte) 0xDE, (byte) 0x61, (byte) 0x70, (byte) 0x4B, (byte) 0xB2,
                (byte) 0x24, (byte) 0x6F, (byte) 0x59, (byte) 0xFD, (byte) 0x02, (byte) 0x3A, (byte) 0x87, (byte) 0xF9, (byte) 0x65, (byte) 0x68, (byte) 0x09,
                (byte) 0xFD, (byte) 0x14, (byte) 0x0E, (byte) 0x21, (byte) 0xFF, (byte) 0xCC, (byte) 0xEA, (byte) 0xE7, (byte) 0x56, (byte) 0xAF, (byte) 0x58,
                (byte) 0xCD, (byte) 0xFB, (byte) 0xCF, (byte) 0x7C, (byte) 0x5F, (byte) 0x8A, (byte) 0x1E, (byte) 0xCF, (byte) 0x2F, (byte) 0x45, (byte) 0x0B,
                (byte) 0x95, (byte) 0xAF, (byte) 0xD1, (byte) 0xB9, (byte) 0xCC, (byte) 0xA6, (byte) 0x16, (byte) 0x26, (byte) 0x85, (byte) 0x10, (byte) 0xB4,
                (byte) 0x26, (byte) 0x2B, (byte) 0x3E, (byte) 0x61, (byte) 0xD3, (byte) 0x84, (byte) 0x1E, (byte) 0xD7, (byte) 0x10, (byte) 0xB3, (byte) 0xD6,
                (byte) 0xC2, (byte) 0xE2, (byte) 0x75, (byte) 0x11, (byte) 0x7B, (byte) 0xFA, (byte) 0x20, (byte) 0xBC, (byte) 0x23, (byte) 0x63, (byte) 0xB6,
                (byte) 0x1F, (byte) 0xC2, (byte) 0x24, (byte) 0xE1, (byte) 0x1D, (byte) 0xFE, (byte) 0x01, (byte) 0x33, (byte) 0x4E, (byte) 0xA7, (byte) 0x10 };
        
        this.sender.send(player.getChannel(), new SMSG_POWER_UPDATE());
        
        this.sender.send(player.getChannel(), new MSG_SET_DUNGEON_DIFFICULTY());
        this.sender.send(player.getChannel(), new SMSG_INSTANCE_DIFFICULTY());
        
        this.sender.send(player.getChannel(), new SMSG_LOGIN_VERIFY_WORLD(player));
        // TODO: Reimplement (not needed to log in!)
        /*
         * sender.send(player.getChannel(), new SMSG_ACCOUNT_DATA_TIMES(
         * SMSG_ACCOUNT_DATA_TIMES.PER_CHARACTER_CACHE_MASK, player.getAccount().getAccountData()));
         */
        this.sender.send(player.getChannel(), new SMSG_FEATURE_SYSTEM_STATUS());
        // sender.send(player.getChannel(), new SMSG_LEARNED_DANCE_MOVES());
        this.sender.send(player.getChannel(), new SMSG_BINDPOINTUPDATE(player));
        this.sender.send(player.getChannel(), new SMSG_TALENTS_INFO());
        this.sender.send(player.getChannel(), new SMSG_INITIAL_SPELLS());
        this.sender.send(player.getChannel(), new SMSG_ACTION_BUTTONS(player));
        this.sender.send(player.getChannel(), new SMSG_INITIALIZE_FACTIONS());
        
        this.sender.send(player.getChannel(), new SMSG_INIT_WORLD_STATES(player));
        this.sender.send(player.getChannel(), new SMSG_EQUIPMENT_SET_LIST());
        this.sender.send(player.getChannel(), new SMSG_ALL_ACHIEVEMENT_DATA());
        this.sender.send(player.getChannel(), new SMSG_LOGIN_SETTIMESPEED());
        this.sender.send(player.getChannel(), new SMSG_INIT_WORLD_STATES(player));
        this.sender.send(player.getChannel(), new SMSG_TIME_SYNC_REQ());
        this.sender.send(player.getChannel(), new SMSG_SPELL_GO());
        this.sender.send(player.getChannel(), new SMSG_PLAYED_TIME());
        
        final SMSG_COMPRESSED_UPDATE_OBJECT updatePacket = new SMSG_COMPRESSED_UPDATE_OBJECT(player, taurenBytes);
        this.sender.send(player.getChannel(), updatePacket);
        
        player.setCreateBits();
        player.update();
        
        this.sender.send(player.getChannel(), new SMSG_MOTD("Test MotD String@test".split("@")));
        
        PlayerService.playerlist.put(player.getObjectId(), player);
        
        /**
         * Groovy console pass parameters
         */
        RealmServer.console.setVariable("playerService", this);
        RealmServer.console.setVariable("sender", this.sender);
        RealmServer.console.setVariable("player", player);
        
        return player;
    }
    
    public void savePlayer(final Player player) {
    
        final CharacterEntity character = new CharacterEntity();
        
        character.setAccount(player.getAccountInfo().getObjectId());
        character.setGuid(player.getObjectId());
        character.setPlayerBytes(player.GetUInt32Value(PlayerFields.PLAYER_BYTES));
        character.setPlayerBytes2(player.GetUInt32Value(PlayerFields.PLAYER_BYTES_2));
        character.setName(player.getName());
        character.setRace(player.getCharacterData().getRace());
        character.setClazz(player.getCharacterData().getClazz());
        this.characterService.createOrUpdateCharacter(character);
    }
    
    /**
     * Load home bind.
     * 
     * @param player
     *            the player
     * @return true, if successful
     */
    public boolean loadHomeBind(final Player player) {
    
        final CharacterEntity characterEntity = this.characterService.readCharacter(player.getObjectId());
        return player.setHomeBind(characterEntity.getHomeBindData());
    }
    
    /**
     * Load from db.
     * 
     * @param player
     *            the player
     * @return true, if successful
     */
    public boolean loadFromDB(final Player player) {
    
        player.initfields();
        player.SetUInt64Value(ObjectFields.OBJECT_FIELD_GUID, player.getObjectGuid().getRawValue());
        final CharacterEntity ch = player.getCharacterData();
        int bytes0 = 0;
        bytes0 |= ch.getRace();
        bytes0 |= ch.getClazz() << 8;
        bytes0 |= ch.getGender() << 16;
        player.SetUInt32Value(UnitField.UNIT_FIELD_BYTES_0, bytes0);
        player.SetUInt32Value(UnitField.UNIT_FIELD_LEVEL, ch.getLevel());
        player.SetUInt32Value(PlayerFields.PLAYER_XP, ch.getXp());
        player._LoadIntoDataField(ch.getExploredZones().split(" "), PlayerFields.PLAYER_EXPLORED_ZONES_1.getValue(), PLAYER_EXPLORED_ZONES_SIZE);
        player._LoadIntoDataField(ch.getKnownTitles().split(" "), PlayerFields.PLAYER__FIELD_KNOWN_TITLES.getValue(), KNOWN_TITLES_SIZE * 2);
        
        player.SetFloatValue(UnitField.UNIT_FIELD_BOUNDINGRADIUS, 0.388999998569489f);
        player.SetFloatValue(UnitField.UNIT_FIELD_COMBATREACH, 1.5f);
        player.SetFloatValue(UnitField.UNIT_FIELD_HOVERHEIGHT, 1.0f);
        player.setMoney(ch.getMoney());
        
        player.SetUInt32Value(PlayerFields.PLAYER_BYTES, ch.getPlayerBytes());
        player.SetUInt32Value(PlayerFields.PLAYER_BYTES_2, ch.getPlayerBytes2());
        player.SetUInt32Value(PlayerFields.PLAYER_BYTES_3, (ch.getDrunk() & 0xFFFE) | ch.getGender());
        player.SetUInt32Value(PlayerFields.PLAYER_FLAGS, ch.getPlayerFlags());
        player.SetUInt32Value(PlayerFields.PLAYER_FIELD_WATCHED_FACTION_INDEX, ch.getWatchedFaction());
        
        player.SetUInt64Value(PlayerFields.PLAYER_FIELD_KNOWN_CURRENCIES, ch.getKnownCurrencies());
        
        player.SetUInt32Value(PlayerFields.PLAYER_AMMO_ID, ch.getAmmoId());
        player.SetByteValue(PlayerFields.PLAYER_FIELD_BYTES, 2, (byte) ch.getActionBars());
        // FIXME load from dbc
        final int modelId = 0;
        player.SetUInt32Value(UnitField.UNIT_FIELD_DISPLAYID, modelId);
        player.SetUInt32Value(UnitField.UNIT_FIELD_NATIVEDISPLAYID, modelId);
        
        player.outDebugValue();
        
        initStatsForLevel(player);
        // LoadInventory(player);
        player.outDebugValue();
        return false;
    }
    
    /**
     * Load inventory.
     * 
     * @param player
     *            the player
     */
    public void loadInventory(final Player player) {
    
        final CharacterEntity characterEntity = this.characterService.readCharacter(player.getObjectId());
        // TODO need rework
        /*
         * final List<InventoryItem> inventoryItem = characterEntity.getInventory(); for (final
         * InventoryItem iT : inventoryItem) { final ItemPrototype proto =
         * this.itemStorages.get(iT.getItem().getProto()); if (proto != null) {
         * logger.debug(proto.getName() + " - " + iT.getSlot()); final Item item =
         * this.itemStorages.loadFromDB(iT, proto); if
         * (Item.isInventoryPos(Item.INVENTORY_SLOT_BAG_0, iT.getSlot())) {
         * logger.debug(proto.getName() + " - " + "in INVENTORY_SLOT_BAG_0"); } if
         * (Item.isEquipmentPos(Item.INVENTORY_SLOT_BAG_0, iT.getSlot())) {
         * logger.debug(proto.getName() + " - " + "in INVENTORY_SLOT_BAG_0 and can equip");
         * player.equipItem(iT.getSlot(), item); } } }
         */
        
    }
    
    /**
     * Inits the stats for level.
     * 
     * @param player
     *            the player
     */
    public void initStatsForLevel(final Player player) {
    
        final PlayerClassLevelInfo classInfo = this.playerClassLevelInfoStorages.get(player.getCharacterData().getClazz(), player.getCharacterData().getLevel());
        final org.jmangos.world.entities.PlayerLevelInfo info = this.playerLevelStorages.get(player.getCharacterData().getRace(), player.getCharacterData().getClazz(), player.getCharacterData().getLevel());
        
        player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MAX_LEVEL, CONFIG_UINT32_MAX_PLAYER_LEVEL);
        player.SetUInt32Value(PlayerFields.PLAYER_NEXT_LEVEL_XP, this.playerXpForLevelStorages.getXpForLevel((byte) player.getCharacterData().getLevel()));
        
        // UpdateSkillsForLevel ();
        
        player.SetFloatValue(UnitField.UNIT_MOD_CAST_SPEED, 1.0f);
        
        for (final Stats stat : Stats.values()) {
            final int val = info.getStats(stat);
            player.setCreateStat(stat, val);
            player.SetUInt32Value(UnitField.UNIT_FIELD_STAT0.getValue() + stat.ordinal(), val);
        }
        
        player.SetUInt32Value(UnitField.UNIT_FIELD_BASE_HEALTH, classInfo.getBasehealth());
        player.SetUInt32Value(UnitField.UNIT_FIELD_BASE_MANA, classInfo.getBasemana());
        player.SetArmor(info.getStats(Stats.AGILITY) * 2);
        
        // InitStatBuffMods();
        
        for (int i = PlayerFields.PLAYER_FIELD_COMBAT_RATING_1.getValue(); i < (PlayerFields.PLAYER_FIELD_COMBAT_RATING_1.getValue() + Units.MAX_COMBAT_RATING); ++i) {
            player.SetUInt32Value(i, 0);
        }
        
        player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MOD_HEALING_DONE_POS, 0);
        
        for (final SpellSchools spellscool : SpellSchools.values()) {
            player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_NEG.getValue() + spellscool.ordinal(), 0);
            player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_POS.getValue() + spellscool.ordinal(), 0);
            player.SetFloatValue(PlayerFields.PLAYER_FIELD_MOD_DAMAGE_DONE_PCT.getValue() + spellscool.ordinal(), 1.00f);
        }
        
        player.SetFloatValue(UnitField.UNIT_FIELD_BASEATTACKTIME, 2000.0f);
        // off hand attack time
        player.SetFloatValue(UnitField.UNIT_FIELD_BASEATTACKTIME.getValue() + 1, 2000.0f);
        player.SetFloatValue(UnitField.UNIT_FIELD_RANGEDATTACKTIME, 2000.0f);
        
        player.SetFloatValue(UnitField.UNIT_FIELD_MINDAMAGE, 0.0f);
        player.SetFloatValue(UnitField.UNIT_FIELD_MAXDAMAGE, 0.0f);
        player.SetFloatValue(UnitField.UNIT_FIELD_MINOFFHANDDAMAGE, 0.0f);
        player.SetFloatValue(UnitField.UNIT_FIELD_MAXOFFHANDDAMAGE, 0.0f);
        player.SetFloatValue(UnitField.UNIT_FIELD_MINRANGEDDAMAGE, 0.0f);
        player.SetFloatValue(UnitField.UNIT_FIELD_MAXRANGEDDAMAGE, 0.0f);
        
        player.SetUInt32Value(UnitField.UNIT_FIELD_ATTACK_POWER, 0);
        player.SetUInt32Value(UnitField.UNIT_FIELD_ATTACK_POWER_MODS, 0);
        player.SetFloatValue(UnitField.UNIT_FIELD_ATTACK_POWER_MULTIPLIER, 0.0f);
        player.SetUInt32Value(UnitField.UNIT_FIELD_RANGED_ATTACK_POWER, 0);
        player.SetUInt32Value(UnitField.UNIT_FIELD_RANGED_ATTACK_POWER_MODS, 0);
        player.SetFloatValue(UnitField.UNIT_FIELD_RANGED_ATTACK_POWER_MULTIPLIER, 0.0f);
        
        player.SetFloatValue(PlayerFields.PLAYER_CRIT_PERCENTAGE, 0.0f);
        player.SetFloatValue(PlayerFields.PLAYER_OFFHAND_CRIT_PERCENTAGE, 0.0f);
        player.SetFloatValue(PlayerFields.PLAYER_RANGED_CRIT_PERCENTAGE, 0.0f);
        
        for (final SpellSchools spellscool : SpellSchools.values()) {
            player.SetFloatValue(PlayerFields.PLAYER_SPELL_CRIT_PERCENTAGE1.getValue() + spellscool.ordinal(), 0.0f);
        }
        
        player.SetFloatValue(PlayerFields.PLAYER_PARRY_PERCENTAGE, 0.0f);
        player.SetFloatValue(PlayerFields.PLAYER_BLOCK_PERCENTAGE, 0.0f);
        player.SetUInt32Value(PlayerFields.PLAYER_SHIELD_BLOCK, 0);
        
        player.SetFloatValue(PlayerFields.PLAYER_DODGE_PERCENTAGE, 0.0f);
        
        for (final SpellSchools spellscool : SpellSchools.values()) {
            player.SetResistance(spellscool, spellscool.equals(SpellSchools.NORMAL) ? info.getStats(Stats.AGILITY) * 2 : 0);
            player.SetResistanceBuffMods(spellscool, true, 0.0f);
            player.SetResistanceBuffMods(spellscool, false, 0.0f);
            player.SetUInt32Value(UnitField.UNIT_FIELD_POWER_COST_MODIFIER.getValue() + spellscool.ordinal(), 0);
            player.SetFloatValue(UnitField.UNIT_FIELD_POWER_COST_MULTIPLIER.getValue() + spellscool.ordinal(), 0.0f);
        }
        
        player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MOD_TARGET_RESISTANCE, 0);
        player.SetUInt32Value(PlayerFields.PLAYER_FIELD_MOD_TARGET_PHYSICAL_RESISTANCE, 0);
        
        for (int i = 0; i < 3; ++i) {
            player.SetUInt32Value(PlayerFields.PLAYER_NO_REAGENT_COST_1.getValue() + i, 0);
        }
        
        // InitDataForForm();
        for (final Powers power : Powers.values()) {
            player.SetMaxPower(power, player.GetCreatePowers(power));
        }
        
        player.SetMaxHealth(classInfo.getBasehealth());
        
        player.SetUInt32Value(UnitField.UNIT_FIELD_MOUNTDISPLAYID, 0);
        
        player.SetUInt32Value(PlayerFields.PLAYER_FIELD_BYTES2.getValue(), 0);
        
        player.SetHealth(player.GetMaxHealth());
        player.SetPower(Powers.MANA, player.GetMaxPower(Powers.MANA));
        player.SetPower(Powers.ENERGY, player.GetMaxPower(Powers.ENERGY));
        if (player.GetPower(Powers.RAGE) > player.GetMaxPower(Powers.RAGE)) {
            player.SetPower(Powers.RAGE, player.GetMaxPower(Powers.RAGE));
        }
        player.SetPower(Powers.FOCUS, 0);
        player.SetPower(Powers.HAPPINESS, 0);
        player.SetPower(Powers.RUNIC_POWER, 0);
        
    }
    
    /**
     * Gets the playerlist.
     * 
     * @return the playerlist
     */
    public static TLongObjectHashMap<Player> getPlayerlist() {
    
        return playerlist;
    }
    
    /**
     * Sets the playerlist.
     * 
     * @param playerlist
     *            the new playerlist
     */
    public static void setPlayerlist(final TLongObjectHashMap<Player> playerlist) {
    
        PlayerService.playerlist = playerlist;
    }
    
    /**
     * Gets the player name.
     * 
     * @param guid
     *            the guid
     * @return the player name
     */
    public static String getPlayerName(final long guid) {
    
        if (PlayerService.playerlist.contains(guid)) {
            return PlayerService.playerlist.get(guid).getName();
        }
        return "";
    }
    
    /**
     * Gets the player.
     * 
     * @param guid
     *            the guid
     * @return the player
     */
    public static Player getPlayer(final long guid) {
    
        if (PlayerService.playerlist.contains(guid)) {
            return PlayerService.playerlist.get(guid);
        }
        return null;
    }
    
}
