package org.jmangos.realm.model.player;

import org.jmangos.realm.dbc.struct.CharStartOutfitEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.12.
 * Time: 15:47
 */
public class CharacterStartOutfit {

    static class ItemSlot {
        int displayId;
        int itemId;
        int inventorySlot;

        ItemSlot(int displayId, int itemId, int inventorySlot) {
            this.displayId = displayId;
            this.itemId = itemId;
            this.inventorySlot = inventorySlot;
        }

        public int getDisplayId() {
            return displayId;
        }

        public void setDisplayId(int displayId) {
            this.displayId = displayId;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public int getInventorySlot() {
            return inventorySlot;
        }

        public void setInventorySlot(int inventorySlot) {
            this.inventorySlot = inventorySlot;
        }
    }

    public int id;
    public int clazz;
    public int race;
    public int gender;

    List<ItemSlot> items = new ArrayList<ItemSlot>();

    public CharacterStartOutfit(CharStartOutfitEntry entry) {
        this.id = Integer.parseInt( entry.id.toString() );
        this.clazz = Integer.parseInt(entry.clazz.toString());
        this.gender = Integer.parseInt(entry.gender.toString());
        this.race = Integer.parseInt( entry.race.toString() );

        try {
            for( int i=0; i < entry.ItemDisplayId.length; i++ ) {
                items.add(new ItemSlot(
                        Integer.parseInt(entry.ItemDisplayId[i].toString()),
                        Integer.parseInt(entry.ItemId[i].toString()),
                        Integer.parseInt(entry.ItemInventorySlot[i].toString())
                ));
            }
        } catch (IndexOutOfBoundsException e) {/* that's all :) */}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<ItemSlot> getItems() {
        return items;
    }

    public void setItems(List<ItemSlot> items) {
        this.items = items;
    }
}
