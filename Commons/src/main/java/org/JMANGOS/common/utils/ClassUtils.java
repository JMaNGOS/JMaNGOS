/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.common.utils;

public class ClassUtils
{
	/**
	 * Return true if class a is either equivalent to class b, or if class a is a subclass of class b, i.e. if a either
	 * "extends" or "implements" b. Note tht either or both "Class" objects may represent interfaces.
	 * 
	 * @param a
	 *            class
	 * @param b
	 *            class
	 * @return true if a == b or a extends b or a implements b
	 */
	public static boolean isSubclass(Class<?> a, Class<?> b)
	{
		// We rely on the fact that for any given java class or
		// Primitive type there is a unique Class object, so
		// we can use object equivalence in the comparisons.
		if (a == b)
		{
			return true;
		}
		if (a == null || b == null)
		{
			return false;
		}
		for (Class<?> x = a; x != null; x = x.getSuperclass())
		{
			if (x == b)
			{
				return true;
			}
			if (b.isInterface())
			{
				Class<?>[] interfaces = x.getInterfaces();
				for (Class<?> anInterface : interfaces)
				{
					if (isSubclass(anInterface, b))
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks if class in member of the package.
	 *
	 * @param clazz class to check
	 * @param packageName package
	 * @return true if is member
	 */
	public static boolean isPackageMember(Class<?> clazz, String packageName)
	{
		return isPackageMember(clazz.getName(), packageName);
	}

	/**
	 * Checks if classNames belongs to package.
	 *
	 * @param className class name
	 * @param packageName package
	 * @return true if belongs
	 */
	public static boolean isPackageMember(String className, String packageName)
	{
		if (!className.contains("."))
		{
			return packageName == null || packageName.isEmpty();
		}
		else
		{
			String classPackage = className.substring(0, className.lastIndexOf('.'));
			return packageName.equals(classPackage);
		}
	}
}
