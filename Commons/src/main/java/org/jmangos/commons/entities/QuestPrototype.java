/*******************************************************************************
 * Copyright (C) 2013 JMaNGOS <http://jmangos.org/>
 *  
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.jmangos.commons.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA. User: paalgyula Date: 2012.08.08. Time: 13:30
 */
@Entity
@Table(name = "quest_template")
public class QuestPrototype {

    @Id
    @Column(name = "entry",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    private Integer entry;

    public Integer getEntry() {

        return this.entry;
    }

    public void setEntry(final Integer entry) {

        this.entry = entry;
    }

    private byte method;

    @javax.persistence.Column(name = "Method",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getMethod() {

        return this.method;
    }

    public void setMethod(final byte method) {

        this.method = method;
    }

    private short zoneOrSort;

    @javax.persistence.Column(name = "ZoneOrSort",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getZoneOrSort() {

        return this.zoneOrSort;
    }

    public void setZoneOrSort(final short zoneOrSort) {

        this.zoneOrSort = zoneOrSort;
    }

    private byte minLevel;

    @javax.persistence.Column(name = "MinLevel",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getMinLevel() {

        return this.minLevel;
    }

    public void setMinLevel(final byte minLevel) {

        this.minLevel = minLevel;
    }

    private short questLevel;

    @javax.persistence.Column(name = "QuestLevel",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getQuestLevel() {

        return this.questLevel;
    }

    public void setQuestLevel(final short questLevel) {

        this.questLevel = questLevel;
    }

    private short type;

    @javax.persistence.Column(name = "Type",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getType() {

        return this.type;
    }

    public void setType(final short type) {

        this.type = type;
    }

    private short requiredClasses;

    @javax.persistence.Column(name = "RequiredClasses",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRequiredClasses() {

        return this.requiredClasses;
    }

    public void setRequiredClasses(final short requiredClasses) {

        this.requiredClasses = requiredClasses;
    }

    private short requiredRaces;

    @javax.persistence.Column(name = "RequiredRaces",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRequiredRaces() {

        return this.requiredRaces;
    }

    public void setRequiredRaces(final short requiredRaces) {

        this.requiredRaces = requiredRaces;
    }

    private short requiredSkill;

    @javax.persistence.Column(name = "RequiredSkill",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRequiredSkill() {

        return this.requiredSkill;
    }

    public void setRequiredSkill(final short requiredSkill) {

        this.requiredSkill = requiredSkill;
    }

    private short requiredSkillValue;

    @javax.persistence.Column(name = "RequiredSkillValue",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRequiredSkillValue() {

        return this.requiredSkillValue;
    }

    public void setRequiredSkillValue(final short requiredSkillValue) {

        this.requiredSkillValue = requiredSkillValue;
    }

    private short repObjectiveFaction;

    @javax.persistence.Column(name = "RepObjectiveFaction",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRepObjectiveFaction() {

        return this.repObjectiveFaction;
    }

    public void setRepObjectiveFaction(final short repObjectiveFaction) {

        this.repObjectiveFaction = repObjectiveFaction;
    }

    private int repObjectiveValue;

    @javax.persistence.Column(name = "RepObjectiveValue",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRepObjectiveValue() {

        return this.repObjectiveValue;
    }

    public void setRepObjectiveValue(final int repObjectiveValue) {

        this.repObjectiveValue = repObjectiveValue;
    }

    private short requiredMinRepFaction;

    @javax.persistence.Column(name = "RequiredMinRepFaction",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRequiredMinRepFaction() {

        return this.requiredMinRepFaction;
    }

    public void setRequiredMinRepFaction(final short requiredMinRepFaction) {

        this.requiredMinRepFaction = requiredMinRepFaction;
    }

    private int requiredMinRepValue;

    @javax.persistence.Column(name = "RequiredMinRepValue",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRequiredMinRepValue() {

        return this.requiredMinRepValue;
    }

    public void setRequiredMinRepValue(final int requiredMinRepValue) {

        this.requiredMinRepValue = requiredMinRepValue;
    }

    private short requiredMaxRepFaction;

    @javax.persistence.Column(name = "RequiredMaxRepFaction",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRequiredMaxRepFaction() {

        return this.requiredMaxRepFaction;
    }

    public void setRequiredMaxRepFaction(final short requiredMaxRepFaction) {

        this.requiredMaxRepFaction = requiredMaxRepFaction;
    }

    private int requiredMaxRepValue;

    @javax.persistence.Column(name = "RequiredMaxRepValue",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRequiredMaxRepValue() {

        return this.requiredMaxRepValue;
    }

    public void setRequiredMaxRepValue(final int requiredMaxRepValue) {

        this.requiredMaxRepValue = requiredMaxRepValue;
    }

    private byte suggestedPlayers;

    @javax.persistence.Column(name = "SuggestedPlayers",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getSuggestedPlayers() {

        return this.suggestedPlayers;
    }

    public void setSuggestedPlayers(final byte suggestedPlayers) {

        this.suggestedPlayers = suggestedPlayers;
    }

    private int limitTime;

    @javax.persistence.Column(name = "LimitTime",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getLimitTime() {

        return this.limitTime;
    }

    public void setLimitTime(final int limitTime) {

        this.limitTime = limitTime;
    }

    private int questFlags;

    @javax.persistence.Column(name = "QuestFlags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getQuestFlags() {

        return this.questFlags;
    }

    public void setQuestFlags(final int questFlags) {

        this.questFlags = questFlags;
    }

    private byte specialFlags;

    @javax.persistence.Column(name = "SpecialFlags",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getSpecialFlags() {

        return this.specialFlags;
    }

    public void setSpecialFlags(final byte specialFlags) {

        this.specialFlags = specialFlags;
    }

    private byte charTitleId;

    @javax.persistence.Column(name = "CharTitleId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getCharTitleId() {

        return this.charTitleId;
    }

    public void setCharTitleId(final byte charTitleId) {

        this.charTitleId = charTitleId;
    }

    private byte playersSlain;

    @javax.persistence.Column(name = "PlayersSlain",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getPlayersSlain() {

        return this.playersSlain;
    }

    public void setPlayersSlain(final byte playersSlain) {

        this.playersSlain = playersSlain;
    }

    private byte bonusTalents;

    @javax.persistence.Column(name = "BonusTalents",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getBonusTalents() {

        return this.bonusTalents;
    }

    public void setBonusTalents(final byte bonusTalents) {

        this.bonusTalents = bonusTalents;
    }

    private int prevQuestId;

    @javax.persistence.Column(name = "PrevQuestId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getPrevQuestId() {

        return this.prevQuestId;
    }

    public void setPrevQuestId(final int prevQuestId) {

        this.prevQuestId = prevQuestId;
    }

    private int nextQuestId;

    @javax.persistence.Column(name = "NextQuestId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getNextQuestId() {

        return this.nextQuestId;
    }

    public void setNextQuestId(final int nextQuestId) {

        this.nextQuestId = nextQuestId;
    }

    private int exclusiveGroup;

    @javax.persistence.Column(name = "ExclusiveGroup",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getExclusiveGroup() {

        return this.exclusiveGroup;
    }

    public void setExclusiveGroup(final int exclusiveGroup) {

        this.exclusiveGroup = exclusiveGroup;
    }

    private int nextQuestInChain;

    @javax.persistence.Column(name = "NextQuestInChain",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getNextQuestInChain() {

        return this.nextQuestInChain;
    }

    public void setNextQuestInChain(final int nextQuestInChain) {

        this.nextQuestInChain = nextQuestInChain;
    }

    private byte rewXpId;

    @javax.persistence.Column(name = "RewXPId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getRewXpId() {

        return this.rewXpId;
    }

    public void setRewXpId(final byte rewXpId) {

        this.rewXpId = rewXpId;
    }

    private int srcItemId;

    @javax.persistence.Column(name = "SrcItemId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getSrcItemId() {

        return this.srcItemId;
    }

    public void setSrcItemId(final int srcItemId) {

        this.srcItemId = srcItemId;
    }

    private byte srcItemCount;

    @javax.persistence.Column(name = "SrcItemCount",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getSrcItemCount() {

        return this.srcItemCount;
    }

    public void setSrcItemCount(final byte srcItemCount) {

        this.srcItemCount = srcItemCount;
    }

    private int srcSpell;

    @javax.persistence.Column(name = "SrcSpell",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getSrcSpell() {

        return this.srcSpell;
    }

    public void setSrcSpell(final int srcSpell) {

        this.srcSpell = srcSpell;
    }

    private String title;

    @javax.persistence.Column(name = "Title",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getTitle() {

        return this.title;
    }

    public void setTitle(final String title) {

        this.title = title;
    }

    private String details;

    @javax.persistence.Column(name = "Details",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getDetails() {

        return this.details;
    }

    public void setDetails(final String details) {

        this.details = details;
    }

    private String objectives;

    @javax.persistence.Column(name = "Objectives",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getObjectives() {

        return this.objectives;
    }

    public void setObjectives(final String objectives) {

        this.objectives = objectives;
    }

    private String offerRewardText;

    @javax.persistence.Column(name = "OfferRewardText",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getOfferRewardText() {

        return this.offerRewardText;
    }

    public void setOfferRewardText(final String offerRewardText) {

        this.offerRewardText = offerRewardText;
    }

    private String requestItemsText;

    @javax.persistence.Column(name = "RequestItemsText",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getRequestItemsText() {

        return this.requestItemsText;
    }

    public void setRequestItemsText(final String requestItemsText) {

        this.requestItemsText = requestItemsText;
    }

    private String endText;

    @javax.persistence.Column(name = "EndText",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getEndText() {

        return this.endText;
    }

    public void setEndText(final String endText) {

        this.endText = endText;
    }

    private String completedText;

    @javax.persistence.Column(name = "CompletedText",
            nullable = true,
            insertable = true,
            updatable = true,
            precision = 0,
            columnDefinition = "TEXT")
    @Basic
    public String getCompletedText() {

        return this.completedText;
    }

    public void setCompletedText(final String completedText) {

        this.completedText = completedText;
    }

    private String objectiveText1;

    @javax.persistence.Column(name = "ObjectiveText1",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getObjectiveText1() {

        return this.objectiveText1;
    }

    public void setObjectiveText1(final String objectiveText1) {

        this.objectiveText1 = objectiveText1;
    }

    private String objectiveText2;

    @javax.persistence.Column(name = "ObjectiveText2",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getObjectiveText2() {

        return this.objectiveText2;
    }

    public void setObjectiveText2(final String objectiveText2) {

        this.objectiveText2 = objectiveText2;
    }

    private String objectiveText3;

    @javax.persistence.Column(name = "ObjectiveText3",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getObjectiveText3() {

        return this.objectiveText3;
    }

    public void setObjectiveText3(final String objectiveText3) {

        this.objectiveText3 = objectiveText3;
    }

    private String objectiveText4;

    @javax.persistence.Column(name = "ObjectiveText4",
            nullable = true,
            insertable = true,
            updatable = true,
            columnDefinition = "TEXT",
            precision = 0)
    @Basic
    public String getObjectiveText4() {

        return this.objectiveText4;
    }

    public void setObjectiveText4(final String objectiveText4) {

        this.objectiveText4 = objectiveText4;
    }

    private int reqItemId1;

    @javax.persistence.Column(name = "ReqItemId1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqItemId1() {

        return this.reqItemId1;
    }

    public void setReqItemId1(final int reqItemId1) {

        this.reqItemId1 = reqItemId1;
    }

    private int reqItemId2;

    @javax.persistence.Column(name = "ReqItemId2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqItemId2() {

        return this.reqItemId2;
    }

    public void setReqItemId2(final int reqItemId2) {

        this.reqItemId2 = reqItemId2;
    }

    private int reqItemId3;

    @javax.persistence.Column(name = "ReqItemId3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqItemId3() {

        return this.reqItemId3;
    }

    public void setReqItemId3(final int reqItemId3) {

        this.reqItemId3 = reqItemId3;
    }

    private int reqItemId4;

    @javax.persistence.Column(name = "ReqItemId4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqItemId4() {

        return this.reqItemId4;
    }

    public void setReqItemId4(final int reqItemId4) {

        this.reqItemId4 = reqItemId4;
    }

    private int reqItemId5;

    @javax.persistence.Column(name = "ReqItemId5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqItemId5() {

        return this.reqItemId5;
    }

    public void setReqItemId5(final int reqItemId5) {

        this.reqItemId5 = reqItemId5;
    }

    private int reqItemId6;

    @javax.persistence.Column(name = "ReqItemId6",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqItemId6() {

        return this.reqItemId6;
    }

    public void setReqItemId6(final int reqItemId6) {

        this.reqItemId6 = reqItemId6;
    }

    private short reqItemCount1;

    @javax.persistence.Column(name = "ReqItemCount1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqItemCount1() {

        return this.reqItemCount1;
    }

    public void setReqItemCount1(final short reqItemCount1) {

        this.reqItemCount1 = reqItemCount1;
    }

    private short reqItemCount2;

    @javax.persistence.Column(name = "ReqItemCount2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqItemCount2() {

        return this.reqItemCount2;
    }

    public void setReqItemCount2(final short reqItemCount2) {

        this.reqItemCount2 = reqItemCount2;
    }

    private short reqItemCount3;

    @javax.persistence.Column(name = "ReqItemCount3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqItemCount3() {

        return this.reqItemCount3;
    }

    public void setReqItemCount3(final short reqItemCount3) {

        this.reqItemCount3 = reqItemCount3;
    }

    private short reqItemCount4;

    @javax.persistence.Column(name = "ReqItemCount4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqItemCount4() {

        return this.reqItemCount4;
    }

    public void setReqItemCount4(final short reqItemCount4) {

        this.reqItemCount4 = reqItemCount4;
    }

    private short reqItemCount5;

    @javax.persistence.Column(name = "ReqItemCount5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqItemCount5() {

        return this.reqItemCount5;
    }

    public void setReqItemCount5(final short reqItemCount5) {

        this.reqItemCount5 = reqItemCount5;
    }

    private short reqItemCount6;

    @javax.persistence.Column(name = "ReqItemCount6",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqItemCount6() {

        return this.reqItemCount6;
    }

    public void setReqItemCount6(final short reqItemCount6) {

        this.reqItemCount6 = reqItemCount6;
    }

    private int reqSourceId1;

    @javax.persistence.Column(name = "ReqSourceId1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSourceId1() {

        return this.reqSourceId1;
    }

    public void setReqSourceId1(final int reqSourceId1) {

        this.reqSourceId1 = reqSourceId1;
    }

    private int reqSourceId2;

    @javax.persistence.Column(name = "ReqSourceId2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSourceId2() {

        return this.reqSourceId2;
    }

    public void setReqSourceId2(final int reqSourceId2) {

        this.reqSourceId2 = reqSourceId2;
    }

    private int reqSourceId3;

    @javax.persistence.Column(name = "ReqSourceId3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSourceId3() {

        return this.reqSourceId3;
    }

    public void setReqSourceId3(final int reqSourceId3) {

        this.reqSourceId3 = reqSourceId3;
    }

    private int reqSourceId4;

    @javax.persistence.Column(name = "ReqSourceId4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSourceId4() {

        return this.reqSourceId4;
    }

    public void setReqSourceId4(final int reqSourceId4) {

        this.reqSourceId4 = reqSourceId4;
    }

    private short reqSourceCount1;

    @javax.persistence.Column(name = "ReqSourceCount1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqSourceCount1() {

        return this.reqSourceCount1;
    }

    public void setReqSourceCount1(final short reqSourceCount1) {

        this.reqSourceCount1 = reqSourceCount1;
    }

    private short reqSourceCount2;

    @javax.persistence.Column(name = "ReqSourceCount2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqSourceCount2() {

        return this.reqSourceCount2;
    }

    public void setReqSourceCount2(final short reqSourceCount2) {

        this.reqSourceCount2 = reqSourceCount2;
    }

    private short reqSourceCount3;

    @javax.persistence.Column(name = "ReqSourceCount3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqSourceCount3() {

        return this.reqSourceCount3;
    }

    public void setReqSourceCount3(final short reqSourceCount3) {

        this.reqSourceCount3 = reqSourceCount3;
    }

    private short reqSourceCount4;

    @javax.persistence.Column(name = "ReqSourceCount4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqSourceCount4() {

        return this.reqSourceCount4;
    }

    public void setReqSourceCount4(final short reqSourceCount4) {

        this.reqSourceCount4 = reqSourceCount4;
    }

    private int reqCreatureOrGoId1;

    @javax.persistence.Column(name = "ReqCreatureOrGOId1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getReqCreatureOrGoId1() {

        return this.reqCreatureOrGoId1;
    }

    public void setReqCreatureOrGoId1(final int reqCreatureOrGoId1) {

        this.reqCreatureOrGoId1 = reqCreatureOrGoId1;
    }

    private int reqCreatureOrGoId2;

    @javax.persistence.Column(name = "ReqCreatureOrGOId2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getReqCreatureOrGoId2() {

        return this.reqCreatureOrGoId2;
    }

    public void setReqCreatureOrGoId2(final int reqCreatureOrGoId2) {

        this.reqCreatureOrGoId2 = reqCreatureOrGoId2;
    }

    private int reqCreatureOrGoId3;

    @javax.persistence.Column(name = "ReqCreatureOrGOId3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getReqCreatureOrGoId3() {

        return this.reqCreatureOrGoId3;
    }

    public void setReqCreatureOrGoId3(final int reqCreatureOrGoId3) {

        this.reqCreatureOrGoId3 = reqCreatureOrGoId3;
    }

    private int reqCreatureOrGoId4;

    @javax.persistence.Column(name = "ReqCreatureOrGOId4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getReqCreatureOrGoId4() {

        return this.reqCreatureOrGoId4;
    }

    public void setReqCreatureOrGoId4(final int reqCreatureOrGoId4) {

        this.reqCreatureOrGoId4 = reqCreatureOrGoId4;
    }

    private short reqCreatureOrGoCount1;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqCreatureOrGoCount1() {

        return this.reqCreatureOrGoCount1;
    }

    public void setReqCreatureOrGoCount1(final short reqCreatureOrGoCount1) {

        this.reqCreatureOrGoCount1 = reqCreatureOrGoCount1;
    }

    private short reqCreatureOrGoCount2;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqCreatureOrGoCount2() {

        return this.reqCreatureOrGoCount2;
    }

    public void setReqCreatureOrGoCount2(final short reqCreatureOrGoCount2) {

        this.reqCreatureOrGoCount2 = reqCreatureOrGoCount2;
    }

    private short reqCreatureOrGoCount3;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqCreatureOrGoCount3() {

        return this.reqCreatureOrGoCount3;
    }

    public void setReqCreatureOrGoCount3(final short reqCreatureOrGoCount3) {

        this.reqCreatureOrGoCount3 = reqCreatureOrGoCount3;
    }

    private short reqCreatureOrGoCount4;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getReqCreatureOrGoCount4() {

        return this.reqCreatureOrGoCount4;
    }

    public void setReqCreatureOrGoCount4(final short reqCreatureOrGoCount4) {

        this.reqCreatureOrGoCount4 = reqCreatureOrGoCount4;
    }

    private int reqSpellCast1;

    @javax.persistence.Column(name = "ReqSpellCast1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSpellCast1() {

        return this.reqSpellCast1;
    }

    public void setReqSpellCast1(final int reqSpellCast1) {

        this.reqSpellCast1 = reqSpellCast1;
    }

    private int reqSpellCast2;

    @javax.persistence.Column(name = "ReqSpellCast2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSpellCast2() {

        return this.reqSpellCast2;
    }

    public void setReqSpellCast2(final int reqSpellCast2) {

        this.reqSpellCast2 = reqSpellCast2;
    }

    private int reqSpellCast3;

    @javax.persistence.Column(name = "ReqSpellCast3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSpellCast3() {

        return this.reqSpellCast3;
    }

    public void setReqSpellCast3(final int reqSpellCast3) {

        this.reqSpellCast3 = reqSpellCast3;
    }

    private int reqSpellCast4;

    @javax.persistence.Column(name = "ReqSpellCast4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getReqSpellCast4() {

        return this.reqSpellCast4;
    }

    public void setReqSpellCast4(final int reqSpellCast4) {

        this.reqSpellCast4 = reqSpellCast4;
    }

    private int rewChoiceItemId1;

    @javax.persistence.Column(name = "RewChoiceItemId1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewChoiceItemId1() {

        return this.rewChoiceItemId1;
    }

    public void setRewChoiceItemId1(final int rewChoiceItemId1) {

        this.rewChoiceItemId1 = rewChoiceItemId1;
    }

    private int rewChoiceItemId2;

    @javax.persistence.Column(name = "RewChoiceItemId2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewChoiceItemId2() {

        return this.rewChoiceItemId2;
    }

    public void setRewChoiceItemId2(final int rewChoiceItemId2) {

        this.rewChoiceItemId2 = rewChoiceItemId2;
    }

    private int rewChoiceItemId3;

    @javax.persistence.Column(name = "RewChoiceItemId3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewChoiceItemId3() {

        return this.rewChoiceItemId3;
    }

    public void setRewChoiceItemId3(final int rewChoiceItemId3) {

        this.rewChoiceItemId3 = rewChoiceItemId3;
    }

    private int rewChoiceItemId4;

    @javax.persistence.Column(name = "RewChoiceItemId4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewChoiceItemId4() {

        return this.rewChoiceItemId4;
    }

    public void setRewChoiceItemId4(final int rewChoiceItemId4) {

        this.rewChoiceItemId4 = rewChoiceItemId4;
    }

    private int rewChoiceItemId5;

    @javax.persistence.Column(name = "RewChoiceItemId5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewChoiceItemId5() {

        return this.rewChoiceItemId5;
    }

    public void setRewChoiceItemId5(final int rewChoiceItemId5) {

        this.rewChoiceItemId5 = rewChoiceItemId5;
    }

    private int rewChoiceItemId6;

    @javax.persistence.Column(name = "RewChoiceItemId6",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewChoiceItemId6() {

        return this.rewChoiceItemId6;
    }

    public void setRewChoiceItemId6(final int rewChoiceItemId6) {

        this.rewChoiceItemId6 = rewChoiceItemId6;
    }

    private short rewChoiceItemCount1;

    @javax.persistence.Column(name = "RewChoiceItemCount1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewChoiceItemCount1() {

        return this.rewChoiceItemCount1;
    }

    public void setRewChoiceItemCount1(final short rewChoiceItemCount1) {

        this.rewChoiceItemCount1 = rewChoiceItemCount1;
    }

    private short rewChoiceItemCount2;

    @javax.persistence.Column(name = "RewChoiceItemCount2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewChoiceItemCount2() {

        return this.rewChoiceItemCount2;
    }

    public void setRewChoiceItemCount2(final short rewChoiceItemCount2) {

        this.rewChoiceItemCount2 = rewChoiceItemCount2;
    }

    private short rewChoiceItemCount3;

    @javax.persistence.Column(name = "RewChoiceItemCount3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewChoiceItemCount3() {

        return this.rewChoiceItemCount3;
    }

    public void setRewChoiceItemCount3(final short rewChoiceItemCount3) {

        this.rewChoiceItemCount3 = rewChoiceItemCount3;
    }

    private short rewChoiceItemCount4;

    @javax.persistence.Column(name = "RewChoiceItemCount4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewChoiceItemCount4() {

        return this.rewChoiceItemCount4;
    }

    public void setRewChoiceItemCount4(final short rewChoiceItemCount4) {

        this.rewChoiceItemCount4 = rewChoiceItemCount4;
    }

    private short rewChoiceItemCount5;

    @javax.persistence.Column(name = "RewChoiceItemCount5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewChoiceItemCount5() {

        return this.rewChoiceItemCount5;
    }

    public void setRewChoiceItemCount5(final short rewChoiceItemCount5) {

        this.rewChoiceItemCount5 = rewChoiceItemCount5;
    }

    private short rewChoiceItemCount6;

    @javax.persistence.Column(name = "RewChoiceItemCount6",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewChoiceItemCount6() {

        return this.rewChoiceItemCount6;
    }

    public void setRewChoiceItemCount6(final short rewChoiceItemCount6) {

        this.rewChoiceItemCount6 = rewChoiceItemCount6;
    }

    private int rewItemId1;

    @javax.persistence.Column(name = "RewItemId1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewItemId1() {

        return this.rewItemId1;
    }

    public void setRewItemId1(final int rewItemId1) {

        this.rewItemId1 = rewItemId1;
    }

    private int rewItemId2;

    @javax.persistence.Column(name = "RewItemId2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewItemId2() {

        return this.rewItemId2;
    }

    public void setRewItemId2(final int rewItemId2) {

        this.rewItemId2 = rewItemId2;
    }

    private int rewItemId3;

    @javax.persistence.Column(name = "RewItemId3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewItemId3() {

        return this.rewItemId3;
    }

    public void setRewItemId3(final int rewItemId3) {

        this.rewItemId3 = rewItemId3;
    }

    private int rewItemId4;

    @javax.persistence.Column(name = "RewItemId4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewItemId4() {

        return this.rewItemId4;
    }

    public void setRewItemId4(final int rewItemId4) {

        this.rewItemId4 = rewItemId4;
    }

    private short rewItemCount1;

    @javax.persistence.Column(name = "RewItemCount1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewItemCount1() {

        return this.rewItemCount1;
    }

    public void setRewItemCount1(final short rewItemCount1) {

        this.rewItemCount1 = rewItemCount1;
    }

    private short rewItemCount2;

    @javax.persistence.Column(name = "RewItemCount2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewItemCount2() {

        return this.rewItemCount2;
    }

    public void setRewItemCount2(final short rewItemCount2) {

        this.rewItemCount2 = rewItemCount2;
    }

    private short rewItemCount3;

    @javax.persistence.Column(name = "RewItemCount3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewItemCount3() {

        return this.rewItemCount3;
    }

    public void setRewItemCount3(final short rewItemCount3) {

        this.rewItemCount3 = rewItemCount3;
    }

    private short rewItemCount4;

    @javax.persistence.Column(name = "RewItemCount4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewItemCount4() {

        return this.rewItemCount4;
    }

    public void setRewItemCount4(final short rewItemCount4) {

        this.rewItemCount4 = rewItemCount4;
    }

    private short rewRepFaction1;

    @javax.persistence.Column(name = "RewRepFaction1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewRepFaction1() {

        return this.rewRepFaction1;
    }

    public void setRewRepFaction1(final short rewRepFaction1) {

        this.rewRepFaction1 = rewRepFaction1;
    }

    private short rewRepFaction2;

    @javax.persistence.Column(name = "RewRepFaction2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewRepFaction2() {

        return this.rewRepFaction2;
    }

    public void setRewRepFaction2(final short rewRepFaction2) {

        this.rewRepFaction2 = rewRepFaction2;
    }

    private short rewRepFaction3;

    @javax.persistence.Column(name = "RewRepFaction3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewRepFaction3() {

        return this.rewRepFaction3;
    }

    public void setRewRepFaction3(final short rewRepFaction3) {

        this.rewRepFaction3 = rewRepFaction3;
    }

    private short rewRepFaction4;

    @javax.persistence.Column(name = "RewRepFaction4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewRepFaction4() {

        return this.rewRepFaction4;
    }

    public void setRewRepFaction4(final short rewRepFaction4) {

        this.rewRepFaction4 = rewRepFaction4;
    }

    private short rewRepFaction5;

    @javax.persistence.Column(name = "RewRepFaction5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getRewRepFaction5() {

        return this.rewRepFaction5;
    }

    public void setRewRepFaction5(final short rewRepFaction5) {

        this.rewRepFaction5 = rewRepFaction5;
    }

    private byte rewRepValueId1;

    @javax.persistence.Column(name = "RewRepValueId1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getRewRepValueId1() {

        return this.rewRepValueId1;
    }

    public void setRewRepValueId1(final byte rewRepValueId1) {

        this.rewRepValueId1 = rewRepValueId1;
    }

    private byte rewRepValueId2;

    @javax.persistence.Column(name = "RewRepValueId2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getRewRepValueId2() {

        return this.rewRepValueId2;
    }

    public void setRewRepValueId2(final byte rewRepValueId2) {

        this.rewRepValueId2 = rewRepValueId2;
    }

    private byte rewRepValueId3;

    @javax.persistence.Column(name = "RewRepValueId3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getRewRepValueId3() {

        return this.rewRepValueId3;
    }

    public void setRewRepValueId3(final byte rewRepValueId3) {

        this.rewRepValueId3 = rewRepValueId3;
    }

    private byte rewRepValueId4;

    @javax.persistence.Column(name = "RewRepValueId4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getRewRepValueId4() {

        return this.rewRepValueId4;
    }

    public void setRewRepValueId4(final byte rewRepValueId4) {

        this.rewRepValueId4 = rewRepValueId4;
    }

    private byte rewRepValueId5;

    @javax.persistence.Column(name = "RewRepValueId5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 3,
            precision = 0)
    @Basic
    public byte getRewRepValueId5() {

        return this.rewRepValueId5;
    }

    public void setRewRepValueId5(final byte rewRepValueId5) {

        this.rewRepValueId5 = rewRepValueId5;
    }

    private int rewRepValue1;

    @javax.persistence.Column(name = "RewRepValue1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRewRepValue1() {

        return this.rewRepValue1;
    }

    public void setRewRepValue1(final int rewRepValue1) {

        this.rewRepValue1 = rewRepValue1;
    }

    private int rewRepValue2;

    @javax.persistence.Column(name = "RewRepValue2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRewRepValue2() {

        return this.rewRepValue2;
    }

    public void setRewRepValue2(final int rewRepValue2) {

        this.rewRepValue2 = rewRepValue2;
    }

    private int rewRepValue3;

    @javax.persistence.Column(name = "RewRepValue3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRewRepValue3() {

        return this.rewRepValue3;
    }

    public void setRewRepValue3(final int rewRepValue3) {

        this.rewRepValue3 = rewRepValue3;
    }

    private int rewRepValue4;

    @javax.persistence.Column(name = "RewRepValue4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRewRepValue4() {

        return this.rewRepValue4;
    }

    public void setRewRepValue4(final int rewRepValue4) {

        this.rewRepValue4 = rewRepValue4;
    }

    private int rewRepValue5;

    @javax.persistence.Column(name = "RewRepValue5",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 7,
            precision = 0)
    @Basic
    public int getRewRepValue5() {

        return this.rewRepValue5;
    }

    public void setRewRepValue5(final int rewRepValue5) {

        this.rewRepValue5 = rewRepValue5;
    }

    private int rewHonorAddition;

    @javax.persistence.Column(name = "RewHonorAddition",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getRewHonorAddition() {

        return this.rewHonorAddition;
    }

    public void setRewHonorAddition(final int rewHonorAddition) {

        this.rewHonorAddition = rewHonorAddition;
    }

    private float rewHonorMultiplier;

    @javax.persistence.Column(name = "RewHonorMultiplier",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 12,
            precision = 0)
    @Basic
    public float getRewHonorMultiplier() {

        return this.rewHonorMultiplier;
    }

    public void setRewHonorMultiplier(final float rewHonorMultiplier) {

        this.rewHonorMultiplier = rewHonorMultiplier;
    }

    private int rewOrReqMoney;

    @javax.persistence.Column(name = "RewOrReqMoney",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getRewOrReqMoney() {

        return this.rewOrReqMoney;
    }

    public void setRewOrReqMoney(final int rewOrReqMoney) {

        this.rewOrReqMoney = rewOrReqMoney;
    }

    private int rewMoneyMaxLevel;

    @javax.persistence.Column(name = "RewMoneyMaxLevel",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getRewMoneyMaxLevel() {

        return this.rewMoneyMaxLevel;
    }

    public void setRewMoneyMaxLevel(final int rewMoneyMaxLevel) {

        this.rewMoneyMaxLevel = rewMoneyMaxLevel;
    }

    private int rewSpell;

    @javax.persistence.Column(name = "RewSpell",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewSpell() {

        return this.rewSpell;
    }

    public void setRewSpell(final int rewSpell) {

        this.rewSpell = rewSpell;
    }

    private int rewSpellCast;

    @javax.persistence.Column(name = "RewSpellCast",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewSpellCast() {

        return this.rewSpellCast;
    }

    public void setRewSpellCast(final int rewSpellCast) {

        this.rewSpellCast = rewSpellCast;
    }

    private int rewMailTemplateId;

    @javax.persistence.Column(name = "RewMailTemplateId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getRewMailTemplateId() {

        return this.rewMailTemplateId;
    }

    public void setRewMailTemplateId(final int rewMailTemplateId) {

        this.rewMailTemplateId = rewMailTemplateId;
    }

    private int rewMailDelaySecs;

    @javax.persistence.Column(name = "RewMailDelaySecs",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getRewMailDelaySecs() {

        return this.rewMailDelaySecs;
    }

    public void setRewMailDelaySecs(final int rewMailDelaySecs) {

        this.rewMailDelaySecs = rewMailDelaySecs;
    }

    private short pointMapId;

    @javax.persistence.Column(name = "PointMapId",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getPointMapId() {

        return this.pointMapId;
    }

    public void setPointMapId(final short pointMapId) {

        this.pointMapId = pointMapId;
    }

    private float pointX;

    @javax.persistence.Column(name = "PointX",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 12,
            precision = 0)
    @Basic
    public float getPointX() {

        return this.pointX;
    }

    public void setPointX(final float pointX) {

        this.pointX = pointX;
    }

    private float pointY;

    @javax.persistence.Column(name = "PointY",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 12,
            precision = 0)
    @Basic
    public float getPointY() {

        return this.pointY;
    }

    public void setPointY(final float pointY) {

        this.pointY = pointY;
    }

    private int pointOpt;

    @javax.persistence.Column(name = "PointOpt",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getPointOpt() {

        return this.pointOpt;
    }

    public void setPointOpt(final int pointOpt) {

        this.pointOpt = pointOpt;
    }

    private short detailsEmote1;

    @javax.persistence.Column(name = "DetailsEmote1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getDetailsEmote1() {

        return this.detailsEmote1;
    }

    public void setDetailsEmote1(final short detailsEmote1) {

        this.detailsEmote1 = detailsEmote1;
    }

    private short detailsEmote2;

    @javax.persistence.Column(name = "DetailsEmote2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getDetailsEmote2() {

        return this.detailsEmote2;
    }

    public void setDetailsEmote2(final short detailsEmote2) {

        this.detailsEmote2 = detailsEmote2;
    }

    private short detailsEmote3;

    @javax.persistence.Column(name = "DetailsEmote3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getDetailsEmote3() {

        return this.detailsEmote3;
    }

    public void setDetailsEmote3(final short detailsEmote3) {

        this.detailsEmote3 = detailsEmote3;
    }

    private short detailsEmote4;

    @javax.persistence.Column(name = "DetailsEmote4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getDetailsEmote4() {

        return this.detailsEmote4;
    }

    public void setDetailsEmote4(final short detailsEmote4) {

        this.detailsEmote4 = detailsEmote4;
    }

    private int detailsEmoteDelay1;

    @javax.persistence.Column(name = "DetailsEmoteDelay1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getDetailsEmoteDelay1() {

        return this.detailsEmoteDelay1;
    }

    public void setDetailsEmoteDelay1(final int detailsEmoteDelay1) {

        this.detailsEmoteDelay1 = detailsEmoteDelay1;
    }

    private int detailsEmoteDelay2;

    @javax.persistence.Column(name = "DetailsEmoteDelay2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getDetailsEmoteDelay2() {

        return this.detailsEmoteDelay2;
    }

    public void setDetailsEmoteDelay2(final int detailsEmoteDelay2) {

        this.detailsEmoteDelay2 = detailsEmoteDelay2;
    }

    private int detailsEmoteDelay3;

    @javax.persistence.Column(name = "DetailsEmoteDelay3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getDetailsEmoteDelay3() {

        return this.detailsEmoteDelay3;
    }

    public void setDetailsEmoteDelay3(final int detailsEmoteDelay3) {

        this.detailsEmoteDelay3 = detailsEmoteDelay3;
    }

    private int detailsEmoteDelay4;

    @javax.persistence.Column(name = "DetailsEmoteDelay4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getDetailsEmoteDelay4() {

        return this.detailsEmoteDelay4;
    }

    public void setDetailsEmoteDelay4(final int detailsEmoteDelay4) {

        this.detailsEmoteDelay4 = detailsEmoteDelay4;
    }

    private short incompleteEmote;

    @javax.persistence.Column(name = "IncompleteEmote",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getIncompleteEmote() {

        return this.incompleteEmote;
    }

    public void setIncompleteEmote(final short incompleteEmote) {

        this.incompleteEmote = incompleteEmote;
    }

    private short completeEmote;

    @javax.persistence.Column(name = "CompleteEmote",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getCompleteEmote() {

        return this.completeEmote;
    }

    public void setCompleteEmote(final short completeEmote) {

        this.completeEmote = completeEmote;
    }

    private short offerRewardEmote1;

    @javax.persistence.Column(name = "OfferRewardEmote1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getOfferRewardEmote1() {

        return this.offerRewardEmote1;
    }

    public void setOfferRewardEmote1(final short offerRewardEmote1) {

        this.offerRewardEmote1 = offerRewardEmote1;
    }

    private short offerRewardEmote2;

    @javax.persistence.Column(name = "OfferRewardEmote2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getOfferRewardEmote2() {

        return this.offerRewardEmote2;
    }

    public void setOfferRewardEmote2(final short offerRewardEmote2) {

        this.offerRewardEmote2 = offerRewardEmote2;
    }

    private short offerRewardEmote3;

    @javax.persistence.Column(name = "OfferRewardEmote3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getOfferRewardEmote3() {

        return this.offerRewardEmote3;
    }

    public void setOfferRewardEmote3(final short offerRewardEmote3) {

        this.offerRewardEmote3 = offerRewardEmote3;
    }

    private short offerRewardEmote4;

    @javax.persistence.Column(name = "OfferRewardEmote4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 5,
            precision = 0)
    @Basic
    public short getOfferRewardEmote4() {

        return this.offerRewardEmote4;
    }

    public void setOfferRewardEmote4(final short offerRewardEmote4) {

        this.offerRewardEmote4 = offerRewardEmote4;
    }

    private int offerRewardEmoteDelay1;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay1",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay1() {

        return this.offerRewardEmoteDelay1;
    }

    public void setOfferRewardEmoteDelay1(final int offerRewardEmoteDelay1) {

        this.offerRewardEmoteDelay1 = offerRewardEmoteDelay1;
    }

    private int offerRewardEmoteDelay2;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay2",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay2() {

        return this.offerRewardEmoteDelay2;
    }

    public void setOfferRewardEmoteDelay2(final int offerRewardEmoteDelay2) {

        this.offerRewardEmoteDelay2 = offerRewardEmoteDelay2;
    }

    private int offerRewardEmoteDelay3;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay3",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay3() {

        return this.offerRewardEmoteDelay3;
    }

    public void setOfferRewardEmoteDelay3(final int offerRewardEmoteDelay3) {

        this.offerRewardEmoteDelay3 = offerRewardEmoteDelay3;
    }

    private int offerRewardEmoteDelay4;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay4",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 10,
            precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay4() {

        return this.offerRewardEmoteDelay4;
    }

    public void setOfferRewardEmoteDelay4(final int offerRewardEmoteDelay4) {

        this.offerRewardEmoteDelay4 = offerRewardEmoteDelay4;
    }

    private int startScript;

    @javax.persistence.Column(name = "StartScript",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getStartScript() {

        return this.startScript;
    }

    public void setStartScript(final int startScript) {

        this.startScript = startScript;
    }

    private int completeScript;

    @javax.persistence.Column(name = "CompleteScript",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 8,
            precision = 0)
    @Basic
    public int getCompleteScript() {

        return this.completeScript;
    }

    public void setCompleteScript(final int completeScript) {

        this.completeScript = completeScript;
    }

}
