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
package org.JMANGOS.wowdata.blp;

// Yanked from http://forum.worldwindcentral.com/showthread.php?p=71605
public class Color {
	public int r, g, b;

	public Color() {
		this.r = this.g = this.b = 0;
	}

	public Color(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
		
		if (this.r < 0) {
			this.r = 256 + r;
		}
		if (this.g < 0) {
			this.g = 256 + g;
		}
		if (this.b < 0) {
			this.b = 256 + b;
		}
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final Color color = (Color) o;

		if (b != color.b) {
			return false;
		}
		if (g != color.g) {
			return false;
		}
		//noinspection RedundantIfStatement
		if (r != color.r) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int result;
		result = r;
		result = 29 * result + g;
		result = 29 * result + b;
		return result;
	}
	
	public int asInt() {
		return (r << 16) + (g << 8) + b;
	}
	
	public String toString() {
		return "(" + r + "," + g + "," + b + ")";
	}
}
