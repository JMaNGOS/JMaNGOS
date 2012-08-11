package org.jmangos.realm.model.base.item;

/**
 * Created with IntelliJ IDEA.
 * User: Adrian
 * Date: 2012.08.11.
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public enum EquipmentSlot {
    EQUIPMENT_SLOT_START(0),
    EQUIPMENT_SLOT_HEAD	(0),
    EQUIPMENT_SLOT_NECK	(1),
    EQUIPMENT_SLOT_SHOULDERS(2),
    EQUIPMENT_SLOT_BODY(3),
    EQUIPMENT_SLOT_CHEST(4),
    EQUIPMENT_SLOT_WAIST(5),
    EQUIPMENT_SLOT_LEGS(6),
    EQUIPMENT_SLOT_FEET(7),
    EQUIPMENT_SLOT_WRISTS(8),
    EQUIPMENT_SLOT_HANDS(9),
    EQUIPMENT_SLOT_FINGER1(10),
    EQUIPMENT_SLOT_FINGER2(11),
    EQUIPMENT_SLOT_TRINKET1(12),
    EQUIPMENT_SLOT_TRINKET2(13),
    EQUIPMENT_SLOT_BACK(14),
    EQUIPMENT_SLOT_MAINHAND(15),
    EQUIPMENT_SLOT_OFFHAND(16),
    EQUIPMENT_SLOT_RANGED(17),
    EQUIPMENT_SLOT_TABARD(18),
    EQUIPMENT_SLOT_END(19);

    private int value;
    private EquipmentSlot(int value) {
        this.value = value;
    }
}
