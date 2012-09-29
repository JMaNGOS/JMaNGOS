/**
 * 
 */
package org.jmangos.commons.dataholder;

import java.util.Collection;

import javolution.util.FastMap;

import org.jmangos.commons.model.ManagedObject;

import com.google.common.collect.ImmutableList;

/**
 * @author MinimaJack
 * 
 */
public abstract class IdKeyContainer<T extends ManagedObject> implements Visitable<T> {
    
    private FastMap<Long, T> data = new FastMap<Long, T>().shared();
    
    public T getObject(int objectId) {
    
        return data.get(objectId);
    }
    
    public int size() {
    
        return data.size();
    }
    
    public void addObject(T object) {
    
        if (data.containsKey(object.getObjectId())) {
            onDataAlreadyAddedEvent(object.getObjectId());
            return;
        }
        data.put(object.getObjectId(), object);
    }
    
    public boolean containsObject(final int objectId) {
    
        return data.containsKey(objectId);
    }
    
    @Override
    public void iterate(Visitor<T> visitor) {
    
        for (T value : data.values()) {
            visitor.visit(value);
        }
    }
    
    public void removeObject(T object) {
    
        if (!data.containsKey(object.getObjectId())) {
            onDataNotPresentEvent(object.getObjectId());
            return;
        }
        data.remove(object.getObjectId());
    }
    
    public Collection<T> values() {
    
        return ImmutableList.copyOf(data.values());
    }
    
    public void clearData() {
    
        data.clear();
        
    }
    
    public abstract void onDataNotPresentEvent(long objectId);
    
    public abstract void onDataAlreadyAddedEvent(long objectId);
}
