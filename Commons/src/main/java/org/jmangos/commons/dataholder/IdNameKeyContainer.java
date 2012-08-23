package org.jmangos.commons.dataholder;

import javolution.util.FastMap;

import org.jmangos.commons.model.NamedObject;

public abstract class IdNameKeyContainer<T extends NamedObject> extends IdKeyContainer<T> {
    
    /** name-data relations */
    private FastMap<String, T> namedData = new FastMap<String, T>().shared();
    
    public T getNamedObject(String name) {
    
        return namedData.get(name);
    }
    
    @Override
    public void addObject(T object) {
    
        super.addObject(object);
        if (namedData.containsKey(object.getName())) {
            onDataAlreadyAddedEvent(object.getObjectId());
            return;
        }
        namedData.put(object.getName(), object);
    }
    
    @Override
    public void removeObject(T object) {
    
        super.removeObject(object);
        if (!namedData.containsKey(object.getName())) {
            onDataNotPresentEvent(object.getObjectId());
            return;
        }
        namedData.remove(object.getName());
    }
    
    @Override
    public void clearData() {
    
        super.clearData();
        namedData.clear();
    }
}
