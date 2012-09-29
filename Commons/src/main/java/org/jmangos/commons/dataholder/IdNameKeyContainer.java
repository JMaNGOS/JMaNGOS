package org.jmangos.commons.dataholder;

import javolution.util.FastMap;

import org.jmangos.commons.model.NamedObject;

public abstract class IdNameKeyContainer<T extends NamedObject> extends IdKeyContainer<T> {
    
    /** name-data relations */
    private final FastMap<String, T> namedData = new FastMap<String, T>().shared();
    
    public T getNamedObject(final String name) {
    
        return this.namedData.get(name);
    }
    
    @Override
    public void addObject(final T object) {
    
        super.addObject(object);
        if (this.namedData.containsKey(object.getName())) {
            onDataAlreadyAddedEvent(object.getObjectId());
            return;
        }
        this.namedData.put(object.getName(), object);
    }
    
    @Override
    public void removeObject(final T object) {
    
        super.removeObject(object);
        if (!this.namedData.containsKey(object.getName())) {
            onDataNotPresentEvent(object.getObjectId());
            return;
        }
        this.namedData.remove(object.getName());
    }
    
    @Override
    public void clearData() {
    
        super.clearData();
        this.namedData.clear();
    }
}
