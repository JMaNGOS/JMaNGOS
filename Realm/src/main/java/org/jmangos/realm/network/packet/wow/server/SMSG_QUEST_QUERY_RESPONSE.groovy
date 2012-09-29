package org.jmangos.realm.network.packet.wow.server

import org.jmangos.realm.network.packet.wow.AbstractWoWServerPacket;
import org.jmangos.world.entities.QuestPrototype;

/**
 * Created with IntelliJ IDEA.
 * User: paalgyula
 * Date: 2012.08.08.
 * Time: 14:52
 */
class SMSG_QUEST_QUERY_RESPONSE extends AbstractWoWServerPacket {

    def QuestPrototype questTemplate;
    def setQuest = { questTemplate ->
        this.questTemplate = questTemplate
    }

    @Override
    void writeImpl() {
        writeD questTemplate.entry
        writeD 0x02
        writeD questTemplate.questLevel
        writeD questTemplate.minLevel

        writeD questTemplate.zoneOrSort
        writeD questTemplate.type
        writeD questTemplate.suggestedPlayers

        // Repu min
        writeD questTemplate.requiredMinRepFaction
        writeD questTemplate.requiredMinRepValue

        // Repu max
        writeD questTemplate.requiredMaxRepFaction
        writeD questTemplate.requiredMaxRepValue

        writeD questTemplate.nextQuestId
        writeD 0x00 // ??
        writeD questTemplate.rewMoneyMaxLevel
        writeD 0x00 // Required money TODO:implement
        writeD questTemplate.rewSpell
        writeD questTemplate.rewSpellCast

        // Bonus honor, and multiplier
        writeD questTemplate.rewHonorAddition
        writeF questTemplate.rewHonorMultiplier

        writeD questTemplate.srcItemId
        writeD questTemplate.questFlags

        // Reward title
        writeD questTemplate.charTitleId
        writeD questTemplate.playersSlain // Player Kill Count ?!
        writeD questTemplate.bonusTalents // Talent

        writeD 0x00 // unk 3.3.0
        writeD 0x00 // unk 3.3.0

        // Item loop
        for ( i in 1..4 ) {
            writeD questTemplate."rewItemId$i"
            writeD questTemplate."rewItemCount$i"
        }

        // Choosable item loop
        for( i in 1..6 ) {
            writeD questTemplate."rewChoiceItemId$i"
            writeD questTemplate."rewChoiceItemCount$i"
        }

        // Faction rewards TODO: fix it
        for( i in 1..5 )
            writeD questTemplate."rewRepFaction$i"	// reward factions ids
        for( i in 1..5 )
            writeD 0x00	// column index in QuestFactionReward.dbc but use unknown
        for( i in 1..5 )
            writeD 0x00	// unk

        writeD questTemplate.pointMapId
        writeF questTemplate.pointX
        writeF questTemplate.pointY
        writeD questTemplate.pointOpt

        writeS questTemplate.title
        writeS questTemplate.objectives
        writeS questTemplate.details
        writeS questTemplate.endText
        writeC 0x00 // ?

        for(i in 1..4 ) {
            writeD questTemplate."reqCreatureOrGoId$i"
            writeD questTemplate."reqCreatureOrGoCount$i"
            writeD 0x00 // Unknown
            writeD 0x00 // 3.3.0 Unknown
        }

        for( i in 1..6 ) {
            questTemplate."reqItemId$i"
            questTemplate."reqItemCount$i"
        }

        for ( i in 1..4 )
            writeS questTemplate."objectiveText$i"

        // Tadaaam
    }
}
