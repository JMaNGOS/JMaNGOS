package org.jmangos.realm.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: Goofy
 * Date: 2012.08.08.
 * Time: 13:30
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "quest_template", schema = "", catalog = "mangos")
@Entity
public class QuestTemplate {
    private int entry;

    @javax.persistence.Column(name = "entry", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Id
    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    private byte method;

    @javax.persistence.Column(name = "Method", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getMethod() {
        return method;
    }

    public void setMethod(byte method) {
        this.method = method;
    }

    private short zoneOrSort;

    @javax.persistence.Column(name = "ZoneOrSort", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getZoneOrSort() {
        return zoneOrSort;
    }

    public void setZoneOrSort(short zoneOrSort) {
        this.zoneOrSort = zoneOrSort;
    }

    private byte minLevel;

    @javax.persistence.Column(name = "MinLevel", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(byte minLevel) {
        this.minLevel = minLevel;
    }

    private short questLevel;

    @javax.persistence.Column(name = "QuestLevel", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getQuestLevel() {
        return questLevel;
    }

    public void setQuestLevel(short questLevel) {
        this.questLevel = questLevel;
    }

    private short type;

    @javax.persistence.Column(name = "Type", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    private short requiredClasses;

    @javax.persistence.Column(name = "RequiredClasses", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredClasses() {
        return requiredClasses;
    }

    public void setRequiredClasses(short requiredClasses) {
        this.requiredClasses = requiredClasses;
    }

    private short requiredRaces;

    @javax.persistence.Column(name = "RequiredRaces", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredRaces() {
        return requiredRaces;
    }

    public void setRequiredRaces(short requiredRaces) {
        this.requiredRaces = requiredRaces;
    }

    private short requiredSkill;

    @javax.persistence.Column(name = "RequiredSkill", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(short requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    private short requiredSkillValue;

    @javax.persistence.Column(name = "RequiredSkillValue", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredSkillValue() {
        return requiredSkillValue;
    }

    public void setRequiredSkillValue(short requiredSkillValue) {
        this.requiredSkillValue = requiredSkillValue;
    }

    private short repObjectiveFaction;

    @javax.persistence.Column(name = "RepObjectiveFaction", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRepObjectiveFaction() {
        return repObjectiveFaction;
    }

    public void setRepObjectiveFaction(short repObjectiveFaction) {
        this.repObjectiveFaction = repObjectiveFaction;
    }

    private int repObjectiveValue;

    @javax.persistence.Column(name = "RepObjectiveValue", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRepObjectiveValue() {
        return repObjectiveValue;
    }

    public void setRepObjectiveValue(int repObjectiveValue) {
        this.repObjectiveValue = repObjectiveValue;
    }

    private short requiredMinRepFaction;

    @javax.persistence.Column(name = "RequiredMinRepFaction", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredMinRepFaction() {
        return requiredMinRepFaction;
    }

    public void setRequiredMinRepFaction(short requiredMinRepFaction) {
        this.requiredMinRepFaction = requiredMinRepFaction;
    }

    private int requiredMinRepValue;

    @javax.persistence.Column(name = "RequiredMinRepValue", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRequiredMinRepValue() {
        return requiredMinRepValue;
    }

    public void setRequiredMinRepValue(int requiredMinRepValue) {
        this.requiredMinRepValue = requiredMinRepValue;
    }

    private short requiredMaxRepFaction;

    @javax.persistence.Column(name = "RequiredMaxRepFaction", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRequiredMaxRepFaction() {
        return requiredMaxRepFaction;
    }

    public void setRequiredMaxRepFaction(short requiredMaxRepFaction) {
        this.requiredMaxRepFaction = requiredMaxRepFaction;
    }

    private int requiredMaxRepValue;

    @javax.persistence.Column(name = "RequiredMaxRepValue", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRequiredMaxRepValue() {
        return requiredMaxRepValue;
    }

    public void setRequiredMaxRepValue(int requiredMaxRepValue) {
        this.requiredMaxRepValue = requiredMaxRepValue;
    }

    private byte suggestedPlayers;

    @javax.persistence.Column(name = "SuggestedPlayers", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSuggestedPlayers() {
        return suggestedPlayers;
    }

    public void setSuggestedPlayers(byte suggestedPlayers) {
        this.suggestedPlayers = suggestedPlayers;
    }

    private int limitTime;

    @javax.persistence.Column(name = "LimitTime", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }

    private int questFlags;

    @javax.persistence.Column(name = "QuestFlags", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getQuestFlags() {
        return questFlags;
    }

    public void setQuestFlags(int questFlags) {
        this.questFlags = questFlags;
    }

    private byte specialFlags;

    @javax.persistence.Column(name = "SpecialFlags", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSpecialFlags() {
        return specialFlags;
    }

    public void setSpecialFlags(byte specialFlags) {
        this.specialFlags = specialFlags;
    }

    private byte charTitleId;

    @javax.persistence.Column(name = "CharTitleId", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getCharTitleId() {
        return charTitleId;
    }

    public void setCharTitleId(byte charTitleId) {
        this.charTitleId = charTitleId;
    }

    private byte playersSlain;

    @javax.persistence.Column(name = "PlayersSlain", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getPlayersSlain() {
        return playersSlain;
    }

    public void setPlayersSlain(byte playersSlain) {
        this.playersSlain = playersSlain;
    }

    private byte bonusTalents;

    @javax.persistence.Column(name = "BonusTalents", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getBonusTalents() {
        return bonusTalents;
    }

    public void setBonusTalents(byte bonusTalents) {
        this.bonusTalents = bonusTalents;
    }

    private int prevQuestId;

    @javax.persistence.Column(name = "PrevQuestId", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getPrevQuestId() {
        return prevQuestId;
    }

    public void setPrevQuestId(int prevQuestId) {
        this.prevQuestId = prevQuestId;
    }

    private int nextQuestId;

    @javax.persistence.Column(name = "NextQuestId", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getNextQuestId() {
        return nextQuestId;
    }

    public void setNextQuestId(int nextQuestId) {
        this.nextQuestId = nextQuestId;
    }

    private int exclusiveGroup;

    @javax.persistence.Column(name = "ExclusiveGroup", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getExclusiveGroup() {
        return exclusiveGroup;
    }

    public void setExclusiveGroup(int exclusiveGroup) {
        this.exclusiveGroup = exclusiveGroup;
    }

    private int nextQuestInChain;

    @javax.persistence.Column(name = "NextQuestInChain", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getNextQuestInChain() {
        return nextQuestInChain;
    }

    public void setNextQuestInChain(int nextQuestInChain) {
        this.nextQuestInChain = nextQuestInChain;
    }

    private byte rewXpId;

    @javax.persistence.Column(name = "RewXPId", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRewXpId() {
        return rewXpId;
    }

    public void setRewXpId(byte rewXpId) {
        this.rewXpId = rewXpId;
    }

    private int srcItemId;

    @javax.persistence.Column(name = "SrcItemId", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSrcItemId() {
        return srcItemId;
    }

    public void setSrcItemId(int srcItemId) {
        this.srcItemId = srcItemId;
    }

    private byte srcItemCount;

    @javax.persistence.Column(name = "SrcItemCount", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getSrcItemCount() {
        return srcItemCount;
    }

    public void setSrcItemCount(byte srcItemCount) {
        this.srcItemCount = srcItemCount;
    }

    private int srcSpell;

    @javax.persistence.Column(name = "SrcSpell", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getSrcSpell() {
        return srcSpell;
    }

    public void setSrcSpell(int srcSpell) {
        this.srcSpell = srcSpell;
    }

    private String title;

    @javax.persistence.Column(name = "Title", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String details;

    @javax.persistence.Column(name = "Details", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    private String objectives;

    @javax.persistence.Column(name = "Objectives", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    private String offerRewardText;

    @javax.persistence.Column(name = "OfferRewardText", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getOfferRewardText() {
        return offerRewardText;
    }

    public void setOfferRewardText(String offerRewardText) {
        this.offerRewardText = offerRewardText;
    }

    private String requestItemsText;

    @javax.persistence.Column(name = "RequestItemsText", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getRequestItemsText() {
        return requestItemsText;
    }

    public void setRequestItemsText(String requestItemsText) {
        this.requestItemsText = requestItemsText;
    }

    private String endText;

    @javax.persistence.Column(name = "EndText", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getEndText() {
        return endText;
    }

    public void setEndText(String endText) {
        this.endText = endText;
    }

    private String completedText;

    @javax.persistence.Column(name = "CompletedText", nullable = true, insertable = true, updatable = true, precision = 0, columnDefinition="TEXT")
    @Basic
    public String getCompletedText() {
        return completedText;
    }

    public void setCompletedText(String completedText) {
        this.completedText = completedText;
    }

    private String objectiveText1;

    @javax.persistence.Column(name = "ObjectiveText1", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getObjectiveText1() {
        return objectiveText1;
    }

    public void setObjectiveText1(String objectiveText1) {
        this.objectiveText1 = objectiveText1;
    }

    private String objectiveText2;

    @javax.persistence.Column(name = "ObjectiveText2", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getObjectiveText2() {
        return objectiveText2;
    }

    public void setObjectiveText2(String objectiveText2) {
        this.objectiveText2 = objectiveText2;
    }

    private String objectiveText3;

    @javax.persistence.Column(name = "ObjectiveText3", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getObjectiveText3() {
        return objectiveText3;
    }

    public void setObjectiveText3(String objectiveText3) {
        this.objectiveText3 = objectiveText3;
    }

    private String objectiveText4;

    @javax.persistence.Column(name = "ObjectiveText4", nullable = true, insertable = true, updatable = true, columnDefinition="TEXT", precision = 0)
    @Basic
    public String getObjectiveText4() {
        return objectiveText4;
    }

    public void setObjectiveText4(String objectiveText4) {
        this.objectiveText4 = objectiveText4;
    }

    private int reqItemId1;

    @javax.persistence.Column(name = "ReqItemId1", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqItemId1() {
        return reqItemId1;
    }

    public void setReqItemId1(int reqItemId1) {
        this.reqItemId1 = reqItemId1;
    }

    private int reqItemId2;

    @javax.persistence.Column(name = "ReqItemId2", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqItemId2() {
        return reqItemId2;
    }

    public void setReqItemId2(int reqItemId2) {
        this.reqItemId2 = reqItemId2;
    }

    private int reqItemId3;

    @javax.persistence.Column(name = "ReqItemId3", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqItemId3() {
        return reqItemId3;
    }

    public void setReqItemId3(int reqItemId3) {
        this.reqItemId3 = reqItemId3;
    }

    private int reqItemId4;

    @javax.persistence.Column(name = "ReqItemId4", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqItemId4() {
        return reqItemId4;
    }

    public void setReqItemId4(int reqItemId4) {
        this.reqItemId4 = reqItemId4;
    }

    private int reqItemId5;

    @javax.persistence.Column(name = "ReqItemId5", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqItemId5() {
        return reqItemId5;
    }

    public void setReqItemId5(int reqItemId5) {
        this.reqItemId5 = reqItemId5;
    }

    private int reqItemId6;

    @javax.persistence.Column(name = "ReqItemId6", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqItemId6() {
        return reqItemId6;
    }

    public void setReqItemId6(int reqItemId6) {
        this.reqItemId6 = reqItemId6;
    }

    private short reqItemCount1;

    @javax.persistence.Column(name = "ReqItemCount1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqItemCount1() {
        return reqItemCount1;
    }

    public void setReqItemCount1(short reqItemCount1) {
        this.reqItemCount1 = reqItemCount1;
    }

    private short reqItemCount2;

    @javax.persistence.Column(name = "ReqItemCount2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqItemCount2() {
        return reqItemCount2;
    }

    public void setReqItemCount2(short reqItemCount2) {
        this.reqItemCount2 = reqItemCount2;
    }

    private short reqItemCount3;

    @javax.persistence.Column(name = "ReqItemCount3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqItemCount3() {
        return reqItemCount3;
    }

    public void setReqItemCount3(short reqItemCount3) {
        this.reqItemCount3 = reqItemCount3;
    }

    private short reqItemCount4;

    @javax.persistence.Column(name = "ReqItemCount4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqItemCount4() {
        return reqItemCount4;
    }

    public void setReqItemCount4(short reqItemCount4) {
        this.reqItemCount4 = reqItemCount4;
    }

    private short reqItemCount5;

    @javax.persistence.Column(name = "ReqItemCount5", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqItemCount5() {
        return reqItemCount5;
    }

    public void setReqItemCount5(short reqItemCount5) {
        this.reqItemCount5 = reqItemCount5;
    }

    private short reqItemCount6;

    @javax.persistence.Column(name = "ReqItemCount6", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqItemCount6() {
        return reqItemCount6;
    }

    public void setReqItemCount6(short reqItemCount6) {
        this.reqItemCount6 = reqItemCount6;
    }

    private int reqSourceId1;

    @javax.persistence.Column(name = "ReqSourceId1", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSourceId1() {
        return reqSourceId1;
    }

    public void setReqSourceId1(int reqSourceId1) {
        this.reqSourceId1 = reqSourceId1;
    }

    private int reqSourceId2;

    @javax.persistence.Column(name = "ReqSourceId2", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSourceId2() {
        return reqSourceId2;
    }

    public void setReqSourceId2(int reqSourceId2) {
        this.reqSourceId2 = reqSourceId2;
    }

    private int reqSourceId3;

    @javax.persistence.Column(name = "ReqSourceId3", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSourceId3() {
        return reqSourceId3;
    }

    public void setReqSourceId3(int reqSourceId3) {
        this.reqSourceId3 = reqSourceId3;
    }

    private int reqSourceId4;

    @javax.persistence.Column(name = "ReqSourceId4", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSourceId4() {
        return reqSourceId4;
    }

    public void setReqSourceId4(int reqSourceId4) {
        this.reqSourceId4 = reqSourceId4;
    }

    private short reqSourceCount1;

    @javax.persistence.Column(name = "ReqSourceCount1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqSourceCount1() {
        return reqSourceCount1;
    }

    public void setReqSourceCount1(short reqSourceCount1) {
        this.reqSourceCount1 = reqSourceCount1;
    }

    private short reqSourceCount2;

    @javax.persistence.Column(name = "ReqSourceCount2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqSourceCount2() {
        return reqSourceCount2;
    }

    public void setReqSourceCount2(short reqSourceCount2) {
        this.reqSourceCount2 = reqSourceCount2;
    }

    private short reqSourceCount3;

    @javax.persistence.Column(name = "ReqSourceCount3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqSourceCount3() {
        return reqSourceCount3;
    }

    public void setReqSourceCount3(short reqSourceCount3) {
        this.reqSourceCount3 = reqSourceCount3;
    }

    private short reqSourceCount4;

    @javax.persistence.Column(name = "ReqSourceCount4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqSourceCount4() {
        return reqSourceCount4;
    }

    public void setReqSourceCount4(short reqSourceCount4) {
        this.reqSourceCount4 = reqSourceCount4;
    }

    private int reqCreatureOrGoId1;

    @javax.persistence.Column(name = "ReqCreatureOrGOId1", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getReqCreatureOrGoId1() {
        return reqCreatureOrGoId1;
    }

    public void setReqCreatureOrGoId1(int reqCreatureOrGoId1) {
        this.reqCreatureOrGoId1 = reqCreatureOrGoId1;
    }

    private int reqCreatureOrGoId2;

    @javax.persistence.Column(name = "ReqCreatureOrGOId2", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getReqCreatureOrGoId2() {
        return reqCreatureOrGoId2;
    }

    public void setReqCreatureOrGoId2(int reqCreatureOrGoId2) {
        this.reqCreatureOrGoId2 = reqCreatureOrGoId2;
    }

    private int reqCreatureOrGoId3;

    @javax.persistence.Column(name = "ReqCreatureOrGOId3", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getReqCreatureOrGoId3() {
        return reqCreatureOrGoId3;
    }

    public void setReqCreatureOrGoId3(int reqCreatureOrGoId3) {
        this.reqCreatureOrGoId3 = reqCreatureOrGoId3;
    }

    private int reqCreatureOrGoId4;

    @javax.persistence.Column(name = "ReqCreatureOrGOId4", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getReqCreatureOrGoId4() {
        return reqCreatureOrGoId4;
    }

    public void setReqCreatureOrGoId4(int reqCreatureOrGoId4) {
        this.reqCreatureOrGoId4 = reqCreatureOrGoId4;
    }

    private short reqCreatureOrGoCount1;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqCreatureOrGoCount1() {
        return reqCreatureOrGoCount1;
    }

    public void setReqCreatureOrGoCount1(short reqCreatureOrGoCount1) {
        this.reqCreatureOrGoCount1 = reqCreatureOrGoCount1;
    }

    private short reqCreatureOrGoCount2;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqCreatureOrGoCount2() {
        return reqCreatureOrGoCount2;
    }

    public void setReqCreatureOrGoCount2(short reqCreatureOrGoCount2) {
        this.reqCreatureOrGoCount2 = reqCreatureOrGoCount2;
    }

    private short reqCreatureOrGoCount3;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqCreatureOrGoCount3() {
        return reqCreatureOrGoCount3;
    }

    public void setReqCreatureOrGoCount3(short reqCreatureOrGoCount3) {
        this.reqCreatureOrGoCount3 = reqCreatureOrGoCount3;
    }

    private short reqCreatureOrGoCount4;

    @javax.persistence.Column(name = "ReqCreatureOrGOCount4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getReqCreatureOrGoCount4() {
        return reqCreatureOrGoCount4;
    }

    public void setReqCreatureOrGoCount4(short reqCreatureOrGoCount4) {
        this.reqCreatureOrGoCount4 = reqCreatureOrGoCount4;
    }

    private int reqSpellCast1;

    @javax.persistence.Column(name = "ReqSpellCast1", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSpellCast1() {
        return reqSpellCast1;
    }

    public void setReqSpellCast1(int reqSpellCast1) {
        this.reqSpellCast1 = reqSpellCast1;
    }

    private int reqSpellCast2;

    @javax.persistence.Column(name = "ReqSpellCast2", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSpellCast2() {
        return reqSpellCast2;
    }

    public void setReqSpellCast2(int reqSpellCast2) {
        this.reqSpellCast2 = reqSpellCast2;
    }

    private int reqSpellCast3;

    @javax.persistence.Column(name = "ReqSpellCast3", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSpellCast3() {
        return reqSpellCast3;
    }

    public void setReqSpellCast3(int reqSpellCast3) {
        this.reqSpellCast3 = reqSpellCast3;
    }

    private int reqSpellCast4;

    @javax.persistence.Column(name = "ReqSpellCast4", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getReqSpellCast4() {
        return reqSpellCast4;
    }

    public void setReqSpellCast4(int reqSpellCast4) {
        this.reqSpellCast4 = reqSpellCast4;
    }

    private int rewChoiceItemId1;

    @javax.persistence.Column(name = "RewChoiceItemId1", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewChoiceItemId1() {
        return rewChoiceItemId1;
    }

    public void setRewChoiceItemId1(int rewChoiceItemId1) {
        this.rewChoiceItemId1 = rewChoiceItemId1;
    }

    private int rewChoiceItemId2;

    @javax.persistence.Column(name = "RewChoiceItemId2", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewChoiceItemId2() {
        return rewChoiceItemId2;
    }

    public void setRewChoiceItemId2(int rewChoiceItemId2) {
        this.rewChoiceItemId2 = rewChoiceItemId2;
    }

    private int rewChoiceItemId3;

    @javax.persistence.Column(name = "RewChoiceItemId3", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewChoiceItemId3() {
        return rewChoiceItemId3;
    }

    public void setRewChoiceItemId3(int rewChoiceItemId3) {
        this.rewChoiceItemId3 = rewChoiceItemId3;
    }

    private int rewChoiceItemId4;

    @javax.persistence.Column(name = "RewChoiceItemId4", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewChoiceItemId4() {
        return rewChoiceItemId4;
    }

    public void setRewChoiceItemId4(int rewChoiceItemId4) {
        this.rewChoiceItemId4 = rewChoiceItemId4;
    }

    private int rewChoiceItemId5;

    @javax.persistence.Column(name = "RewChoiceItemId5", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewChoiceItemId5() {
        return rewChoiceItemId5;
    }

    public void setRewChoiceItemId5(int rewChoiceItemId5) {
        this.rewChoiceItemId5 = rewChoiceItemId5;
    }

    private int rewChoiceItemId6;

    @javax.persistence.Column(name = "RewChoiceItemId6", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewChoiceItemId6() {
        return rewChoiceItemId6;
    }

    public void setRewChoiceItemId6(int rewChoiceItemId6) {
        this.rewChoiceItemId6 = rewChoiceItemId6;
    }

    private short rewChoiceItemCount1;

    @javax.persistence.Column(name = "RewChoiceItemCount1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewChoiceItemCount1() {
        return rewChoiceItemCount1;
    }

    public void setRewChoiceItemCount1(short rewChoiceItemCount1) {
        this.rewChoiceItemCount1 = rewChoiceItemCount1;
    }

    private short rewChoiceItemCount2;

    @javax.persistence.Column(name = "RewChoiceItemCount2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewChoiceItemCount2() {
        return rewChoiceItemCount2;
    }

    public void setRewChoiceItemCount2(short rewChoiceItemCount2) {
        this.rewChoiceItemCount2 = rewChoiceItemCount2;
    }

    private short rewChoiceItemCount3;

    @javax.persistence.Column(name = "RewChoiceItemCount3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewChoiceItemCount3() {
        return rewChoiceItemCount3;
    }

    public void setRewChoiceItemCount3(short rewChoiceItemCount3) {
        this.rewChoiceItemCount3 = rewChoiceItemCount3;
    }

    private short rewChoiceItemCount4;

    @javax.persistence.Column(name = "RewChoiceItemCount4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewChoiceItemCount4() {
        return rewChoiceItemCount4;
    }

    public void setRewChoiceItemCount4(short rewChoiceItemCount4) {
        this.rewChoiceItemCount4 = rewChoiceItemCount4;
    }

    private short rewChoiceItemCount5;

    @javax.persistence.Column(name = "RewChoiceItemCount5", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewChoiceItemCount5() {
        return rewChoiceItemCount5;
    }

    public void setRewChoiceItemCount5(short rewChoiceItemCount5) {
        this.rewChoiceItemCount5 = rewChoiceItemCount5;
    }

    private short rewChoiceItemCount6;

    @javax.persistence.Column(name = "RewChoiceItemCount6", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewChoiceItemCount6() {
        return rewChoiceItemCount6;
    }

    public void setRewChoiceItemCount6(short rewChoiceItemCount6) {
        this.rewChoiceItemCount6 = rewChoiceItemCount6;
    }

    private int rewItemId1;

    @javax.persistence.Column(name = "RewItemId1", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewItemId1() {
        return rewItemId1;
    }

    public void setRewItemId1(int rewItemId1) {
        this.rewItemId1 = rewItemId1;
    }

    private int rewItemId2;

    @javax.persistence.Column(name = "RewItemId2", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewItemId2() {
        return rewItemId2;
    }

    public void setRewItemId2(int rewItemId2) {
        this.rewItemId2 = rewItemId2;
    }

    private int rewItemId3;

    @javax.persistence.Column(name = "RewItemId3", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewItemId3() {
        return rewItemId3;
    }

    public void setRewItemId3(int rewItemId3) {
        this.rewItemId3 = rewItemId3;
    }

    private int rewItemId4;

    @javax.persistence.Column(name = "RewItemId4", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewItemId4() {
        return rewItemId4;
    }

    public void setRewItemId4(int rewItemId4) {
        this.rewItemId4 = rewItemId4;
    }

    private short rewItemCount1;

    @javax.persistence.Column(name = "RewItemCount1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewItemCount1() {
        return rewItemCount1;
    }

    public void setRewItemCount1(short rewItemCount1) {
        this.rewItemCount1 = rewItemCount1;
    }

    private short rewItemCount2;

    @javax.persistence.Column(name = "RewItemCount2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewItemCount2() {
        return rewItemCount2;
    }

    public void setRewItemCount2(short rewItemCount2) {
        this.rewItemCount2 = rewItemCount2;
    }

    private short rewItemCount3;

    @javax.persistence.Column(name = "RewItemCount3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewItemCount3() {
        return rewItemCount3;
    }

    public void setRewItemCount3(short rewItemCount3) {
        this.rewItemCount3 = rewItemCount3;
    }

    private short rewItemCount4;

    @javax.persistence.Column(name = "RewItemCount4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewItemCount4() {
        return rewItemCount4;
    }

    public void setRewItemCount4(short rewItemCount4) {
        this.rewItemCount4 = rewItemCount4;
    }

    private short rewRepFaction1;

    @javax.persistence.Column(name = "RewRepFaction1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewRepFaction1() {
        return rewRepFaction1;
    }

    public void setRewRepFaction1(short rewRepFaction1) {
        this.rewRepFaction1 = rewRepFaction1;
    }

    private short rewRepFaction2;

    @javax.persistence.Column(name = "RewRepFaction2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewRepFaction2() {
        return rewRepFaction2;
    }

    public void setRewRepFaction2(short rewRepFaction2) {
        this.rewRepFaction2 = rewRepFaction2;
    }

    private short rewRepFaction3;

    @javax.persistence.Column(name = "RewRepFaction3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewRepFaction3() {
        return rewRepFaction3;
    }

    public void setRewRepFaction3(short rewRepFaction3) {
        this.rewRepFaction3 = rewRepFaction3;
    }

    private short rewRepFaction4;

    @javax.persistence.Column(name = "RewRepFaction4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewRepFaction4() {
        return rewRepFaction4;
    }

    public void setRewRepFaction4(short rewRepFaction4) {
        this.rewRepFaction4 = rewRepFaction4;
    }

    private short rewRepFaction5;

    @javax.persistence.Column(name = "RewRepFaction5", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getRewRepFaction5() {
        return rewRepFaction5;
    }

    public void setRewRepFaction5(short rewRepFaction5) {
        this.rewRepFaction5 = rewRepFaction5;
    }

    private byte rewRepValueId1;

    @javax.persistence.Column(name = "RewRepValueId1", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRewRepValueId1() {
        return rewRepValueId1;
    }

    public void setRewRepValueId1(byte rewRepValueId1) {
        this.rewRepValueId1 = rewRepValueId1;
    }

    private byte rewRepValueId2;

    @javax.persistence.Column(name = "RewRepValueId2", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRewRepValueId2() {
        return rewRepValueId2;
    }

    public void setRewRepValueId2(byte rewRepValueId2) {
        this.rewRepValueId2 = rewRepValueId2;
    }

    private byte rewRepValueId3;

    @javax.persistence.Column(name = "RewRepValueId3", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRewRepValueId3() {
        return rewRepValueId3;
    }

    public void setRewRepValueId3(byte rewRepValueId3) {
        this.rewRepValueId3 = rewRepValueId3;
    }

    private byte rewRepValueId4;

    @javax.persistence.Column(name = "RewRepValueId4", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRewRepValueId4() {
        return rewRepValueId4;
    }

    public void setRewRepValueId4(byte rewRepValueId4) {
        this.rewRepValueId4 = rewRepValueId4;
    }

    private byte rewRepValueId5;

    @javax.persistence.Column(name = "RewRepValueId5", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public byte getRewRepValueId5() {
        return rewRepValueId5;
    }

    public void setRewRepValueId5(byte rewRepValueId5) {
        this.rewRepValueId5 = rewRepValueId5;
    }

    private int rewRepValue1;

    @javax.persistence.Column(name = "RewRepValue1", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRewRepValue1() {
        return rewRepValue1;
    }

    public void setRewRepValue1(int rewRepValue1) {
        this.rewRepValue1 = rewRepValue1;
    }

    private int rewRepValue2;

    @javax.persistence.Column(name = "RewRepValue2", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRewRepValue2() {
        return rewRepValue2;
    }

    public void setRewRepValue2(int rewRepValue2) {
        this.rewRepValue2 = rewRepValue2;
    }

    private int rewRepValue3;

    @javax.persistence.Column(name = "RewRepValue3", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRewRepValue3() {
        return rewRepValue3;
    }

    public void setRewRepValue3(int rewRepValue3) {
        this.rewRepValue3 = rewRepValue3;
    }

    private int rewRepValue4;

    @javax.persistence.Column(name = "RewRepValue4", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRewRepValue4() {
        return rewRepValue4;
    }

    public void setRewRepValue4(int rewRepValue4) {
        this.rewRepValue4 = rewRepValue4;
    }

    private int rewRepValue5;

    @javax.persistence.Column(name = "RewRepValue5", nullable = false, insertable = true, updatable = true, length = 7, precision = 0)
    @Basic
    public int getRewRepValue5() {
        return rewRepValue5;
    }

    public void setRewRepValue5(int rewRepValue5) {
        this.rewRepValue5 = rewRepValue5;
    }

    private int rewHonorAddition;

    @javax.persistence.Column(name = "RewHonorAddition", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getRewHonorAddition() {
        return rewHonorAddition;
    }

    public void setRewHonorAddition(int rewHonorAddition) {
        this.rewHonorAddition = rewHonorAddition;
    }

    private float rewHonorMultiplier;

    @javax.persistence.Column(name = "RewHonorMultiplier", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getRewHonorMultiplier() {
        return rewHonorMultiplier;
    }

    public void setRewHonorMultiplier(float rewHonorMultiplier) {
        this.rewHonorMultiplier = rewHonorMultiplier;
    }

    private int rewOrReqMoney;

    @javax.persistence.Column(name = "RewOrReqMoney", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getRewOrReqMoney() {
        return rewOrReqMoney;
    }

    public void setRewOrReqMoney(int rewOrReqMoney) {
        this.rewOrReqMoney = rewOrReqMoney;
    }

    private int rewMoneyMaxLevel;

    @javax.persistence.Column(name = "RewMoneyMaxLevel", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getRewMoneyMaxLevel() {
        return rewMoneyMaxLevel;
    }

    public void setRewMoneyMaxLevel(int rewMoneyMaxLevel) {
        this.rewMoneyMaxLevel = rewMoneyMaxLevel;
    }

    private int rewSpell;

    @javax.persistence.Column(name = "RewSpell", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewSpell() {
        return rewSpell;
    }

    public void setRewSpell(int rewSpell) {
        this.rewSpell = rewSpell;
    }

    private int rewSpellCast;

    @javax.persistence.Column(name = "RewSpellCast", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewSpellCast() {
        return rewSpellCast;
    }

    public void setRewSpellCast(int rewSpellCast) {
        this.rewSpellCast = rewSpellCast;
    }

    private int rewMailTemplateId;

    @javax.persistence.Column(name = "RewMailTemplateId", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getRewMailTemplateId() {
        return rewMailTemplateId;
    }

    public void setRewMailTemplateId(int rewMailTemplateId) {
        this.rewMailTemplateId = rewMailTemplateId;
    }

    private int rewMailDelaySecs;

    @javax.persistence.Column(name = "RewMailDelaySecs", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getRewMailDelaySecs() {
        return rewMailDelaySecs;
    }

    public void setRewMailDelaySecs(int rewMailDelaySecs) {
        this.rewMailDelaySecs = rewMailDelaySecs;
    }

    private short pointMapId;

    @javax.persistence.Column(name = "PointMapId", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getPointMapId() {
        return pointMapId;
    }

    public void setPointMapId(short pointMapId) {
        this.pointMapId = pointMapId;
    }

    private float pointX;

    @javax.persistence.Column(name = "PointX", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getPointX() {
        return pointX;
    }

    public void setPointX(float pointX) {
        this.pointX = pointX;
    }

    private float pointY;

    @javax.persistence.Column(name = "PointY", nullable = false, insertable = true, updatable = true, length = 12, precision = 0)
    @Basic
    public float getPointY() {
        return pointY;
    }

    public void setPointY(float pointY) {
        this.pointY = pointY;
    }

    private int pointOpt;

    @javax.persistence.Column(name = "PointOpt", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getPointOpt() {
        return pointOpt;
    }

    public void setPointOpt(int pointOpt) {
        this.pointOpt = pointOpt;
    }

    private short detailsEmote1;

    @javax.persistence.Column(name = "DetailsEmote1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getDetailsEmote1() {
        return detailsEmote1;
    }

    public void setDetailsEmote1(short detailsEmote1) {
        this.detailsEmote1 = detailsEmote1;
    }

    private short detailsEmote2;

    @javax.persistence.Column(name = "DetailsEmote2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getDetailsEmote2() {
        return detailsEmote2;
    }

    public void setDetailsEmote2(short detailsEmote2) {
        this.detailsEmote2 = detailsEmote2;
    }

    private short detailsEmote3;

    @javax.persistence.Column(name = "DetailsEmote3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getDetailsEmote3() {
        return detailsEmote3;
    }

    public void setDetailsEmote3(short detailsEmote3) {
        this.detailsEmote3 = detailsEmote3;
    }

    private short detailsEmote4;

    @javax.persistence.Column(name = "DetailsEmote4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getDetailsEmote4() {
        return detailsEmote4;
    }

    public void setDetailsEmote4(short detailsEmote4) {
        this.detailsEmote4 = detailsEmote4;
    }

    private int detailsEmoteDelay1;

    @javax.persistence.Column(name = "DetailsEmoteDelay1", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDetailsEmoteDelay1() {
        return detailsEmoteDelay1;
    }

    public void setDetailsEmoteDelay1(int detailsEmoteDelay1) {
        this.detailsEmoteDelay1 = detailsEmoteDelay1;
    }

    private int detailsEmoteDelay2;

    @javax.persistence.Column(name = "DetailsEmoteDelay2", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDetailsEmoteDelay2() {
        return detailsEmoteDelay2;
    }

    public void setDetailsEmoteDelay2(int detailsEmoteDelay2) {
        this.detailsEmoteDelay2 = detailsEmoteDelay2;
    }

    private int detailsEmoteDelay3;

    @javax.persistence.Column(name = "DetailsEmoteDelay3", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDetailsEmoteDelay3() {
        return detailsEmoteDelay3;
    }

    public void setDetailsEmoteDelay3(int detailsEmoteDelay3) {
        this.detailsEmoteDelay3 = detailsEmoteDelay3;
    }

    private int detailsEmoteDelay4;

    @javax.persistence.Column(name = "DetailsEmoteDelay4", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getDetailsEmoteDelay4() {
        return detailsEmoteDelay4;
    }

    public void setDetailsEmoteDelay4(int detailsEmoteDelay4) {
        this.detailsEmoteDelay4 = detailsEmoteDelay4;
    }

    private short incompleteEmote;

    @javax.persistence.Column(name = "IncompleteEmote", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getIncompleteEmote() {
        return incompleteEmote;
    }

    public void setIncompleteEmote(short incompleteEmote) {
        this.incompleteEmote = incompleteEmote;
    }

    private short completeEmote;

    @javax.persistence.Column(name = "CompleteEmote", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getCompleteEmote() {
        return completeEmote;
    }

    public void setCompleteEmote(short completeEmote) {
        this.completeEmote = completeEmote;
    }

    private short offerRewardEmote1;

    @javax.persistence.Column(name = "OfferRewardEmote1", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getOfferRewardEmote1() {
        return offerRewardEmote1;
    }

    public void setOfferRewardEmote1(short offerRewardEmote1) {
        this.offerRewardEmote1 = offerRewardEmote1;
    }

    private short offerRewardEmote2;

    @javax.persistence.Column(name = "OfferRewardEmote2", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getOfferRewardEmote2() {
        return offerRewardEmote2;
    }

    public void setOfferRewardEmote2(short offerRewardEmote2) {
        this.offerRewardEmote2 = offerRewardEmote2;
    }

    private short offerRewardEmote3;

    @javax.persistence.Column(name = "OfferRewardEmote3", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getOfferRewardEmote3() {
        return offerRewardEmote3;
    }

    public void setOfferRewardEmote3(short offerRewardEmote3) {
        this.offerRewardEmote3 = offerRewardEmote3;
    }

    private short offerRewardEmote4;

    @javax.persistence.Column(name = "OfferRewardEmote4", nullable = false, insertable = true, updatable = true, length = 5, precision = 0)
    @Basic
    public short getOfferRewardEmote4() {
        return offerRewardEmote4;
    }

    public void setOfferRewardEmote4(short offerRewardEmote4) {
        this.offerRewardEmote4 = offerRewardEmote4;
    }

    private int offerRewardEmoteDelay1;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay1", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay1() {
        return offerRewardEmoteDelay1;
    }

    public void setOfferRewardEmoteDelay1(int offerRewardEmoteDelay1) {
        this.offerRewardEmoteDelay1 = offerRewardEmoteDelay1;
    }

    private int offerRewardEmoteDelay2;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay2", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay2() {
        return offerRewardEmoteDelay2;
    }

    public void setOfferRewardEmoteDelay2(int offerRewardEmoteDelay2) {
        this.offerRewardEmoteDelay2 = offerRewardEmoteDelay2;
    }

    private int offerRewardEmoteDelay3;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay3", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay3() {
        return offerRewardEmoteDelay3;
    }

    public void setOfferRewardEmoteDelay3(int offerRewardEmoteDelay3) {
        this.offerRewardEmoteDelay3 = offerRewardEmoteDelay3;
    }

    private int offerRewardEmoteDelay4;

    @javax.persistence.Column(name = "OfferRewardEmoteDelay4", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getOfferRewardEmoteDelay4() {
        return offerRewardEmoteDelay4;
    }

    public void setOfferRewardEmoteDelay4(int offerRewardEmoteDelay4) {
        this.offerRewardEmoteDelay4 = offerRewardEmoteDelay4;
    }

    private int startScript;

    @javax.persistence.Column(name = "StartScript", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getStartScript() {
        return startScript;
    }

    public void setStartScript(int startScript) {
        this.startScript = startScript;
    }

    private int completeScript;

    @javax.persistence.Column(name = "CompleteScript", nullable = false, insertable = true, updatable = true, length = 8, precision = 0)
    @Basic
    public int getCompleteScript() {
        return completeScript;
    }

    public void setCompleteScript(int completeScript) {
        this.completeScript = completeScript;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestTemplate that = (QuestTemplate) o;

        if (bonusTalents != that.bonusTalents) return false;
        if (charTitleId != that.charTitleId) return false;
        if (completeEmote != that.completeEmote) return false;
        if (completeScript != that.completeScript) return false;
        if (detailsEmote1 != that.detailsEmote1) return false;
        if (detailsEmote2 != that.detailsEmote2) return false;
        if (detailsEmote3 != that.detailsEmote3) return false;
        if (detailsEmote4 != that.detailsEmote4) return false;
        if (detailsEmoteDelay1 != that.detailsEmoteDelay1) return false;
        if (detailsEmoteDelay2 != that.detailsEmoteDelay2) return false;
        if (detailsEmoteDelay3 != that.detailsEmoteDelay3) return false;
        if (detailsEmoteDelay4 != that.detailsEmoteDelay4) return false;
        if (entry != that.entry) return false;
        if (exclusiveGroup != that.exclusiveGroup) return false;
        if (incompleteEmote != that.incompleteEmote) return false;
        if (limitTime != that.limitTime) return false;
        if (method != that.method) return false;
        if (minLevel != that.minLevel) return false;
        if (nextQuestId != that.nextQuestId) return false;
        if (nextQuestInChain != that.nextQuestInChain) return false;
        if (offerRewardEmote1 != that.offerRewardEmote1) return false;
        if (offerRewardEmote2 != that.offerRewardEmote2) return false;
        if (offerRewardEmote3 != that.offerRewardEmote3) return false;
        if (offerRewardEmote4 != that.offerRewardEmote4) return false;
        if (offerRewardEmoteDelay1 != that.offerRewardEmoteDelay1) return false;
        if (offerRewardEmoteDelay2 != that.offerRewardEmoteDelay2) return false;
        if (offerRewardEmoteDelay3 != that.offerRewardEmoteDelay3) return false;
        if (offerRewardEmoteDelay4 != that.offerRewardEmoteDelay4) return false;
        if (playersSlain != that.playersSlain) return false;
        if (pointMapId != that.pointMapId) return false;
        if (pointOpt != that.pointOpt) return false;
        if (Float.compare(that.pointX, pointX) != 0) return false;
        if (Float.compare(that.pointY, pointY) != 0) return false;
        if (prevQuestId != that.prevQuestId) return false;
        if (questFlags != that.questFlags) return false;
        if (questLevel != that.questLevel) return false;
        if (repObjectiveFaction != that.repObjectiveFaction) return false;
        if (repObjectiveValue != that.repObjectiveValue) return false;
        if (reqCreatureOrGoCount1 != that.reqCreatureOrGoCount1) return false;
        if (reqCreatureOrGoCount2 != that.reqCreatureOrGoCount2) return false;
        if (reqCreatureOrGoCount3 != that.reqCreatureOrGoCount3) return false;
        if (reqCreatureOrGoCount4 != that.reqCreatureOrGoCount4) return false;
        if (reqCreatureOrGoId1 != that.reqCreatureOrGoId1) return false;
        if (reqCreatureOrGoId2 != that.reqCreatureOrGoId2) return false;
        if (reqCreatureOrGoId3 != that.reqCreatureOrGoId3) return false;
        if (reqCreatureOrGoId4 != that.reqCreatureOrGoId4) return false;
        if (reqItemCount1 != that.reqItemCount1) return false;
        if (reqItemCount2 != that.reqItemCount2) return false;
        if (reqItemCount3 != that.reqItemCount3) return false;
        if (reqItemCount4 != that.reqItemCount4) return false;
        if (reqItemCount5 != that.reqItemCount5) return false;
        if (reqItemCount6 != that.reqItemCount6) return false;
        if (reqItemId1 != that.reqItemId1) return false;
        if (reqItemId2 != that.reqItemId2) return false;
        if (reqItemId3 != that.reqItemId3) return false;
        if (reqItemId4 != that.reqItemId4) return false;
        if (reqItemId5 != that.reqItemId5) return false;
        if (reqItemId6 != that.reqItemId6) return false;
        if (reqSourceCount1 != that.reqSourceCount1) return false;
        if (reqSourceCount2 != that.reqSourceCount2) return false;
        if (reqSourceCount3 != that.reqSourceCount3) return false;
        if (reqSourceCount4 != that.reqSourceCount4) return false;
        if (reqSourceId1 != that.reqSourceId1) return false;
        if (reqSourceId2 != that.reqSourceId2) return false;
        if (reqSourceId3 != that.reqSourceId3) return false;
        if (reqSourceId4 != that.reqSourceId4) return false;
        if (reqSpellCast1 != that.reqSpellCast1) return false;
        if (reqSpellCast2 != that.reqSpellCast2) return false;
        if (reqSpellCast3 != that.reqSpellCast3) return false;
        if (reqSpellCast4 != that.reqSpellCast4) return false;
        if (requiredClasses != that.requiredClasses) return false;
        if (requiredMaxRepFaction != that.requiredMaxRepFaction) return false;
        if (requiredMaxRepValue != that.requiredMaxRepValue) return false;
        if (requiredMinRepFaction != that.requiredMinRepFaction) return false;
        if (requiredMinRepValue != that.requiredMinRepValue) return false;
        if (requiredRaces != that.requiredRaces) return false;
        if (requiredSkill != that.requiredSkill) return false;
        if (requiredSkillValue != that.requiredSkillValue) return false;
        if (rewChoiceItemCount1 != that.rewChoiceItemCount1) return false;
        if (rewChoiceItemCount2 != that.rewChoiceItemCount2) return false;
        if (rewChoiceItemCount3 != that.rewChoiceItemCount3) return false;
        if (rewChoiceItemCount4 != that.rewChoiceItemCount4) return false;
        if (rewChoiceItemCount5 != that.rewChoiceItemCount5) return false;
        if (rewChoiceItemCount6 != that.rewChoiceItemCount6) return false;
        if (rewChoiceItemId1 != that.rewChoiceItemId1) return false;
        if (rewChoiceItemId2 != that.rewChoiceItemId2) return false;
        if (rewChoiceItemId3 != that.rewChoiceItemId3) return false;
        if (rewChoiceItemId4 != that.rewChoiceItemId4) return false;
        if (rewChoiceItemId5 != that.rewChoiceItemId5) return false;
        if (rewChoiceItemId6 != that.rewChoiceItemId6) return false;
        if (rewHonorAddition != that.rewHonorAddition) return false;
        if (Float.compare(that.rewHonorMultiplier, rewHonorMultiplier) != 0) return false;
        if (rewItemCount1 != that.rewItemCount1) return false;
        if (rewItemCount2 != that.rewItemCount2) return false;
        if (rewItemCount3 != that.rewItemCount3) return false;
        if (rewItemCount4 != that.rewItemCount4) return false;
        if (rewItemId1 != that.rewItemId1) return false;
        if (rewItemId2 != that.rewItemId2) return false;
        if (rewItemId3 != that.rewItemId3) return false;
        if (rewItemId4 != that.rewItemId4) return false;
        if (rewMailDelaySecs != that.rewMailDelaySecs) return false;
        if (rewMailTemplateId != that.rewMailTemplateId) return false;
        if (rewMoneyMaxLevel != that.rewMoneyMaxLevel) return false;
        if (rewOrReqMoney != that.rewOrReqMoney) return false;
        if (rewRepFaction1 != that.rewRepFaction1) return false;
        if (rewRepFaction2 != that.rewRepFaction2) return false;
        if (rewRepFaction3 != that.rewRepFaction3) return false;
        if (rewRepFaction4 != that.rewRepFaction4) return false;
        if (rewRepFaction5 != that.rewRepFaction5) return false;
        if (rewRepValue1 != that.rewRepValue1) return false;
        if (rewRepValue2 != that.rewRepValue2) return false;
        if (rewRepValue3 != that.rewRepValue3) return false;
        if (rewRepValue4 != that.rewRepValue4) return false;
        if (rewRepValue5 != that.rewRepValue5) return false;
        if (rewRepValueId1 != that.rewRepValueId1) return false;
        if (rewRepValueId2 != that.rewRepValueId2) return false;
        if (rewRepValueId3 != that.rewRepValueId3) return false;
        if (rewRepValueId4 != that.rewRepValueId4) return false;
        if (rewRepValueId5 != that.rewRepValueId5) return false;
        if (rewSpell != that.rewSpell) return false;
        if (rewSpellCast != that.rewSpellCast) return false;
        if (rewXpId != that.rewXpId) return false;
        if (specialFlags != that.specialFlags) return false;
        if (srcItemCount != that.srcItemCount) return false;
        if (srcItemId != that.srcItemId) return false;
        if (srcSpell != that.srcSpell) return false;
        if (startScript != that.startScript) return false;
        if (suggestedPlayers != that.suggestedPlayers) return false;
        if (type != that.type) return false;
        if (zoneOrSort != that.zoneOrSort) return false;
        if (completedText != null ? !completedText.equals(that.completedText) : that.completedText != null)
            return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (endText != null ? !endText.equals(that.endText) : that.endText != null) return false;
        if (objectiveText1 != null ? !objectiveText1.equals(that.objectiveText1) : that.objectiveText1 != null)
            return false;
        if (objectiveText2 != null ? !objectiveText2.equals(that.objectiveText2) : that.objectiveText2 != null)
            return false;
        if (objectiveText3 != null ? !objectiveText3.equals(that.objectiveText3) : that.objectiveText3 != null)
            return false;
        if (objectiveText4 != null ? !objectiveText4.equals(that.objectiveText4) : that.objectiveText4 != null)
            return false;
        if (objectives != null ? !objectives.equals(that.objectives) : that.objectives != null) return false;
        if (offerRewardText != null ? !offerRewardText.equals(that.offerRewardText) : that.offerRewardText != null)
            return false;
        if (requestItemsText != null ? !requestItemsText.equals(that.requestItemsText) : that.requestItemsText != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = entry;
        result = 31 * result + (int) method;
        result = 31 * result + (int) zoneOrSort;
        result = 31 * result + (int) minLevel;
        result = 31 * result + (int) questLevel;
        result = 31 * result + (int) type;
        result = 31 * result + (int) requiredClasses;
        result = 31 * result + (int) requiredRaces;
        result = 31 * result + (int) requiredSkill;
        result = 31 * result + (int) requiredSkillValue;
        result = 31 * result + (int) repObjectiveFaction;
        result = 31 * result + repObjectiveValue;
        result = 31 * result + (int) requiredMinRepFaction;
        result = 31 * result + requiredMinRepValue;
        result = 31 * result + (int) requiredMaxRepFaction;
        result = 31 * result + requiredMaxRepValue;
        result = 31 * result + (int) suggestedPlayers;
        result = 31 * result + limitTime;
        result = 31 * result + questFlags;
        result = 31 * result + (int) specialFlags;
        result = 31 * result + (int) charTitleId;
        result = 31 * result + (int) playersSlain;
        result = 31 * result + (int) bonusTalents;
        result = 31 * result + prevQuestId;
        result = 31 * result + nextQuestId;
        result = 31 * result + exclusiveGroup;
        result = 31 * result + nextQuestInChain;
        result = 31 * result + (int) rewXpId;
        result = 31 * result + srcItemId;
        result = 31 * result + (int) srcItemCount;
        result = 31 * result + srcSpell;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (objectives != null ? objectives.hashCode() : 0);
        result = 31 * result + (offerRewardText != null ? offerRewardText.hashCode() : 0);
        result = 31 * result + (requestItemsText != null ? requestItemsText.hashCode() : 0);
        result = 31 * result + (endText != null ? endText.hashCode() : 0);
        result = 31 * result + (completedText != null ? completedText.hashCode() : 0);
        result = 31 * result + (objectiveText1 != null ? objectiveText1.hashCode() : 0);
        result = 31 * result + (objectiveText2 != null ? objectiveText2.hashCode() : 0);
        result = 31 * result + (objectiveText3 != null ? objectiveText3.hashCode() : 0);
        result = 31 * result + (objectiveText4 != null ? objectiveText4.hashCode() : 0);
        result = 31 * result + reqItemId1;
        result = 31 * result + reqItemId2;
        result = 31 * result + reqItemId3;
        result = 31 * result + reqItemId4;
        result = 31 * result + reqItemId5;
        result = 31 * result + reqItemId6;
        result = 31 * result + (int) reqItemCount1;
        result = 31 * result + (int) reqItemCount2;
        result = 31 * result + (int) reqItemCount3;
        result = 31 * result + (int) reqItemCount4;
        result = 31 * result + (int) reqItemCount5;
        result = 31 * result + (int) reqItemCount6;
        result = 31 * result + reqSourceId1;
        result = 31 * result + reqSourceId2;
        result = 31 * result + reqSourceId3;
        result = 31 * result + reqSourceId4;
        result = 31 * result + (int) reqSourceCount1;
        result = 31 * result + (int) reqSourceCount2;
        result = 31 * result + (int) reqSourceCount3;
        result = 31 * result + (int) reqSourceCount4;
        result = 31 * result + reqCreatureOrGoId1;
        result = 31 * result + reqCreatureOrGoId2;
        result = 31 * result + reqCreatureOrGoId3;
        result = 31 * result + reqCreatureOrGoId4;
        result = 31 * result + (int) reqCreatureOrGoCount1;
        result = 31 * result + (int) reqCreatureOrGoCount2;
        result = 31 * result + (int) reqCreatureOrGoCount3;
        result = 31 * result + (int) reqCreatureOrGoCount4;
        result = 31 * result + reqSpellCast1;
        result = 31 * result + reqSpellCast2;
        result = 31 * result + reqSpellCast3;
        result = 31 * result + reqSpellCast4;
        result = 31 * result + rewChoiceItemId1;
        result = 31 * result + rewChoiceItemId2;
        result = 31 * result + rewChoiceItemId3;
        result = 31 * result + rewChoiceItemId4;
        result = 31 * result + rewChoiceItemId5;
        result = 31 * result + rewChoiceItemId6;
        result = 31 * result + (int) rewChoiceItemCount1;
        result = 31 * result + (int) rewChoiceItemCount2;
        result = 31 * result + (int) rewChoiceItemCount3;
        result = 31 * result + (int) rewChoiceItemCount4;
        result = 31 * result + (int) rewChoiceItemCount5;
        result = 31 * result + (int) rewChoiceItemCount6;
        result = 31 * result + rewItemId1;
        result = 31 * result + rewItemId2;
        result = 31 * result + rewItemId3;
        result = 31 * result + rewItemId4;
        result = 31 * result + (int) rewItemCount1;
        result = 31 * result + (int) rewItemCount2;
        result = 31 * result + (int) rewItemCount3;
        result = 31 * result + (int) rewItemCount4;
        result = 31 * result + (int) rewRepFaction1;
        result = 31 * result + (int) rewRepFaction2;
        result = 31 * result + (int) rewRepFaction3;
        result = 31 * result + (int) rewRepFaction4;
        result = 31 * result + (int) rewRepFaction5;
        result = 31 * result + (int) rewRepValueId1;
        result = 31 * result + (int) rewRepValueId2;
        result = 31 * result + (int) rewRepValueId3;
        result = 31 * result + (int) rewRepValueId4;
        result = 31 * result + (int) rewRepValueId5;
        result = 31 * result + rewRepValue1;
        result = 31 * result + rewRepValue2;
        result = 31 * result + rewRepValue3;
        result = 31 * result + rewRepValue4;
        result = 31 * result + rewRepValue5;
        result = 31 * result + rewHonorAddition;
        result = 31 * result + (rewHonorMultiplier != +0.0f ? Float.floatToIntBits(rewHonorMultiplier) : 0);
        result = 31 * result + rewOrReqMoney;
        result = 31 * result + rewMoneyMaxLevel;
        result = 31 * result + rewSpell;
        result = 31 * result + rewSpellCast;
        result = 31 * result + rewMailTemplateId;
        result = 31 * result + rewMailDelaySecs;
        result = 31 * result + (int) pointMapId;
        result = 31 * result + (pointX != +0.0f ? Float.floatToIntBits(pointX) : 0);
        result = 31 * result + (pointY != +0.0f ? Float.floatToIntBits(pointY) : 0);
        result = 31 * result + pointOpt;
        result = 31 * result + (int) detailsEmote1;
        result = 31 * result + (int) detailsEmote2;
        result = 31 * result + (int) detailsEmote3;
        result = 31 * result + (int) detailsEmote4;
        result = 31 * result + detailsEmoteDelay1;
        result = 31 * result + detailsEmoteDelay2;
        result = 31 * result + detailsEmoteDelay3;
        result = 31 * result + detailsEmoteDelay4;
        result = 31 * result + (int) incompleteEmote;
        result = 31 * result + (int) completeEmote;
        result = 31 * result + (int) offerRewardEmote1;
        result = 31 * result + (int) offerRewardEmote2;
        result = 31 * result + (int) offerRewardEmote3;
        result = 31 * result + (int) offerRewardEmote4;
        result = 31 * result + offerRewardEmoteDelay1;
        result = 31 * result + offerRewardEmoteDelay2;
        result = 31 * result + offerRewardEmoteDelay3;
        result = 31 * result + offerRewardEmoteDelay4;
        result = 31 * result + startScript;
        result = 31 * result + completeScript;
        return result;
    }
}
