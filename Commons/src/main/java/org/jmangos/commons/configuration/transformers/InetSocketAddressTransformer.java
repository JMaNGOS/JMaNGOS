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
package org.jmangos.commons.configuration.transformers;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.jmangos.commons.configuration.PropertyTransformer;
import org.jmangos.commons.configuration.TransformationException;



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
