package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA.
 * User: GiBSON
 * Date: 30.04.13
 * Time: 0:56
 */
public class SMSG_TRIGGER_CINEMATIC extends AbstractWoWServerPacket {

    private int cinematicSequence = 0;

    public SMSG_TRIGGER_CINEMATIC(final int cinematicSequence2) {
        this.cinematicSequence = cinematicSequence2;
    }

    @Override
    protected void writeImpl() {
        writeD(this.cinematicSequence);
    }
}
