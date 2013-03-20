package org.jmangos.realm.module;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.jmangos.commons.database.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
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
        hjva.setShowSql(true);
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
