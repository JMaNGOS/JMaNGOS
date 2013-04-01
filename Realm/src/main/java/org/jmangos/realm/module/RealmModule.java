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
package org.jmangos.realm.module;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.jmangos.commons.database.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackages = "org.jmangos.realm.dao",
        entityManagerFactoryRef = "entityManagerFactoryRealm",
        transactionManagerRef = "transactionManagerRealm")
@EnableTransactionManagement
public class RealmModule {

    /** Database config */
    @Autowired
    private DatabaseConfig databaseConfig;

    @Bean
    public DataSource dataSourceRealm() {

        final ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(this.databaseConfig.CHARS_DATABASE_DIALECT);
            ds.setJdbcUrl(this.databaseConfig.CHARS_DATABASE_URL +
                this.databaseConfig.CHARS_DATABASE_NAME +
                "?autoReconnect=true");
            ds.setUser(this.databaseConfig.CHARS_DATABASE_USER);
            ds.setPassword(this.databaseConfig.CHARS_DATABASE_PASSWORD);

            ds.setMinPoolSize(this.databaseConfig.CHARS_DATABASE_CONNECTIONS_MIN);
            ds.setMaxPoolSize(this.databaseConfig.CHARS_DATABASE_CONNECTIONS_MAX);
            ds.setAutoCommitOnClose(false);
        } catch (final PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapterRealm() {

        final HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setShowSql(false);
        hjva.setGenerateDdl(true);
        hjva.setDatabasePlatform(this.databaseConfig.CHARS_DATABASE_DIALECT);
        return hjva;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryRealm() {

        final LocalContainerEntityManagerFactoryBean lcemfb =
                new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSourceRealm());
        lcemfb.setPersistenceXmlLocation("classpath:META-INF/persistence-realm.xml");
        lcemfb.setJpaVendorAdapter(jpaVendorAdapterRealm());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        return lcemfb;
    }

    @Bean
    @Qualifier("realm")
    public JpaTransactionManager transactionManagerRealm() {

        final JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactoryRealm().getObject());
        return jtm;
    }

    @Bean
    public TransactionInterceptor transactionInterceptorRealm() {

        return new TransactionInterceptor(transactionManagerRealm(),
                new AnnotationTransactionAttributeSource());
    }

}
