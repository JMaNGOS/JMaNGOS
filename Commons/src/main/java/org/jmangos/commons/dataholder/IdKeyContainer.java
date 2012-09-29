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
    
    private final FastMap<Long, T> data = new FastMap<Long, T>().shared();
    
    public T getObject(final int objectId) {
    
        return this.data.get(objectId);
    }
    
    public int size() {
    
        return this.data.size();
    }
    
    public void addObject(final T object) {
    
        if (this.data.containsKey(object.getObjectId())) {
            onDataAlreadyAddedEvent(object.getObjectId());
            return;
        }
        this.data.put(object.getObjectId(), object);
    }
    
    public boolean containsObject(final int objectId) {
    
        return this.data.containsKey(objectId);
    }
    
    @Override
    public void iterate(final Visitor<T> visitor) {
    
        for (final T value : this.data.values()) {
            visitor.visit(value);
        }
    }
    
    public void removeObject(final T object) {
    
        if (!this.data.containsKey(object.getObjectId())) {
            onDataNotPresentEvent(object.getObjectId());
            return;
        }
        this.data.remove(object.getObjectId());
    }
    
    public Collection<T> values() {
    
        return ImmutableList.copyOf(this.data.values());
    }
    
    public void clearData() {
    
        this.data.clear();
        
    }
    
    public abstract void onDataNotPresentEvent(long objectId);
    
    public abstract void onDataAlreadyAddedEvent(long objectId);
}
