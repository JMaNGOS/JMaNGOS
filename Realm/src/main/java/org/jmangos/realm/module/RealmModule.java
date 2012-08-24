package org.jmangos.realm.module;

import java.beans.PropertyVetoException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.jmangos.commons.database.DatabaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class RealmModule {
    
    /** Database config */
    @Inject
    private DatabaseConfig databaseConfig;
    
    @Bean
    public DataSource dataSource() {
    
        final ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(this.databaseConfig.CHARS_DATABASE_DIALECT);
            ds.setJdbcUrl(this.databaseConfig.CHARS_DATABASE_URL + this.databaseConfig.CHARS_DATABASE_NAME + "?autoReconnect=true");
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
    public JpaVendorAdapter jpaVendorAdapter() {
    
        final HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setShowSql(true);
        hjva.setGenerateDdl(true);
        hjva.setDatabasePlatform(this.databaseConfig.CHARS_DATABASE_DIALECT);
        return hjva;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    
        final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        return lcemfb;
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
    
        final JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtm;
    }
    
    @Bean
    public AnnotationMBeanExporter annotationMBeanExporter() {
    
        return new AnnotationMBeanExporter();
    }
    
    @Bean
    public TransactionAttributeSource annotationTransactionAttributeSource() {
    
        return new AnnotationTransactionAttributeSource();
    }
    
    @Bean
    public TransactionInterceptor transactionInterceptor() {
    
        return new TransactionInterceptor(transactionManager(), annotationTransactionAttributeSource());
    }
    
}
