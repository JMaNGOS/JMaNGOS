package org.jmangos.auth.module;

import java.beans.PropertyVetoException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.jmangos.commons.database.DatabaseConfig;
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
public class AuthModule {

    /** Database config */
    @Inject
    private DatabaseConfig databaseConfig;

    @Bean
    public DataSource dataSourceAuth() {

        final ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(this.databaseConfig.ACCOUNT_DATABASE_DRIVER);
            ds.setJdbcUrl(this.databaseConfig.ACCOUNT_DATABASE_URL +
                this.databaseConfig.ACCOUNT_DATABASE_NAME +
                "?autoReconnect=true");
            ds.setUser(this.databaseConfig.ACCOUNT_DATABASE_USER);
            ds.setPassword(this.databaseConfig.ACCOUNT_DATABASE_PASSWORD);

            ds.setMinPoolSize(this.databaseConfig.ACCOUNT_DATABASE_CONNECTIONS_MIN);
            ds.setMaxPoolSize(this.databaseConfig.ACCOUNT_DATABASE_CONNECTIONS_MAX);
            ds.setAutoCommitOnClose(false);
        } catch (final PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ds;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapterAuth() {

        final HibernateJpaVendorAdapter hjva = new HibernateJpaVendorAdapter();
        hjva.setShowSql(true);
        hjva.setGenerateDdl(true);
        hjva.setDatabasePlatform(this.databaseConfig.ACCOUNT_DATABASE_DIALECT);
        return hjva;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean lcemfb =
                new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSourceAuth());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapterAuth());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        return lcemfb;
    }

    @Bean
    public JpaTransactionManager transactionManagerAuth() {

        final JpaTransactionManager jtm = new JpaTransactionManager();
        jtm.setEntityManagerFactory(entityManagerFactory().getObject());
        return jtm;
    }

    @Bean
    public TransactionInterceptor transactionInterceptorAuth() {

        return new TransactionInterceptor(transactionManagerAuth(),
                new AnnotationTransactionAttributeSource());
    }

}
