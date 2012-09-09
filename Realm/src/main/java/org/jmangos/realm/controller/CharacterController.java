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
package org.jmangos.realm.controller;

import java.util.List;

import javax.inject.Inject;

import org.criteria4jpa.criterion.Criterion;
import org.criteria4jpa.criterion.Restrictions;
import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.realm.domain.InventoryItem;
import org.jmangos.realm.domain.PlayerHomeBindData;
import org.jmangos.realm.domain.PlayercreateinfoPK;
import org.jmangos.realm.entities.CharacterEntity;
import org.jmangos.realm.entities.ItemEntity;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Races;
import org.jmangos.realm.network.packet.wow.server.SMSG_CHAR_CREATE;
import org.jmangos.realm.services.CharacterService;
import org.jmangos.realm.services.ItemService;
import org.jmangos.world.entities.Playercreateinfo;
import org.jmangos.world.services.CharStartOutfitService;
import org.jmangos.world.services.PlayercreateinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterController {
    
    /** The Constant logger. */
    private static final Logger     logger = LoggerFactory.getLogger(CharacterController.class);
    
    @Inject
    private CharacterService        characterService;
    
    @Inject
    private PlayercreateinfoService playercreateinfoService;
    
    @Autowired
    private CharStartOutfitService  charStartOutfitService;
    
    @Autowired
    ItemService                     itemService;
    
    public SMSG_CHAR_CREATE createCharacter(final int accountId, final String charName, final int charRace, final int charClass, final int gender,
            final int skin, final int face, final int hairStyle, final int hairColor, final int facialHair, final int outfitId) {
    
        final Criterion criterion = Restrictions.eq("name", charName);
        final List<CharacterEntity> characters = this.characterService.readCharacters(criterion);
        if ((characters != null) && !characters.isEmpty()) {
            CharacterController.logger.warn("Username already exists: " + charName);
            return new SMSG_CHAR_CREATE(SMSG_CHAR_CREATE.Code.NAME_IN_USE);
        }
        
        final Playercreateinfo info = this.playercreateinfoService.readPlayercreateinfo(new PlayercreateinfoPK(charClass, charRace));
        if (info == null) {
            logger.error("Player create template not found for: " + Classes.get(charClass) + " " + Races.get(charRace));
            return new SMSG_CHAR_CREATE(SMSG_CHAR_CREATE.Code.ERROR);
        }
        
        final CharacterEntity charData = new CharacterEntity();
        // Set account id
        charData.setAccount(accountId);
        
        // Set name
        charData.setName(charName);
        
        // Set Class/Race/Gender
        charData.setClazz(charClass);
        charData.setRace(charRace);
        charData.setGender(gender);
        
        // Set spawn coord
        charData.setMap(info.getMap());
        charData.setZone(info.getZone());
        charData.setPositionX(info.getPositionX());
        charData.setPositionY(info.getPositionY());
        charData.setPositionZ(info.getPositionZ());
        charData.setOrientation(info.getOrientation());
        
        // Skin, Face, Hair(style,color)
        charData.setPlayerBytes(skin | (face << 8) | (hairStyle << 16) | (hairColor << 24));
        
        // Hair(facial), Bankslot
        charData.setPlayerBytes2((facialHair /* | (0xEE << 8) */| (0x02 << 24)));
        
        charData.setExploredZones(Integer.toString(info.getZone()));
        charData.setKnownTitles("0");
        
        // TODO: make a config to create some inital value
        charData.setMoney(0);
        charData.setLevel(1);
        charData.setXp(0);
        
        // First login
        charData.setAtLoginFlags(0x1);
        
        // Set home (hs) location
        final PlayerHomeBindData phbd = new PlayerHomeBindData();
        phbd.setHomeBindAreaId(charData.getZone());
        phbd.setHomeBindMapId(charData.getMap());
        phbd.setHomeBindPositionX(charData.getPositionX());
        phbd.setHomeBindPositionY(charData.getPositionY());
        phbd.setHomeBindPositionZ(charData.getPositionZ());
        
        charData.setHomeBindData(phbd);
        
        this.characterService.createOrUpdateCharacter(charData);
        
        final List<CharStartOutfitEntity> startItems = this.charStartOutfitService.readCharStartOutfitEntities(Races.get(charRace), Classes.get(charClass), (byte) gender);
        for (final CharStartOutfitEntity startItem : startItems) {
            final ItemEntity itemEntity = new ItemEntity();
            itemEntity.setOwner(charData);
            itemEntity.setProto(startItem.getProtoId());
            
            this.itemService.createOrUpdateItem(itemEntity);
            
            final InventoryItem inventoryItem = new InventoryItem();
            inventoryItem.setItem(itemEntity);
            inventoryItem.setSlot(startItem.getSlot());
            inventoryItem.setOwnerCharacter(charData);
            charData.getInventory().put(startItem.getSlot(), inventoryItem);
            logger.info("Adding item for character: " + startItem.getProtoId());
        }
        
        this.characterService.createOrUpdateCharacter(charData);
        
        return new SMSG_CHAR_CREATE(SMSG_CHAR_CREATE.Code.SUCCESS);
    }
    
}
