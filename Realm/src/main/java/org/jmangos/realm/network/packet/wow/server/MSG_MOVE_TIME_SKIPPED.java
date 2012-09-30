package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 3:58 To
 * change this template use
 * File | Settings | File Templates.
 */
public class MSG_MOVE_TIME_SKIPPED extends AbstractWoWServerPacket {

    private long guid;
    private int time_dif;

    public MSG_MOVE_TIME_SKIPPED() {

    }

    public MSG_MOVE_TIME_SKIPPED(final long guid, final int time_dif) {

        this.guid = guid;
        this.time_dif = time_dif;
    }

    @Override
    protected void writeImpl() {

        writePackedGuid(this.guid);
        writeD(this.time_dif);
    }
}
