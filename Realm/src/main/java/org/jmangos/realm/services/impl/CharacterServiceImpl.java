/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
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
 ******************************************************************************/
package org.jmangos.realm.services.impl;

import java.util.List;

import org.jmangos.commons.entities.CharacterData;
import org.jmangos.realm.dao.CharacterDao;
import org.jmangos.realm.dao.specification.CharacterSpecs;
import org.jmangos.realm.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("characterService")
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterDao characterDao;

    @Override
    public CharacterData readCharacter(final Long id) {

        return this.characterDao.findOne(id);
    }

    @Override
    public List<CharacterData> readCharacters() {

        return this.characterDao.findAll();
    }

    @Override
    public Boolean existWithName(final String name) {

        return this.characterDao.count(CharacterSpecs.isMatchName(name)) > 0;
    }

    @Override
    public CharacterData createOrUpdateCharacter(final CharacterData characterData) {

        return this.characterDao.saveAndFlush(characterData);
    }

    @Override
    public void deleteCharacter(final CharacterData characterData) {

        this.characterDao.delete(characterData);
    }

    @Override
    public CharacterData readCharacterByName(final String name) {
        return this.characterDao.findByName(name);
    }

    @Override
    public List<CharacterData> readCharactersForAccount(final Long objectId) {
        return this.characterDao.findByAccount(objectId);
    }

}
