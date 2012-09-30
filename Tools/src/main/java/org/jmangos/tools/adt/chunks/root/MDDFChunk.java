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
package org.jmangos.tools.adt.chunks.root;

import java.nio.ByteBuffer;

import org.jmangos.tools.adt.chunks.ADTChunk;

public class MDDFChunk extends ADTChunk {

    final static class MDDFEntry extends ADTChunk {

        private Unsigned32 mmidEntry = new Unsigned32();
        private Unsigned32 uniqueId = new Unsigned32();
        private Float32[] position = array(new Float32[3]);
        private Float32[] rotation = array(new Float32[3]);
        private Unsigned16 scale = new Unsigned16();
        private Unsigned16 flags = new Unsigned16();

        /**
         * @return the mmidEntry
         */
        public final Unsigned32 getMmidEntry() {

            return this.mmidEntry;
        }

        /**
         * @param mmidEntry
         *        the mmidEntry to set
         */
        public final void setMmidEntry(final Unsigned32 mmidEntry) {

            this.mmidEntry = mmidEntry;
        }

        /**
         * @return the uniqueId
         */
        public final Unsigned32 getUniqueId() {

            return this.uniqueId;
        }

        /**
         * @param uniqueId
         *        the uniqueId to set
         */
        public final void setUniqueId(final Unsigned32 uniqueId) {

            this.uniqueId = uniqueId;
        }

        /**
         * @return the position
         */
        public final Float32[] getPosition() {

            return this.position;
        }

        /**
         * @param position
         *        the position to set
         */
        public final void setPosition(final Float32[] position) {

            this.position = position;
        }

        /**
         * @return the rotation
         */
        public final Float32[] getRotation() {

            return this.rotation;
        }

        /**
         * @param rotation
         *        the rotation to set
         */
        public final void setRotation(final Float32[] rotation) {

            this.rotation = rotation;
        }

        /**
         * @return the scale
         */
        public final Unsigned16 getScale() {

            return this.scale;
        }

        /**
         * @param scale
         *        the scale to set
         */
        public final void setScale(final Unsigned16 scale) {

            this.scale = scale;
        }

        /**
         * @return the flags
         */
        public final Unsigned16 getFlags() {

            return this.flags;
        }

        /**
         * @param flags
         *        the flags to set
         */
        public final void setFlags(final Unsigned16 flags) {

            this.flags = flags;
        }
    }

    private MDDFEntry[] MDDFEntries;

    @Override
    public ADTChunk reads(final ByteBuffer bb, final int offset, final long size) {

        this.MDDFEntries = new MDDFEntry[(int) (size / 36)];
        for (int i = 0; i < (size / 36); i++) {
            this.MDDFEntries[i] = new MDDFEntry();
            this.MDDFEntries[i].setByteBuffer(bb, offset + (36 * i));
        }
        setGlobalOffcet(offset + size + HEADERSIZE);
        setByteBuffer(bb, offset);
        return this;
    }

    @Override
    public String toString() {

        return "[MDDFChunk]" + "\n MDDFEntries count: " + this.MDDFEntries.length;
    }

}
