package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.09. Time: 0:07 To
 * change this template use
 * File | Settings | File Templates.
 */
public class SMSG_UPDATE_OBJECT extends AbstractWoWServerPacket {

    /** The logger. */
    private static Logger logger = LoggerFactory.getLogger(SMSG_UPDATE_OBJECT.class);

    private final byte[] data;

    public SMSG_UPDATE_OBJECT(final byte[] array) {

        this.data = array;
    }

    @Override
    protected void writeImpl() {

        writeB(this.data);
        logger.debug("Update complete. packets cleared.");
    }

}
