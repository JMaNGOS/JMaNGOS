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
@EnableJpaRepositories(basePackages = "org.jmangos.world.dao",
        entityManagerFactoryRef = "entityManagerFactoryWorld",
        transactionManagerRef = "transactionManagerWorld")
@EnableTransactionManagement
public class WorldModule {

    /** Database config */
    @Autowired
    private DatabaseConfig databaseConfig;

    @Bean
    public DataSource dataSourceWorld() {

        final ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(this.databaseConfig.WORLD_DATABASE_DRIVER);
            ds.setJdbcUrl(this.databaseConfig.WORLD_DATABASE_URL +
                this.databaseConfig.WORLD_DATABASE_NAME +
                "?autoReconnect=true");
            ds.setUser(this.databaseConfig.WORLD_DATABASE_USER);
            ds.setPassword(this.databaseConfig.WORLD_DATABASE_PASSWORD);

            ds.setMinPoolSize(this.databaseConfig.WORLD_DATABASE_CONNECTIONS_MIN);
            ds.setMaxPoolSize(this.databaseConfig.WORLD_DATABASE_CONNECTIONS_MAX);
            ds.setAutoCommitOnClose(false);
        } catch (final PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapterWorld() {

        final HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setShowSql(false);
        hjva.setGenerateDdl(true);
        hjva.setDatabasePlatform(this.databaseConfig.WORLD_DATABASE_DIALECT);
        return hjva;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWorld() {

        final LocalContainerEntityManagerFactoryBean lcemfb =
                new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSourceWorld());
        lcemfb.setPersistenceXmlLocation("classpath:META-INF/persistence-world.xml");
        lcemfb.setJpaVendorAdapter(jpaVendorAdapterWorld());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        return lcemfb;
    }

    @Bean
    @Qualifier("world")
    public JpaTransactionManager transactionManagerWorld() {

        final JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactoryWorld().getObject());
        return jtm;
    }

    @Bean
    public TransactionInterceptor transactionInterceptorWorld() {

        return new TransactionInterceptor(transactionManagerWorld(),
                new AnnotationTransactionAttributeSource());
    }

}
