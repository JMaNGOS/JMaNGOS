package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.07. Time: 23:43 To
 * change this template use
 * File | Settings | File Templates.
 */
public class SMSG_CHAR_CREATE extends AbstractWoWServerPacket {

    private Integer code;

    public static enum Code {
        IN_PROGRESS(0x2E),
        SUCCESS(0x2F),
        ERROR(0x30),
        FAILED(0x31),
        NAME_IN_USE(0x32),
        DISABLED(0x33),
        PVP_TEAMS_VIOLATION(0x34),
        SERVER_LIMIT(0x35),
        ACCOUNT_LIMIT(0x36),
        SERVER_QUEUE(0x37),
        ONLY_EXISTING(0x38),
        EXPANSION(0x39),
        EXPANSION_CLASS(0x3A),
        LEVEL_REQUIREMENT(0x3B),
        UNIQUE_CLASS_LIMIT(0x3C),
        CHARACTER_IN_GUILD(0x3D),
        RESTRICTED_RACECLASS(0x3E),
        CHARACTER_CHOOSE_RACE(0x3F),
        CHARACTER_ARENA_LEADER(0x40),
        CHARACTER_DELETE_MAIL(0x41),
        CHARACTER_SWAP_FACTION(0x42),
        CHARACTER_RACE_ONLY(0x43),
        CHARACTER_GOLD_LIMIT(0x44),
        FORCE_LOGIN(0x45);

        private int value;

        Code(final int value) {

            this.value = value;
        }

        public int getValue() {

            return this.value;
        }
    };

    public SMSG_CHAR_CREATE() {

    }

    public SMSG_CHAR_CREATE(final int code) {

        this.code = code;
    }

    public SMSG_CHAR_CREATE(final Code code) {

        this.code = code.getValue();
    }

    @Override
    protected void writeImpl() {

        if (this.code != null) {
            writeC(this.code);
        } else {
            writeC(0x2F); // Success
        }
    }
}
