package org.jmangos.realm.model.player;

import java.util.ArrayList;
import java.util.List;

import org.jmangos.realm.dbc.struct.CharStartOutfitEntry;

/**
 * Created with IntelliJ IDEA. User: paalgyula email: paalgyula@gmail.com Date: 2012.08.12. Time:
 * 15:47
 */
public class CharacterStartOutfit {
    
    public static class ItemSlot {
        
        int displayId;
        int itemId;
        int inventorySlot;
        
        ItemSlot(final int displayId, final int itemId, final int inventorySlot) {
        
            this.displayId = displayId;
            this.itemId = itemId;
            this.inventorySlot = inventorySlot;
        }
        
        public int getDisplayId() {
        
            return this.displayId;
        }
        
        public void setDisplayId(final int displayId) {
        
            this.displayId = displayId;
        }
        
        public int getItemId() {
        
            return this.itemId;
        }
        
        public void setItemId(final int itemId) {
        
            this.itemId = itemId;
        }
        
        public int getInventorySlot() {
        
            return this.inventorySlot;
        }
        
        public void setInventorySlot(final int inventorySlot) {
        
            this.inventorySlot = inventorySlot;
        }
    }
    
    public int     id;
    public int     clazz;
    public int     race;
    public int     gender;
    
    List<ItemSlot> items = new ArrayList<ItemSlot>();
    
    public CharacterStartOutfit(final CharStartOutfitEntry entry) {
    
        this.id = Integer.parseInt(entry.id.toString());
        this.clazz = Integer.parseInt(entry.clazz.toString());
        this.gender = Integer.parseInt(entry.gender.toString());
        this.race = Integer.parseInt(entry.race.toString());
        
        try {
            for (int i = 0; i < entry.ItemDisplayId.length; i++) {
                // Don't add -1 to memory...
                if (Integer.parseInt(entry.ItemDisplayId[i].toString()) != -1) {
                    this.items.add(new ItemSlot(Integer.parseInt(entry.ItemDisplayId[i].toString()), Integer.parseInt(entry.ItemId[i].toString()), Integer.parseInt(entry.ItemInventorySlot[i].toString())));
                }
            }
        } catch (final IndexOutOfBoundsException e) {/* that's all :) */
        }
    }
    
    public int getId() {
    
        return this.id;
    }
    
    public void setId(final int id) {
    
        this.id = id;
    }
    
    public int getClazz() {
    
        return this.clazz;
    }
    
    public void setClazz(final int clazz) {
    
        this.clazz = clazz;
    }
    
    public int getRace() {
    
        return this.race;
    }
    
    public void setRace(final int race) {
    
        this.race = race;
    }
    
    public int getGender() {
    
        return this.gender;
    }
    
    public void setGender(final int gender) {
    
        this.gender = gender;
    }
    
    public List<ItemSlot> getItems() {
    
        return this.items;
    }
    
    public void setItems(final List<ItemSlot> items) {
    
        this.items = items;
    }
}
