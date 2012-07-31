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
package org.JMANGOS.realm.model.base;

// TODO: Auto-generated Javadoc
/**
 * The Enum TradeStatus.
 */
public enum TradeStatus {
	    
    	/** The TRAD e_ statu s_ busy. */
    	TRADE_STATUS_BUSY           (0),
	    
    	/** The TRAD e_ statu s_ begi n_ trade. */
    	TRADE_STATUS_BEGIN_TRADE    (1),
	    
    	/** The TRAD e_ statu s_ ope n_ window. */
    	TRADE_STATUS_OPEN_WINDOW    (2),
	    
    	/** The TRAD e_ statu s_ trad e_ canceled. */
    	TRADE_STATUS_TRADE_CANCELED (3),
	    
    	/** The TRAD e_ statu s_ trad e_ accept. */
    	TRADE_STATUS_TRADE_ACCEPT   (4),
	    
    	/** The TRAD e_ statu s_ bus y_2. */
    	TRADE_STATUS_BUSY_2         (5),
	    
    	/** The TRAD e_ statu s_ n o_ target. */
    	TRADE_STATUS_NO_TARGET      (6),
	    
    	/** The TRAD e_ statu s_ bac k_ t o_ trade. */
    	TRADE_STATUS_BACK_TO_TRADE  (7),
	    
    	/** The TRAD e_ statu s_ trad e_ complete. */
    	TRADE_STATUS_TRADE_COMPLETE (8),
	    // 9?
	    /** The TRAD e_ statu s_ targe t_ t o_ far. */
    	TRADE_STATUS_TARGET_TO_FAR  (10),
	    
    	/** The TRAD e_ statu s_ wron g_ faction. */
    	TRADE_STATUS_WRONG_FACTION  (11),
	    
    	/** The TRAD e_ statu s_ clos e_ window. */
    	TRADE_STATUS_CLOSE_WINDOW   (12),
	    // 13?
	    /** The TRAD e_ statu s_ ignor e_ you. */
    	TRADE_STATUS_IGNORE_YOU     (14),
	    
    	/** The TRAD e_ statu s_ yo u_ stunned. */
    	TRADE_STATUS_YOU_STUNNED    (15),
	    
    	/** The TRAD e_ statu s_ targe t_ stunned. */
    	TRADE_STATUS_TARGET_STUNNED (16),
	    
    	/** The TRAD e_ statu s_ yo u_ dead. */
    	TRADE_STATUS_YOU_DEAD       (17),
	    
    	/** The TRAD e_ statu s_ targe t_ dead. */
    	TRADE_STATUS_TARGET_DEAD    (18),
	    
    	/** The TRAD e_ statu s_ yo u_ logout. */
    	TRADE_STATUS_YOU_LOGOUT     (19),
	    
    	/** The TRAD e_ statu s_ targe t_ logout. */
    	TRADE_STATUS_TARGET_LOGOUT  (20),
	    
    	/** The TRAD e_ statu s_ tria l_ account. */
    	TRADE_STATUS_TRIAL_ACCOUNT  (21),                       // Trial accounts can not perform that action
	    /** The TRAD e_ statu s_ onl y_ conjured. */
                       TRADE_STATUS_ONLY_CONJURED  (22);                        // You can only trade conjured items... (cross realm BG related).
	    
		/** The status. */
                        private int status;
		
	    /**
    	 * Gets the status.
    	 *
    	 * @return the status
    	 */
    	public final int getStatus() {
			return status;
		}

		/**
		 * Instantiates a new trade status.
		 *
		 * @param status the status
		 */
		TradeStatus(int status) {
	    		this.status = status;
	    	}
	    }
