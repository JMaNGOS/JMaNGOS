package org.jmangos.realm.model.base;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * email: paalgyula@gmail.com
 * Date: 2012.08.11.
 * Time: 21:10
 */
@Entity
public class Playercreateinfo {
    @EmbeddedId
    PlayercreateinfoPK playercreateinfoPK;

    @Basic
	@Column(name = "map", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
	private short map;


    @Basic
	@Column(name = "zone", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
	private int zone;


    @Basic
	@Column(name = "position_x", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
	private float positionX;


    @Basic
	@Column(name = "position_y", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
	private float positionY;


    @Basic
	@Column(name = "position_z", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
	private float positionZ;


    @Basic
	@Column(name = "orientation", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
	private float orientation;

    public Playercreateinfo() {
    }

    public PlayercreateinfoPK getPlayercreateinfoPK() {
        return playercreateinfoPK;
    }

    public void setPlayercreateinfoPK(PlayercreateinfoPK playercreateinfoPK) {
        this.playercreateinfoPK = playercreateinfoPK;
    }

    public short getMap() {
        return map;
    }

    public void setMap(short map) {
        this.map = map;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(float positionZ) {
        this.positionZ = positionZ;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }
}
