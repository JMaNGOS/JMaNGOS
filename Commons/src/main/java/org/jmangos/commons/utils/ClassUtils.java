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
package org.jmangos.commons.utils;

public class ClassUtils {

    /**
     * Return true if class a is either equivalent to class b, or if class a is
     * a subclass of class
     * b, i.e. if a either "extends" or "implements" b. Note tht either or both
     * "Class" objects may
     * represent interfaces.
     * 
     * @param a
     *        class
     * @param b
     *        class
     * @return true if a == b or a extends b or a implements b
     */
    public static boolean isSubclass(final Class<?> a, final Class<?> b) {

        // We rely on the fact that for any given java class or
        // Primitive type there is a unique Class object, so
        // we can use object equivalence in the comparisons.
        if (a == b) {
            return true;
        }
        if ((a == null) || (b == null)) {
            return false;
        }
        for (Class<?> x = a; x != null; x = x.getSuperclass()) {
            if (x == b) {
                return true;
            }
            if (b.isInterface()) {
                final Class<?>[] interfaces = x.getInterfaces();
                for (final Class<?> anInterface : interfaces) {
                    if (isSubclass(anInterface, b)) {
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
     * @param clazz
     *        class to check
     * @param packageName
     *        package
     * @return true if is member
     */
    public static boolean isPackageMember(final Class<?> clazz, final String packageName) {

        return isPackageMember(clazz.getName(), packageName);
    }

    /**
     * Checks if classNames belongs to package.
     * 
     * @param className
     *        class name
     * @param packageName
     *        package
     * @return true if belongs
     */
    public static boolean isPackageMember(final String className, final String packageName) {

        if (!className.contains(".")) {
            return (packageName == null) || packageName.isEmpty();
        } else {
            final String classPackage = className.substring(0, className.lastIndexOf('.'));
            return packageName.equals(classPackage);
        }
    }
}
