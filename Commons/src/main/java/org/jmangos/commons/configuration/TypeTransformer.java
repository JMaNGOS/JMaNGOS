package org.jmangos.commons.configuration;

import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Transformation between types.
 * 
 * @author Schiffer
 */
public class TypeTransformer {

	/**
	 * Cast passed value to passed class. In this case used string constructor.
	 * 
	 * @param value
	 * @param castTarget
	 * @return casted object
	 */
	public static <E extends Object> E castFromString(String value,
			Class<E> castTarget) {
		try {
			if (castTarget.equals(InetSocketAddress.class)) {
				String[] parts = value.split(":");
				if (parts.length != 2) {
					throw new RuntimeException(
							"Can't transform property, must be in format \"address:port\"");
				} 
				if ("*".equals(parts[0])) {
					return (E) new InetSocketAddress(Integer.parseInt(parts[1]));
				} else {
					InetAddress address = InetAddress.getByName(parts[0]);
					int port = Integer.parseInt(parts[1]);
					return (E) new InetSocketAddress(address, port);
				}
			} else if (castTarget.isEnum()) {
				return (E) Enum.valueOf((Class<? extends Enum>) castTarget,
						value);
			} else if (castTarget == Class.class) {
				  return (E) Class.forName(value);
			} else {
				Constructor<E> constructor = castTarget
						.getConstructor(new Class[] { String.class });
				return constructor.newInstance(new Object[] { value });
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(String.format(
					"%s impossible cast to %s", value,
					castTarget.getSimpleName()));
		}
	}
}
