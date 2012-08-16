package org.jmangos.realm.model;

/**
 * Created with IntelliJ IDEA. User: Goofy Date: 2012.08.08. Time: 19:03 To change this template use
 * File | Settings | File Templates.
 */
public enum ChatLanguage {
    LANG_UNIVERSAL(0),
    LANG_ORCISH(1),
    LANG_DARNASSIAN(2),
    LANG_TAURAHE(3),
    LANG_DWARVISH(6),
    LANG_COMMON(7),
    LANG_DEMONIC(8),
    LANG_TITAN(9),
    LANG_THALASSIAN(10),
    LANG_DRACONIC(11),
    LANG_KALIMAG(12),
    LANG_GNOMISH(13),
    LANG_TROLL(14),
    LANG_GUTTERSPEAK(33),
    LANG_DRAENEI(35),
    LANG_ZOMBIE(36),
    LANG_GNOMISH_BINARY(37),
    LANG_GOBLIN_BINARY(38),
    LANG_ADDON(0xFFFFFFFF);
    
    private int opcode;
    
    ChatLanguage(final int opcode) {
    
        this.opcode = opcode;
    }
}
