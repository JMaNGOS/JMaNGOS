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
package org.jmangos.realm.services.impl;

import java.util.List;

import org.criteria4jpa.criterion.Criterion;
import org.jmangos.realm.dao.CharacterDao;
import org.jmangos.realm.entities.CharacterData;
import org.jmangos.realm.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService {
    
    @Autowired
    private CharacterDao characterDao;
    
    @Override
    public CharacterData readCharacter(final Long id) {
    
        return this.characterDao.readCharacter(id);
    }
    
    @Override
    public List<CharacterData> readCharacters(final Criterion... criterions) {
    
        return this.characterDao.readCharacters(criterions);
    }
    
    @Override
    public Long createOrUpdateCharacter(final CharacterData characterData) {
    
        return this.characterDao.createOrUpdateCharacter(characterData);
    }
    
    @Override
    public void deleteCharacter(final CharacterData characterData) {
    
        this.characterDao.deleteCharacter(characterData);
    }
    
}
