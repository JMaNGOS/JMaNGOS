package org.jmangos.realm.module;

import java.beans.PropertyVetoException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.jmangos.commons.database.DatabaseConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableTransactionManagement
public class WorldModule {
    
    /** Database config */
    @Inject
    private DatabaseConfig databaseConfig;
    
    @Bean
    public DataSource dataSourceWorld() {
    
        final ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(this.databaseConfig.WORLD_DATABASE_DRIVER);
            ds.setJdbcUrl(this.databaseConfig.WORLD_DATABASE_URL + this.databaseConfig.WORLD_DATABASE_NAME + "?autoReconnect=true");
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
        hjva.setShowSql(true);
        hjva.setGenerateDdl(true);
        hjva.setDatabasePlatform(this.databaseConfig.WORLD_DATABASE_DIALECT);
        return hjva;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryWorld() {
    
        final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
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
    
        return new TransactionInterceptor(transactionManagerWorld(), new AnnotationTransactionAttributeSource());
    }
    
}
