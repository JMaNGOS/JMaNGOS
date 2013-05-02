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
package org.jmangos.realm.service;

import gnu.trove.map.hash.TLongObjectHashMap;

import org.jmangos.commons.controller.CharacterController;
import org.jmangos.commons.enums.ActionButtonMessageType;
import org.jmangos.commons.model.UpdateBlock;
import org.jmangos.commons.model.player.Player;
import org.jmangos.commons.network.model.NettyNetworkChannel;
import org.jmangos.commons.network.sender.AbstractPacketSender;
import org.jmangos.realm.RealmServer;
import org.jmangos.realm.network.packet.wow.server.*;
import org.jmangos.realm.services.CharacterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Class PlayerService.
 */
@Component
public class PlayerService {

    /**
     * The Constant log.
     */
    private static final Logger log = LoggerFactory.getLogger(PlayerService.class);

    /**
     * The sender.
     */
    @Autowired
    @Qualifier("nettyPacketSender")
    private AbstractPacketSender sender;

    @Autowired
    private CharacterService characterService;

    /**
     * The player class level info storages.
     */
    @Autowired
    private PlayerClassLevelInfoStorages playerClassLevelInfoStorages;

    /**
     * The player level storages.
     */
    @Autowired
    private PlayerLevelStorages playerLevelStorages;

    /**
     * The simple storages.
     */
    @Autowired
    private PlayerXpForLevelStorages playerXpForLevelStorages;

    /**
     * The item storages.
     */
    @Autowired
    private ItemStorages itemStorages;

    @Autowired
    private CharacterController characterController;

    @Autowired
    private MapService mapService;

    /**
     * The playerlist.
     */
    private static TLongObjectHashMap<Player> playerlist = new TLongObjectHashMap<Player>();

    /**
     * Prepare player.
     *
     * @param chanel the chanel
     * @param guid   the guid
     * @return the player
     */
    public Player preparePlayer(final NettyNetworkChannel chanel, final long guid) {

        final Player player = new Player(this.characterController.loadCharacterByGuid(guid));
        player.setChannel(chanel);
        chanel.setActiveObject(player);
        return player;
    }

    /**
     * Send inicial packets.
     *
     * @param player the player
     * @return the world object
     */
    public Player sendInicialPackets(final Player player) {

        // this.sender.send(player.getChannel(), new SMSG_POWER_UPDATE());

        this.sender.send(player.getChannel(), new MSG_SET_DUNGEON_DIFFICULTY());
        this.sender.send(player.getChannel(), new SMSG_INSTANCE_DIFFICULTY());

        this.sender.send(player.getChannel(), new SMSG_LOGIN_VERIFY_WORLD(player));
        // TODO: Reimplement (not needed to log in!)

        this.sender.send(player.getChannel(), new SMSG_ACCOUNT_DATA_TIMES(
                SMSG_ACCOUNT_DATA_TIMES.GLOBAL_CACHE_MASK, null));
        this.sender.send(player.getChannel(), new SMSG_FEATURE_SYSTEM_STATUS());
        // this.sender.send(player.getChannel(), new
        // SMSG_FEATURE_SYSTEM_STATUS());
        // sender.send(player.getChannel(), new SMSG_LEARNED_DANCE_MOVES());
        this.sender.send(player.getChannel(), new SMSG_BINDPOINTUPDATE(player));
        this.sender.send(player.getChannel(), new SMSG_MOTD("Test MotD String@test".split("@")));
        if (player.getCharacterData().getAtLoginFlag() == 1) {
            player.getCharacterData().setAtLoginFlag(0);
            this.sender.send(player.getChannel(), new SMSG_TRIGGER_CINEMATIC(player));
        }
        // this.sender.send(player.getChannel(), new SMSG_TALENTS_INFO());
        this.sender.send(player.getChannel(), new SMSG_INITIAL_SPELLS(player));
        this.sender.send(player.getChannel(), new SMSG_ACTION_BUTTONS(player,
                ActionButtonMessageType.INICIAL));
        this.sender.send(player.getChannel(), new SMSG_INITIALIZE_FACTIONS(player));

        // this.sender.send(player.getChannel(), new
        // SMSG_INIT_WORLD_STATES(player));
        // this.sender.send(player.getChannel(), new SMSG_EQUIPMENT_SET_LIST());
        // this.sender.send(player.getChannel(), new
        // SMSG_ALL_ACHIEVEMENT_DATA());
        this.sender.send(player.getChannel(), new SMSG_LOGIN_SETTIMESPEED());

        this.mapService.getMap(player.getCharacterData().getMovement().getMap()).addObject(
                player.getCharacterData());
        // this.sender.send(player.getChannel(), new
        // SMSG_INIT_WORLD_STATES(player));
        // this.sender.send(player.getChannel(), new SMSG_SPELL_GO());
        // this.sender.send(player.getChannel(), new SMSG_PLAYED_TIME());

        final UpdateBlock update = new UpdateBlock();
        player.getCharacterData().buildCreateBlock(update, player.getCharacterData());
        log.info(update.toString());
        final SMSG_UPDATE_OBJECT updatePacket = new SMSG_UPDATE_OBJECT(update.buildAll());
        this.sender.send(player.getChannel(), updatePacket);

        this.sender.send(player.getChannel(), new SMSG_TIME_SYNC_REQ());

        this.sender.send(player.getChannel(), new SMSG_ACCOUNT_DATA_TIMES(
                SMSG_ACCOUNT_DATA_TIMES.PER_CHARACTER_CACHE_MASK, null));

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

        this.characterService.createOrUpdateCharacter(player.getCharacterData());
    }

    /**
     * Load home bind.
     *
     * @param player the player
     * @return true, if successful
     */
    public boolean loadHomeBind(final Player player) {

        return false;

        // final CharacterEntity characterEntity =
        // this.characterService.readCharacter(player.getObjectId());
        // return player.setHomeBind(characterEntity.getHomeBindData());
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
     * @param playerlist the new playerlist
     */
    public static void setPlayerlist(final TLongObjectHashMap<Player> playerlist) {

        PlayerService.playerlist = playerlist;
    }

    /**
     * Gets the player name.
     *
     * @param guid the guid
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
     * @param guid the guid
     * @return the player
     */
    public static Player getPlayer(final long guid) {

        if (PlayerService.playerlist.contains(guid)) {
            return PlayerService.playerlist.get(guid);
        }
        return null;
    }

}
