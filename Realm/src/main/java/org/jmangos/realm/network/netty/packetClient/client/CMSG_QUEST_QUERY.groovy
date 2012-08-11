package org.jmangos.realm.network.netty.packetClient.client

import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket
import javax.inject.Inject
import org.jmangos.commons.database.DatabaseFactory

import java.nio.BufferUnderflowException

import org.jmangos.realm.network.netty.packetClient.server.SMSG_QUEST_QUERY_RESPONSE
import javax.inject.Named
import org.jmangos.commons.network.netty.sender.AbstractPacketSender
import org.jmangos.realm.service.QuestStorages
import org.apache.log4j.Logger

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public class CMSG_QUEST_QUERY extends AbstractWoWClientPacket {
    Logger log = Logger.getLogger( CMSG_QUEST_QUERY.class );

    @Inject
    @Named("client")
    private AbstractPacketSender sender;

    @Inject
    private QuestStorages questStorages;

    @Inject
    private DatabaseFactory databaseFactory;

    private def questProrotype = null;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        Integer questId = readD();
        log.info("Quest query received (#" + questId + ")");
        skipAll();

        questProrotype = questStorages.getQuest( );
    }

    @Override
    protected void runImpl() {
        if (questProrotype == null)
            return;

        def questResponse = new SMSG_QUEST_QUERY_RESPONSE()
        questResponse.setQuest questProrotype

        sender.send player.channel, questResponse
    }
}
