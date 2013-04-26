package org.jmangos.commons.model.base;

import java.util.List;

import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.FieldsObject;
import org.jmangos.commons.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@Lazy(value = true)
@Qualifier("Area")
public class Area extends Map {

    private Map parentArea;
    boolean spawned = false;
    @Autowired
    CreatureService creature;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.jmangos.commons.model.base.Map#addObject(org.jmangos.commons.entities
     * .FieldsObject)
     */
    @Override
    public void addObject(final FieldsObject plObject) {
        if (!this.spawned) {
            final Map map = getRootMap();
            final List<Creature> creatures =
                    this.creature.getCreatureForMapWithPositionBBox(map, getLeftCorner(),
                            getRightCorner());
            for (Creature creature : creatures) {
                super.addObject(creature);
            }
        }
        super.addObject(plObject);
        
    }

    private Map getRootMap() {
        if (this.parentArea instanceof Area) {
            return ((Area) this.parentArea).getRootMap();
        }
        return this.parentArea;
    }

    /**
     * @return the parentArea
     */
    public final Map getParentArea() {
        return this.parentArea;
    }

    /**
     * @param parentArea
     *        the parentArea to set
     */
    public final void setParentArea(final Map parentArea) {
        this.parentArea = parentArea;
    }

}
