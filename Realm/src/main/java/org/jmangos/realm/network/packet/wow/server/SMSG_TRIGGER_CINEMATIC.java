package org.jmangos.realm.network.packet.wow.server;

import org.jmangos.commons.entities.*;
import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;
import org.jmangos.realm.service.ChrRacesStorages;
import org.jmangos.realm.service.ChrClassesStorages;
import org.jmangos.commons.model.player.Player;

/**
 * Created with IntelliJ IDEA.
 * User: GiBSON
 * Date: 30.04.13
 * Time: 0:56
 */
public class SMSG_TRIGGER_CINEMATIC extends AbstractWoWServerPacket {

    private ChrRacesStorages chrRacesStorages;
    private ChrClassesStorages chrClassesStorages;
    private int cinematicSequence = 0;
    private Player player;

    public SMSG_TRIGGER_CINEMATIC(final Player player) {
        this.player = player;
    }

    @Override
    protected void writeImpl() {
        cinematicSequence = chrClassesStorages.getChrRace(player.getCharacterData().getClazz()).getCinematicSequence();
        if (cinematicSequence == 0) {
            cinematicSequence = chrRacesStorages.getChrRace(player.getCharacterData().getRace()).getCinematicSequence();
        }
        if (cinematicSequence > 0) {
            writeD(cinematicSequence);
        }
    }
}
