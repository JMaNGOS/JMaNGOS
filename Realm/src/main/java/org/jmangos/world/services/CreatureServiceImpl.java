/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package org.jmangos.world.services;

import java.util.ArrayList;
import java.util.List;

import org.jmangos.commons.entities.CreaturePrototype;
import org.jmangos.commons.entities.Creature;
import org.jmangos.commons.entities.Position;
import org.jmangos.commons.model.base.Map;
import org.jmangos.commons.service.CreatureService;
import org.jmangos.world.dao.CreatureDao;
import org.jmangos.world.dao.CreatureDataDao;
import org.jmangos.world.dao.specification.CreatureDataSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;

/**
 * @author MinimaJack
 * 
 */
@Component
public class CreatureServiceImpl implements CreatureService {

    @Autowired
    private CreatureDataDao creatureDataDao;

    @Autowired
    private CreatureDao creatureDao;

    /* (non-Javadoc)
     * @see org.jmangos.world.services.CreatureService#getCreatureForMapWithPositionBBox(org.jmangos.commons.model.base.Map, org.jmangos.commons.entities.Position, org.jmangos.commons.entities.Position)
     */
    @Override
    public List<Creature> getCreatureForMapWithPositionBBox(final Map map,
            final Position poslc, final Position posrc) {
        List<Creature> listData =
                this.creatureDataDao.findAll(Specifications.where(
                        CreatureDataSpecs.isWithinCoords(poslc, posrc)).and(
                        CreatureDataSpecs.isInMap(map))
                        .and(CreatureDataSpecs.isHaveId(6)));
        List<Creature> deleted = new ArrayList<Creature>();
        for (Creature creature : listData) {
            CreaturePrototype creatureTemplate = creatureDao.findOne((long)creature.getEntry());
            if (creatureTemplate != null) {
                creature.setPrototype(creatureTemplate);
            }else{
                deleted.add(creature);
            }
        }
        listData.removeAll(deleted);
        return listData;

    }

}
