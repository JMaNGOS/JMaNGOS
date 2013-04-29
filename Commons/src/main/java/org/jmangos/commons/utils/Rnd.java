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

public class Rnd {

    private static final MTRandom rnd = new MTRandom();

    /**
     * @return rnd
     */
    public static float get() {
        return rnd.nextFloat();
    }

    /**
     * Return random [0,n]
     * 
     * @param n
     * @return
     */
    public static int get(final int n) {
        return (int) Math.floor(rnd.nextDouble() * n);
    }

    /**
     * Return random [min,max]
     * 
     * @param min
     * @param max
     * @return value
     */
    public static int get(final int min, final int max) {
        return min + (int) Math.floor(rnd.nextDouble() * ((max - min) + 1));
    }

    /**
     * @param n
     * @return n
     */
    public static int nextInt(final int n) {
        return (int) Math.floor(rnd.nextDouble() * n);
    }

    /**
     * @return int
     */
    public static int nextInt() {
        return rnd.nextInt();
    }

    /**
     * @return double
     */
    public static double nextDouble() {
        return rnd.nextDouble();
    }

    /**
     * @return double
     */
    public static boolean nextBoolean() {
        return rnd.nextBoolean();
    }
}
