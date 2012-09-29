package org.jmangos.realm.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.jboss.netty.buffer.ChannelBuffer;

@Embeddable
public class Position implements Cloneable {
    
    @Column(name = "position_x", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private float x;
    
    @Column(name = "position_y", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private float y;
    
    @Column(name = "position_z", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private float z;
    
    @Column(name = "orientation", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private float o;
    
    public Position() {
    
    }
    
    /**
     * @return the x
     */
    public final float getX() {
    
        return this.x;
    }
    
    /**
     * @param x
     *            the x to set
     */
    public final void setX(final float x) {
    
        this.x = x;
    }
    
    /**
     * @return the y
     */
    public final float getY() {
    
        return this.y;
    }
    
    /**
     * @param y
     *            the y to set
     */
    public final void setY(final float y) {
    
        this.y = y;
    }
    
    /**
     * @return the z
     */
    public final float getZ() {
    
        return this.z;
    }
    
    /**
     * @param z
     *            the z to set
     */
    public final void setZ(final float z) {
    
        this.z = z;
    }
    
    /**
     * @return the o
     */
    public final float getO() {
    
        return this.o;
    }
    
    /**
     * @param o
     *            the o to set
     */
    public final void setO(final float o) {
    
        this.o = o;
    }
    
    @Override
    public String toString() {
    
        return "[Position] x:" + this.x + " y:" + this.y + " z:" + this.z;
    }
    
    @Override
    public Position clone() {
    
        Position newPos = new Position();
        newPos.setX(getX());
        newPos.setY(getY());
        newPos.setZ(getZ());
        newPos.setO(getO());
        return newPos;
    }
    
    public void writeTo(final ChannelBuffer bb) {
    
        bb.writeFloat(getX());
        bb.writeFloat(getY());
        bb.writeFloat(getZ());
        bb.writeFloat(getO());
        
    }
}
