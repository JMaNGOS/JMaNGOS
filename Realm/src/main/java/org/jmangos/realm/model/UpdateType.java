package org.jmangos.realm.model;

import org.jmangos.commons.network.model.UpdateField;
import org.jmangos.commons.network.model.UpdateFieldType;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.09.
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
public enum UpdateType implements UpdateField {
    VALUES( 0x00 ),
    MOVEMENT( 0x01 ),
    CREATE_OBJECT( 0x02 ),
    CREATE_SELF( 0x03 ),
    OUT_OF_RANGE_OBJECTS( 0x04 ),
    NEAR_OBJECTS( 0x05 );

    private int value;
    UpdateType( int value ) {
        this.value = value;
    }

    @Override
    public UpdateFieldType getType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getSize() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getValue() {
        return this.value;
    }

    public static UpdateField get( int value ) {
        for( UpdateField pf : values() ) {
            if ( pf.getValue() == value )
                return pf;
        }
        // Not found :O
        return null;
    }
}
