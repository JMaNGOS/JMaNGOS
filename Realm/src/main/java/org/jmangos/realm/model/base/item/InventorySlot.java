package org.jmangos.realm.model.base.item;

/**
 * Created with IntelliJ IDEA.
 * User: Adrian
 * Date: 2012.08.11.
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */
public enum InventorySlot {
     INVENTORY_SLOT_BAG_START(19),
     INVENTORY_SLOT_BAG_1(19),
     INVENTORY_SLOT_BAG_2(20),
     INVENTORY_SLOT_BAG_3(21),
     INVENTORY_SLOT_BAG_4(22),
     INVENTORY_SLOT_BAG_END(23),
     INVENTORY_SLOT_ITEM_START(23),
     INVENTORY_SLOT_ITEM_1(23),
     INVENTORY_SLOT_ITEM_2(24),
     INVENTORY_SLOT_ITEM_3(25),
     INVENTORY_SLOT_ITEM_4(26),
     INVENTORY_SLOT_ITEM_5(27),
     INVENTORY_SLOT_ITEM_6(28),
     INVENTORY_SLOT_ITEM_7(29),
     INVENTORY_SLOT_ITEM_8(30),
     INVENTORY_SLOT_ITEM_9(31),
     INVENTORY_SLOT_ITEM_10(32),
     INVENTORY_SLOT_ITEM_11(33),
     INVENTORY_SLOT_ITEM_12(34),
     INVENTORY_SLOT_ITEM_13(35),
     INVENTORY_SLOT_ITEM_14(36),
     INVENTORY_SLOT_ITEM_15(37),
     INVENTORY_SLOT_ITEM_16(38),
     INVENTORY_SLOT_ITEM_END(39);

    private int value;
    private EquipmentSlot(int value) {
        this.value = value;
    }
}
