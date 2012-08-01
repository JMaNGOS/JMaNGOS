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
package org.JMANGOS.common.model;

// TODO: Auto-generated Javadoc
/**
 * The Enum WoWAuthResponse.
 */
public enum WoWAuthResponse {

	/** The WO w_ success. */
	WOW_SUCCESS(0x00),

	/** The WO w_ fai l_ unknow n0. */
	WOW_FAIL_UNKNOWN0(0x01), // /< ? Unable to connect))
	/** The WO w_ fai l_ unknow n1. */
	WOW_FAIL_UNKNOWN1(0x02), // /< ? Unable to connect))
	/** The WO w_ fai l_ banned. */
	WOW_FAIL_BANNED(0x03), // /< This <game> account has been closed and is no
							// longer available for use. Please go to
							// <site>/banned.html for further information.))
	/** The WO w_ fai l_ unknow n_ account. */
	WOW_FAIL_UNKNOWN_ACCOUNT(0x04), // /< The information you have entered is
									// not valid. Please check the spelling of
									// the account name and password. If you
									// need help in retrieving a lost or stolen
									// password, see <site> for more
									// information))
	/** The WO w_ fai l_ incorrec t_ password. */
	WOW_FAIL_INCORRECT_PASSWORD(0x05), // /< The information you have entered is
										// not valid. Please check the spelling
										// of the account name and password. If
										// you need help in retrieving a lost or
										// stolen password, see <site> for more
										// information))
	/** The WO w_ fai l_ alread y_ online. */
	WOW_FAIL_ALREADY_ONLINE(0x06), // /< This account is already logged into
									// <game>. Please check the spelling and try
									// again.))
	/** The WO w_ fai l_ n o_ time. */
	WOW_FAIL_NO_TIME(0x07), // /< You have used up your prepaid time for this
							// account. Please purchase more to continue
							// playing))
	/** The WO w_ fai l_ d b_ busy. */
	WOW_FAIL_DB_BUSY(0x08), // /< Could not log in to <game> at this time.
							// Please try again later.))
	/** The WO w_ fai l_ versio n_ invalid. */
	WOW_FAIL_VERSION_INVALID(0x09), // /< Unable to validate game version. This
									// may be caused by file corruption or
									// interference of another program. Please
									// visit <site> for more information and
									// possible solutions to this issue.))
	/** The WO w_ fai l_ versio n_ update. */
	WOW_FAIL_VERSION_UPDATE(0x0A), // /< Downloading))
	/** The WO w_ fai l_ invali d_ server. */
	WOW_FAIL_INVALID_SERVER(0x0B), // /< Unable to connect))
	/** The WO w_ fai l_ suspended. */
	WOW_FAIL_SUSPENDED(0x0C), // /< This <game> account has been temporarily
								// suspended. Please go to <site>/banned.html
								// for further information))
	/** The WO w_ fai l_ fai l_ noaccess. */
	WOW_FAIL_FAIL_NOACCESS(0x0D), // /< Unable to connect))
	/** The WO w_ succes s_ survey. */
	WOW_SUCCESS_SURVEY(0x0E), // /< Connected.))
	/** The WO w_ fai l_ parentcontrol. */
	WOW_FAIL_PARENTCONTROL(0x0F), // /< Access to this account has been blocked
									// by parental controls. Your settings may
									// be changed in your account preferences at
									// <site>))
	/** The WO w_ fai l_ locke d_ enforced. */
	WOW_FAIL_LOCKED_ENFORCED(0x10), // /< You have applied a lock to your
									// account. You can change your locked
									// status by calling your account lock phone
									// number.))
	/** The WO w_ fai l_ tria l_ ended. */
	WOW_FAIL_TRIAL_ENDED(0x11), // /< Your trial subscription has expired.
								// Please visit <site> to upgrade your
								// account.))
	/** The WO w_ fai l_ us e_ battlenet. */
	WOW_FAIL_USE_BATTLENET(0x12); // /< WOW_FAIL_OTHER This account is now
									// attached to a Battle.net account. Please
									// login with your Battle.net account email
									// address and password.))
	/** id of this enum that may be sent to client. */
	private int messageId;

	/**
	 * Constructor.
	 * 
	 * @param msgId
	 *            id of the message
	 */
	private WoWAuthResponse(int msgId) {
		messageId = msgId;
	}

	/**
	 * Message Id that may be sent to client.
	 * 
	 * @return message id
	 */
	public int getMessageId() {
		return messageId;
	}
}
