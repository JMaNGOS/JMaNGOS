package org.jmangos.realm.network.netty.packetClient.client

import org.jmangos.realm.network.netty.packetClient.AbstractWoWClientPacket
import java.util.logging.Logger
import javax.inject.Inject
import org.jmangos.commons.database.DatabaseFactory
import org.jmangos.realm.domain.QuestTemplate
import java.nio.BufferUnderflowException
import org.hibernate.Session
import org.hibernate.Query
import org.jmangos.realm.network.netty.packetClient.server.SMSG_QUEST_QUERY_RESPONSE
import javax.inject.Named
import org.jmangos.commons.network.netty.sender.AbstractPacketSender

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
public class CMSG_QUEST_QUERY extends AbstractWoWClientPacket {
    Logger log = Logger.getLogger(CMSG_QUEST_QUERY.class.getSimpleName());

    @Inject
    @Named("client")
    private AbstractPacketSender sender;

    @Inject
    private DatabaseFactory databaseFactory;

    private def questTemplate = null;

    @Override
    protected void readImpl() throws BufferUnderflowException, RuntimeException {
        Integer questId = readD();
        log.info("Quest query received (#" + questId + ")");
        skipAll();

        Session session = databaseFactory.sessionFactory.openSession();
        Query questTemplateQuery = session.createQuery("select qt from QuestTemplate qt where qt.id = :id").setInteger("id", questId);
        questTemplate = (QuestTemplate) questTemplateQuery.uniqueResult();
    }

    @Override
    protected void runImpl() {
        if (questTemplate == null)
            return;

        def questResponse = new SMSG_QUEST_QUERY_RESPONSE()
        questResponse.setQuest questTemplate

        sender.send player.channel, questResponse
    }
}
