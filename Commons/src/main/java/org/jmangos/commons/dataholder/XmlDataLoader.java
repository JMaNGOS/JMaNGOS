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
package org.jmangos.commons.dataholder;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

/**
 * The Class XmlDataLoader.
 * 
 */
public class XmlDataLoader {
    
    /**
     * Load static data.
     * 
     * @param <T>
     * @param clazz
     * @param Schema
     * @param XmlFile
     * @return
     */
    public <T> T loadStaticData(final Class<T> clazz, final String Schema, final String XmlFile) {
    
        try {
            final JAXBContext jc = JAXBContext.newInstance(clazz);
            final Unmarshaller un = jc.createUnmarshaller();
            un.setSchema(getSchema(Schema));
            return clazz.cast(un.unmarshal(new File(XmlFile)));
        } catch (final JAXBException e) {
            System.err.println("Error while loading xml data for class: " + clazz.getCanonicalName());
            e.printStackTrace();
        }
        return null;
    }
    
    public <T> T loadStaticData(final Class<T> clazz, final String XmlFile) {
    
        try {
            final JAXBContext jc = JAXBContext.newInstance(clazz);
            final Unmarshaller un = jc.createUnmarshaller();
            return clazz.cast(un.unmarshal(new File(XmlFile)));
        } catch (final JAXBException e) {
            System.err.println("Error while loading xml data for class: " + clazz.getCanonicalName());
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Gets the schema.
     * 
     * @param Schema
     *            the schema
     * @return the schema
     */
    private static Schema getSchema(final String Schema) {
    
        final SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = null;
        try {
            schema = sf.newSchema(new File(Schema));
        } catch (final SAXException e) {
            System.err.println("Error getting schema");
            e.printStackTrace();
        }
        
        return schema;
    }
}
