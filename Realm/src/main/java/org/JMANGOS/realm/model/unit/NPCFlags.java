/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.realm.model.unit;

// TODO: Auto-generated Javadoc
/**
 * The Enum NPCFlags.
 */
public enum NPCFlags {
	    
    	/** The UNI t_ np c_ fla g_ none. */
    	UNIT_NPC_FLAG_NONE                  (0x00000000),
	    
    	/** The UNI t_ np c_ fla g_ gossip. */
    	UNIT_NPC_FLAG_GOSSIP                (0x00000001),       // 100%
	    /** The UNI t_ np c_ fla g_ questgiver. */
       UNIT_NPC_FLAG_QUESTGIVER            (0x00000002),       // guessed, probably ok
	    /** The UNI t_ np c_ fla g_ un k1. */
       UNIT_NPC_FLAG_UNK1                  (0x00000004),
	    
    	/** The UNI t_ np c_ fla g_ un k2. */
    	UNIT_NPC_FLAG_UNK2                  (0x00000008),
	    
    	/** The UNI t_ np c_ fla g_ trainer. */
    	UNIT_NPC_FLAG_TRAINER               (0x00000010),       // 100%
	    /** The UNI t_ np c_ fla g_ traine r_ class. */
       UNIT_NPC_FLAG_TRAINER_CLASS         (0x00000020),       // 100%
	    /** The UNI t_ np c_ fla g_ traine r_ profession. */
       UNIT_NPC_FLAG_TRAINER_PROFESSION    (0x00000040),       // 100%
	    /** The UNI t_ np c_ fla g_ vendor. */
       UNIT_NPC_FLAG_VENDOR                (0x00000080),       // 100%
	    /** The UNI t_ np c_ fla g_ vendo r_ ammo. */
       UNIT_NPC_FLAG_VENDOR_AMMO           (0x00000100),       // 100%, general goods vendor
	    /** The UNI t_ np c_ fla g_ vendo r_ food. */
       UNIT_NPC_FLAG_VENDOR_FOOD           (0x00000200),       // 100%
	    /** The UNI t_ np c_ fla g_ vendo r_ poison. */
       UNIT_NPC_FLAG_VENDOR_POISON         (0x00000400),       // guessed
	    /** The UNI t_ np c_ fla g_ vendo r_ reagent. */
       UNIT_NPC_FLAG_VENDOR_REAGENT        (0x00000800),       // 100%
	    /** The UNI t_ np c_ fla g_ repair. */
       UNIT_NPC_FLAG_REPAIR                (0x00001000),       // 100%
	    /** The UNI t_ np c_ fla g_ flightmaster. */
       UNIT_NPC_FLAG_FLIGHTMASTER          (0x00002000),       // 100%
	    /** The UNI t_ np c_ fla g_ spirithealer. */
       UNIT_NPC_FLAG_SPIRITHEALER          (0x00004000),       // guessed
	    /** The UNI t_ np c_ fla g_ spiritguide. */
       UNIT_NPC_FLAG_SPIRITGUIDE           (0x00008000),       // guessed
	    /** The UNI t_ np c_ fla g_ innkeeper. */
       UNIT_NPC_FLAG_INNKEEPER             (0x00010000),       // 100%
	    /** The UNI t_ np c_ fla g_ banker. */
       UNIT_NPC_FLAG_BANKER                (0x00020000),       // 100%
	    /** The UNI t_ np c_ fla g_ petitioner. */
       UNIT_NPC_FLAG_PETITIONER            (0x00040000),       // 100% 0xC0000 (guild petitions, 0x40000 (arena team petitions
	    /** The UNI t_ np c_ fla g_ tabarddesigner. */
       UNIT_NPC_FLAG_TABARDDESIGNER        (0x00080000),       // 100%
	    /** The UNI t_ np c_ fla g_ battlemaster. */
       UNIT_NPC_FLAG_BATTLEMASTER          (0x00100000),       // 100%
	    /** The UNI t_ np c_ fla g_ auctioneer. */
       UNIT_NPC_FLAG_AUCTIONEER            (0x00200000),       // 100%
	    /** The UNI t_ np c_ fla g_ stablemaster. */
       UNIT_NPC_FLAG_STABLEMASTER          (0x00400000),       // 100%
	    /** The UNI t_ np c_ fla g_ guil d_ banker. */
       UNIT_NPC_FLAG_GUILD_BANKER          (0x00800000),       // cause client to send 997 opcode
	    /** The UNI t_ np c_ fla g_ spellclick. */
       UNIT_NPC_FLAG_SPELLCLICK            (0x01000000),       // cause client to send 1015 opcode (spell click), dynamic, set at loading and don't must be set in DB
	    /** The UNI t_ np c_ fla g_ guard. */
       UNIT_NPC_FLAG_GUARD                 (0x10000000);       // custom flag for guards
		
	    /** The flag. */
       private int flag;
	    
    	/**
    	 * Instantiates a new nPC flags.
    	 *
    	 * @param flag the flag
    	 */
    	NPCFlags(int flag){
	    	this.setFlag(flag);
	    }
		
		/**
		 * Sets the flag.
		 *
		 * @param flag the new flag
		 */
		public void setFlag(int flag) {
			this.flag = flag;
		}
		
		/**
		 * Gets the flag.
		 *
		 * @return the flag
		 */
		public int getFlag() {
			return flag;
		}
}
