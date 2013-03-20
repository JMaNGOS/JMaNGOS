package org.jmangos.commons.model.base.update;

import org.jmangos.commons.network.model.UpdateField;

/**
 * Created with IntelliJ IDEA. User: paalgyula E-Mail: paalgyula@gmail.com Date:
 * 2012.08.14. Time:
 * 11:36
 */
public class UpdateFieldUtils {

    public static UpdateField getField(final int code) {

        if (code < ObjectFields.OBJECT_END) {
            return ObjectFields.get(code);
        } else if (code < UnitField.UNIT_END) {
            return UnitField.get(code);
        } else if (code < PlayerFields.PLAYER_END) {
            return PlayerFields.get(code);
        } else {
            return null;
        }
    }
}
