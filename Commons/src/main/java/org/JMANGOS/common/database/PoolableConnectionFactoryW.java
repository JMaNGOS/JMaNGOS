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
package org.JMANGOS.common.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.pool.KeyedObjectPool;
import org.apache.commons.pool.KeyedObjectPoolFactory;
import org.apache.commons.pool.ObjectPool;

public class PoolableConnectionFactoryW extends PoolableConnectionFactory
{
	/**
	 * Validation time out - how much seconds driver should wait for response from server. 0 - indicates there are no
	 * timeout -1 - indicates that validation should not be used.
	 * 
	 */
	private final int	validationTimeout;

	/**
	 * Create a new <tt>PoolableConnectionFactoryAE</tt>.
	 *
	 * @param connFactory the {@link ConnectionFactory} from which to obtain base {@link Connection}s
	 * @param pool the {@link ObjectPool} in which to pool those {@link Connection}s
	 * @param stmtPoolFactory the {@link KeyedObjectPoolFactory} to use to create {@link KeyedObjectPool}s for pooling
	 * @param validationTimeout a timeout value in seconds used to {@link #validateObject validate} {@link Connection}s. Value of
	 * <tt>0</tt> means no timeout. Using <tt>-1</tt> turns off validation.
	 * @param defaultReadOnly the default "read only" setting for borrowed {@link Connection}s
	 * @param defaultAutoCommit the default "auto commit" setting for returned {@link Connection}s
	 * {@link java.sql.PreparedStatement}s, or <tt>null</tt> to disable {@link java.sql.PreparedStatement}
	 * pooling
	 */
	public PoolableConnectionFactoryW(ConnectionFactory connFactory, ObjectPool pool,
		KeyedObjectPoolFactory stmtPoolFactory, int validationTimeout, boolean defaultReadOnly,
		boolean defaultAutoCommit)
	{
		super(connFactory, pool, stmtPoolFactory, null, defaultReadOnly, defaultAutoCommit);
		this.validationTimeout = validationTimeout;
	}

	/**
	 * Validate connection by checking if connection is not closed and is still valid. throws SQLException if connection
	 * is invalid.
	 *
	 * @param conn the conn
	 * @throws SQLException the sQL exception
	 */
	@Override
	public void validateConnection(Connection conn) throws SQLException
	{
		if(conn.isClosed())
			throw new SQLException("validateConnection: connection closed");
		if(validationTimeout >= 0 && !conn.isValid(validationTimeout))
			throw new SQLException("validateConnection: connection invalid");
	}
}
