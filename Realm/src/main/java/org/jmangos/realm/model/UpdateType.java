package org.jmangos.realm.model;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.09.
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
public enum UpdateType {
    VALUES( 0x00 ),
    MOVEMENT( 0x01 ),
    CREATE_OBJECT( 0x02 ),
    CREATE_OBJECT_2( 0x03 ),
    OUT_OF_RANGE_OBJECTS( 0x04 ),
    UPDATETYPE_NEAR_OBJECTS( 0x05 );

    private int value;
    UpdateType( int value ) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
