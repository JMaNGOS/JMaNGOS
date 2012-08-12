package org.jmangos.realm.model.base.update;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.13.
 * Time: 0:05
 */
public interface UpdateField {
    UpdateFieldType getType();
    int getSize();
    int getValue();
}
