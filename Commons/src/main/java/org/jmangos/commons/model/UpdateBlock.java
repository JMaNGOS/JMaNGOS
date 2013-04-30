package org.jmangos.commons.model;

import java.nio.ByteOrder;
import java.util.Map;

import javolution.util.FastMap;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class UpdateBlock {

    private ChannelBuffer buffer = ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, 1024);
    private Integer countBlocks = 0;
    private int readedBlocks = 0;
    private long curPosition = 0;
    private long lastPosition = 0;
    private final Map<Integer, BufferPosition> positions = new FastMap<Integer, BufferPosition>();

    public UpdateBlock() {
        this.buffer.writeInt(0);
    }

    /**
     * @return the buffer
     */
    public final ChannelBuffer getBuffer() {
        return this.buffer;
    }

    /**
     * @param buffer
     *        the buffer to set
     */
    public final void setBuffer(final ChannelBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * @return the countBlocks
     */
    public final int getCountBlocks() {
        return this.countBlocks;
    }

    /**
     * @param countBlocks
     *        the countBlocks to set
     */
    public final void setCountBlocks(final int countBlocks) {
        this.countBlocks = countBlocks;
    }

    /**
     * 
     */
    public final void icrementCountBlocks() {
        this.lastPosition = this.buffer.readableBytes();
        this.positions.put(this.countBlocks, new BufferPosition(this.curPosition + 1,
                this.lastPosition));
        this.curPosition = this.lastPosition;
        this.countBlocks++;
    }

    public byte[] build() {
        this.buffer.setInt(0, this.countBlocks);
        return this.buffer.readBytes(this.buffer.readableBytes()).array();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.positions.size(); i++) {
            final BufferPosition pos = this.positions.get(i);
            sb.append(i).append(" ").append(pos.getStartPosition()).append(" ").append(
                    pos.getEndPosition()).append("\n");
        }
        return sb.toString();
    }
}
