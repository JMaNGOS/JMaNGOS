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

package org.JMANGOS.common.configuration.transformers;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.JMANGOS.common.configuration.PropertyTransformer;
import org.JMANGOS.common.configuration.TransformationException;



public class InetSocketAddressTransformer implements PropertyTransformer<InetSocketAddress>
{
	/**
	 * Shared instance of this transformer. It's thread-safe so no need of multiple instances
	 */
	public static final InetSocketAddressTransformer	SHARED_INSTANCE	= new InetSocketAddressTransformer();

	/**
	 * Transforms string to InetSocketAddress.
	 *
	 * @param value value that will be transformed
	 * @param field value will be assigned to this field
	 * @return InetSocketAddress that represetns value
	 * @throws TransformationException if somehting went wrong
	 */
	@Override
	public InetSocketAddress transform(String value, Field field) throws TransformationException
	{
		String[] parts = value.split(":");

		if (parts.length != 2)
		{
			throw new TransformationException("Can't transform property, must be in format \"address:port\"");
		}

		try
		{
			if ("*".equals(parts[0]))
			{
				return new InetSocketAddress(Integer.parseInt(parts[1]));
			}
			else
			{
				InetAddress address = InetAddress.getByName(parts[0]);
				int port = Integer.parseInt(parts[1]);
				return new InetSocketAddress(address, port);
			}
		}
		catch (Exception e)
		{
			throw new TransformationException(e);
		}
	}
}
