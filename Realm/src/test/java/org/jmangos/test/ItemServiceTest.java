package org.jmangos.test;

import java.util.List;
import java.util.Map.Entry;

import junit.framework.TestCase;

import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.realm.domain.InventoryItem;
import org.jmangos.realm.entities.CharacterEntity;
import org.jmangos.realm.entities.ItemEntity;
import org.jmangos.realm.model.enums.Classes;
import org.jmangos.realm.model.enums.Races;
import org.jmangos.realm.service.ItemStorages;
import org.jmangos.realm.services.CharacterService;
import org.jmangos.realm.services.ItemService;
import org.jmangos.world.services.CharStartOutfitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/applicationContext.xml" })
public class ItemServiceTest extends TestCase {
    
    @Autowired
    ItemService            itemService;
    @Autowired
    CharStartOutfitService charStartOutfitService;
    
    @Autowired
    CharacterService       characterService;
    
    @Autowired
    ItemStorages           itemStorages;
    
    Classes                charClass = Classes.WARRIOR;
    Races                  charRace  = Races.HUMAN;
    Byte                   gender    = 1;
    
    @Test
    @Transactional(value = "realm")
    @Rollback(false)
    public void testPlayerCreateInfoService() throws Exception {
    
        try {
            final CharacterEntity charData = new CharacterEntity();
            // Set account id
            charData.setAccount(1);
            
            // Set name
            charData.setName("test");
            
            // Set Class/Race/Gender
            charData.setClazz(this.charClass.getValue());
            charData.setRace(this.charRace.getValue());
            charData.setGender(this.gender);
            
            this.characterService.createOrUpdateCharacter(charData);
            
            final List<CharStartOutfitEntity> startItems = this.charStartOutfitService.readCharStartOutfitEntities(this.charRace, this.charClass, this.gender);
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
            }
            
            this.characterService.createOrUpdateCharacter(charData);
        } catch (final Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        
    }
    
    @Test
    @Transactional(value = "realm")
    public void testCreatedPlayerCreateInfoService() throws Exception {
    
        final CharacterEntity charData = this.characterService.readCharacter(1);
        for (final Entry<Integer, InventoryItem> invent : charData.getInventory().entrySet()) {
            System.out.println(invent.getValue().getSlot());
            System.out.println(invent.getValue().getItem().getProto());
            
        }
        
    }
}
