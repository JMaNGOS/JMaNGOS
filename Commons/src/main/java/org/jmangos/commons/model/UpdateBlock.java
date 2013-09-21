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
    private int curPosition = 0;
    private int lastPosition = 0;
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
        this.positions.put(this.countBlocks,
                new BufferPosition(this.curPosition, this.lastPosition));
        this.curPosition = this.lastPosition;
        this.countBlocks++;
    }

    public byte[] buildAll() {
        this.buffer.setInt(0, this.countBlocks);
        return this.buffer.readBytes(this.buffer.readableBytes()).array();
    }

    public byte[] build(int max) {
        if (max > (this.countBlocks - this.readedBlocks)) {
            max = this.countBlocks - this.readedBlocks;
        }
        final ChannelBuffer chunkBuffer =
                ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, 1024);
        chunkBuffer.writeInt(max);
        for (int i = this.readedBlocks; i < (this.readedBlocks + max); i++) {
            final BufferPosition pos = this.positions.get(i);
            this.buffer.readerIndex(pos.getStartPosition());
            chunkBuffer.writeBytes(this.buffer.readSlice(pos.getLength()));
        }
        this.readedBlocks += max;
        return chunkBuffer.array();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.positions.size(); i++) {
            final BufferPosition pos = this.positions.get(i);
            sb.append("\n").append(i).append(" ").append(pos.getStartPosition()).append(" ").append(
                    pos.getEndPosition());
        }
        return sb.toString();
    }

    public boolean isFinished() {
        return this.readedBlocks == this.countBlocks;
    }
}
