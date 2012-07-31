/*******************************************************************************
 * Copyright (c) 2011 WoWEmu
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *    WoWEmu  - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.common.dataholder;

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
	 *  Load static data.
	 * @param <T>
	 * @param clazz
	 * @param Schema
	 * @param XmlFile
	 * @return
	 */
	public <T> T loadStaticData(Class<T> clazz, String Schema, String XmlFile) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller un = jc.createUnmarshaller();
			un.setSchema(getSchema(Schema));
			return clazz.cast(un.unmarshal(new File(XmlFile)));
		} catch (JAXBException e) {
			System.err.println("Error while loading xml data for class: "
					+ clazz.getCanonicalName());
			e.printStackTrace();
		}
		return null;
	}

	public <T> T loadStaticData(Class<T> clazz,  String XmlFile) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller un = jc.createUnmarshaller();
			return clazz.cast(un.unmarshal(new File(XmlFile)));
		} catch (JAXBException e) {
			System.err.println("Error while loading xml data for class: "
					+ clazz.getCanonicalName());
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
	private static Schema getSchema(String Schema) {
		SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = null;
		try {
			schema = sf.newSchema(new File(Schema));
		} catch (SAXException e) {
			System.err.println("Error getting schema");
			e.printStackTrace();
		}

		return schema;
	}
}
