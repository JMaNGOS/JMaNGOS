package org.jmangos.realm.model;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.09.
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public enum TypeID {
    OBJECT(0),
    ITEM(1),
    CONTAINER(2),
    UNIT(3),
    PLAYER(4),
    GAMEOBJECT(5),
    DYNAMICOBJECT(6),
    CORPSE(7),
    AIGROUP(8),
    AREATRIGGER(9);

    private int value;

    TypeID(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
