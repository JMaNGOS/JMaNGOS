/**
 * 
 */
package org.jmangos.tools.dbcconverter.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javolution.io.Struct.Signed32;

import org.jmangos.commons.entities.CharStartOutfitEntity;
import org.jmangos.commons.entities.pk.CharStartOutfitEntityPk;
import org.jmangos.commons.enums.Classes;
import org.jmangos.commons.enums.EquipmentSlots;
import org.jmangos.commons.enums.Gender;
import org.jmangos.commons.enums.InventoryType;
import org.jmangos.commons.enums.Races;
import org.jmangos.tools.dbc.struct.CharStartOutfitEntry;
import org.jmangos.tools.dbcconverter.service.AbstractDbcService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author MinimaJack
 * 
 */
@Service
@Qualifier(value = "charOutfitService")
public class CharOutfitService
        extends AbstractDbcService<CharStartOutfitEntity, CharStartOutfitEntry> {

    CharOutfitService() {

        super();
    }

    @PersistenceContext(unitName = "world")
    private EntityManager entityManager;

    @Override
    public void save(final CharStartOutfitEntity charStartOutfitEntity) {

        if (charStartOutfitEntity.getCharStartOutfitEntityPk() == null) {
            this.entityManager.persist(charStartOutfitEntity);
        } else {
            this.entityManager.merge(charStartOutfitEntity);
        }

    }

    @Override
    public void saveAll() {

        CharStartOutfitEntry entry = getEntry();
        Classes[] classes = Classes.values();
        Races[] rases = Races.values();
        Gender[] genders = Gender.values();
        do {
            int numbItem = 0;
            int startedFreeSlot = 23;
            for (final Signed32 itemDisplayId : entry.ItemDisplayId) {
                if (itemDisplayId.get() > 0) {
                    final CharStartOutfitEntity tf = new CharStartOutfitEntity();
                    final CharStartOutfitEntityPk pk = new CharStartOutfitEntityPk();
                    pk.setClazz(classes[entry.clazz.get()]);
                    pk.setGender(genders[entry.gender.get()]);
                    pk.setRace(rases[entry.race.get()]);
                    final EquipmentSlots slot =
                            findEquipSlot(InventoryType.get(entry.ItemInventorySlot[numbItem].get()));
                    if (slot == null) {
                        tf.setSlot(startedFreeSlot);
                        startedFreeSlot++;
                    } else {
                        tf.setSlot(slot.ordinal());
                    }

                    tf.setProtoId(entry.protoId[numbItem].get());
                    tf.setCharStartOutfitEntityPk(pk);
                    this.entityManager.merge(tf);
                }
                numbItem++;
            }

        } while ((entry = entry.next()) != null);

    }

    @Override
    public String getDbcPath() {

        return "./../realm/dbc/Charstartoutfit.dbc";
    }

    public static EquipmentSlots findEquipSlot(final InventoryType inventoryType) {

        switch (inventoryType) {
            case HEAD:
                return EquipmentSlots.HEAD;
            case SHOULDERS:
                return EquipmentSlots.SHOULDERS;
            case BODY:
                return EquipmentSlots.BODY;
            case CHEST:
                return EquipmentSlots.CHEST;
            case ROBE:
                return EquipmentSlots.CHEST;
            case WAIST:
                return EquipmentSlots.WAIST;
            case LEGS:
                return EquipmentSlots.LEGS;
            case FEET:
                return EquipmentSlots.FEET;
            case WRISTS:
                return EquipmentSlots.WRISTS;
            case HANDS:
                return EquipmentSlots.HANDS;
            case CLOAK:
                return EquipmentSlots.BACK;
            case WEAPON:
                return EquipmentSlots.MAINHAND;
            case SHIELD:
                return EquipmentSlots.OFFHAND;
            case RANGED:
                return EquipmentSlots.RANGED;
            case TWOHWEAPON:
                return EquipmentSlots.MAINHAND;
            case TABARD:
                return EquipmentSlots.TABARD;
            case WEAPONMAINHAND:
                return EquipmentSlots.MAINHAND;
            case WEAPONOFFHAND:
                return EquipmentSlots.OFFHAND;
            case HOLDABLE:
                return EquipmentSlots.OFFHAND;
            case THROWN:
                return EquipmentSlots.RANGED;
            case RANGEDRIGHT:
                return EquipmentSlots.RANGED;
            case BAG:
                return EquipmentSlots.BAG1;
            default:
                return null;
        }
    }
}
