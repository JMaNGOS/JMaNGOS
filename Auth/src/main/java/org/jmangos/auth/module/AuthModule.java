package org.jmangos.auth.module;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.jmangos.commons.database.DatabaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
public class AuthModule {
    
    /** Database config */
    @Inject
    private DatabaseConfig databaseConfig;
    
    @Bean
    public DataSource dataSource() {
    
        final BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(this.databaseConfig.ACCOUNT_DATABASE_DRIVER);
        ds.setUrl(this.databaseConfig.ACCOUNT_DATABASE_URL + this.databaseConfig.ACCOUNT_DATABASE_NAME + "?autoReconnect=true");
        ds.setUsername(this.databaseConfig.ACCOUNT_DATABASE_USER);
        ds.setPassword(this.databaseConfig.ACCOUNT_DATABASE_PASSWORD);
        return ds;
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
    
        final HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setShowSql(true);
        hjva.setGenerateDdl(false);
        hjva.setDatabasePlatform(this.databaseConfig.ACCOUNT_DATABASE_DIALECT);
        return hjva;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    
        final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
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
