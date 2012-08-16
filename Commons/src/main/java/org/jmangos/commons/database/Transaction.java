/*******************************************************************************
 * Copyright (C) 2012 JMaNGOS <http://jmangos.org/>
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
 *******************************************************************************/
package org.jmangos.commons.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

public class Transaction {
    
    /** Logger for transactions. */
    private static final Logger log = Logger.getLogger(Transaction.class);
    
    /** Connection that is allocated for this transaction. */
    private final Connection    connection;
    
    /**
     * Package private constructor, should be instantiated via.
     * 
     * @param con
     *            Connection that will be used for this transaction
     * @throws SQLException
     *             the sQL exception {@link org.jmangos.commons.database.DB#beginTransaction()}
     *             class
     */
    Transaction(final Connection con) throws SQLException {
    
        this.connection = con;
        this.connection.setAutoCommit(false);
    }
    
    /**
     * Adds Insert / Update Query to the transaction.
     * 
     * @param sql
     *            SQL string
     * @throws SQLException
     *             if something went wrong
     */
    public void insertUpdate(final String sql) throws SQLException {
    
        insertUpdate(sql, null);
    }
    
    /**
     * Adds Insert / Update Query to this transaction. Utilizes IUSth for Batching and Query
     * Editing. MUST MANUALLY EXECUTE QUERY / BATACH IN IUSth (No need to close Statement after
     * execution)
     * 
     * @param sql
     *            Sql query
     * @param iusth
     *            query helper
     * @throws SQLException
     *             if something went wrong
     */
    public void insertUpdate(final String sql, final IUStH iusth) throws SQLException {
    
        final PreparedStatement statement = this.connection.prepareStatement(sql);
        if (iusth != null) {
            iusth.handleInsertUpdate(statement);
        } else {
            statement.executeUpdate();
        }
    }
    
    /**
     * Creates new savepoint.
     * 
     * @param name
     *            name of savepoint
     * @return created savepoint
     * @throws SQLException
     *             if can't create save point
     */
    public Savepoint setSavepoint(final String name) throws SQLException {
    
        return this.connection.setSavepoint(name);
    }
    
    /**
     * Releases savepoint of transaction.
     * 
     * @param savepoint
     *            savepoint to release
     * @throws SQLException
     *             if something went wrong
     */
    public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
    
        this.connection.releaseSavepoint(savepoint);
    }
    
    /**
     * Commits transaction.
     * 
     * @throws SQLException
     *             if something is wrong with transaction
     */
    public void commit() throws SQLException {
    
        commit(null);
    }
    
    /**
     * Commits transaction. If rollBackToOnError is null - whole transaction will be rolledback
     * 
     * @param rollBackToOnError
     *            savepoint that should be used to rollback
     * @throws SQLException
     *             if something went wrongF
     */
    public void commit(final Savepoint rollBackToOnError) throws SQLException {
    
        try {
            this.connection.commit();
        } catch (final SQLException e) {
            log.warn("Error while commiting transaction", e);
            
            try {
                if (rollBackToOnError != null) {
                    this.connection.rollback(rollBackToOnError);
                } else {
                    this.connection.rollback();
                }
            } catch (final SQLException e1) {
                log.error("Can't rollback transaction", e1);
            }
        }
        
        this.connection.setAutoCommit(true);
        this.connection.close();
    }
}
