package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.commons.enums.CharDeleteCode;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA.
 * User: GiBSON
 * Date: 10.05.13
 * Time: 17:24
 */
public class SMSG_CHAR_DELETE extends AbstractWoWServerPacket {

    private final CharDeleteCode code;

    public SMSG_CHAR_DELETE(final CharDeleteCode code) {
        this.code = code;
    }

    @Override
    protected void writeImpl() {
        writeC(this.code.getValue());
    }
}
