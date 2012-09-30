package org.jmangos.tools.dbcconverter.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.jmangos.tools.dbc.dataholder.DBCDataLoader;
import org.jmangos.tools.dbc.dataholder.DBCStruct;

public abstract class AbstractDbcService<T1, T2 extends DBCStruct<T2>> {

    private Class<T2> entryClass;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public AbstractDbcService() {

        this.entryClass = null;
        final Class<? extends AbstractDbcService> c = getClass();
        final Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            final Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entryClass = (Class<T2>) p[1];
        }
    }

    protected T2 getEntry() {

        return DBCDataLoader.loadStaticData(this.entryClass, getDbcPath());
    }

    public abstract void save(T1 t);

    public abstract void saveAll();

    public abstract String getDbcPath();

}
