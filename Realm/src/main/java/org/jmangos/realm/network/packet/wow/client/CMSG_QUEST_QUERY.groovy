package org.jmangos.realm.network.packet.wow.client

import org.jmangos.realm.network.packet.wow.AbstractWoWClientPacket
import javax.inject.Inject
import org.jmangos.commons.database.DatabaseFactory

import java.nio.BufferUnderflowException

import org.jmangos.realm.network.packet.wow.server.SMSG_QUEST_QUERY_RESPONSE
import javax.inject.Named
import org.jmangos.commons.network.netty.sender.AbstractPacketSender
import org.jmangos.realm.service.QuestStorages
import org.springframework.stereotype.Component;
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
@Component
public class CMSG_QUEST_QUERY extends AbstractWoWClientPacket {
    private static final Logger log = LoggerFactory.getLogger( CMSG_QUEST_QUERY.class );
    
    @Inject
    @Named("nettyPacketSender")
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
        
        questProrotype = questStorages.getQuest( questId );
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
