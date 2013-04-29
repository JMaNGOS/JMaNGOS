package org.jmangos.commons.model.base;

import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.map.hash.TLongObjectHashMap;
import gnu.trove.procedure.TObjectProcedure;

import org.jmangos.commons.entities.FieldsObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NestedMap {

    Logger log = LoggerFactory.getLogger(NestedMap.class);
    /** The id. */
    private int id = 0;
    /** The player list. */
    protected TLongObjectHashMap<FieldsObject> playerList = new TLongObjectHashMap<FieldsObject>();
    /** The units. */
    protected TLongObjectHashMap<FieldsObject> units = new TLongObjectHashMap<FieldsObject>();
    private TIntObjectHashMap<NestedMap> subMap = new TIntObjectHashMap<NestedMap>();
    private String name;
    private NestedMap parentArea;

    public NestedMap() {
        super();
    }

    public boolean addNestedMap(final NestedMap newsubArea) {
        if (newsubArea.getParentArea().getId() == getId()) {
            getSubArea().put(newsubArea.getId(), newsubArea);
            return false;
        } else {
            getSubArea().forEachValue(new TObjectProcedure<NestedMap>() {

                @Override
                public boolean execute(final NestedMap object) {
                    return object.addNestedMap(newsubArea);
                }
            });

        }
        return true;
    }

    public NestedMap getRootMap() {
        if (this.parentArea != null) {
            return this.parentArea.getRootMap();
        } else {
            return this;
        }
    }

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     *        the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the playerList
     */
    public TLongObjectHashMap<FieldsObject> getPlayerList() {
        return this.playerList;
    }

    /**
     * @param playerList
     *        the playerList to set
     */
    public void setPlayerList(final TLongObjectHashMap<FieldsObject> playerList) {
        this.playerList = playerList;
    }

    /**
     * @return the units
     */
    public TLongObjectHashMap<FieldsObject> getUnits() {
        return this.units;
    }

    /**
     * @param units
     *        the units to set
     */
    public void setUnits(final TLongObjectHashMap<FieldsObject> units) {
        this.units = units;
    }

    /**
     * @return the subArea
     */
    public TIntObjectHashMap<NestedMap> getSubArea() {
        return this.subMap;
    }

    /**
     * @param subArea
     *        the subArea to set
     */
    public void setSubArea(final TIntObjectHashMap<NestedMap> subArea) {
        this.subMap = subArea;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *        the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Adds the object.
     * 
     * @param plObject
     *        the pl object
     */
    public abstract void addObject(final FieldsObject plObject);

    /**
     * Adds the object.
     * 
     * @param plObject
     *        the pl object
     */
    public void removeObject(final FieldsObject plObject) {

        switch (plObject.getTypeId()) {
            case PLAYER:
                this.playerList.remove(plObject.getGuid());
            break;
            case UNIT:
                this.units.remove(plObject.getGuid());
            break;
            default:
            break;
        }

    }

    /**
     * @return the parentArea
     */
    public NestedMap getParentArea() {
        return this.parentArea;
    }

    /**
     * @param parentArea
     *        the parentArea to set
     */
    public void setParentArea(final NestedMap parentArea) {
        this.parentArea = parentArea;
    }

    /**
     * Update.
     * 
     * @return true, if successful
     */
    public abstract boolean update();

}
