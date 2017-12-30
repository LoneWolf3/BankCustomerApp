package com.sac.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories(basePackages = {"com.sac.persistence.repository"})
@EnableTransactionManagement
public class PersistenceConfig {

    private static final Logger LOG = Logger.getLogger(PersistenceConfig.class);


    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

 

   
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return tm;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean factory
                = new LocalContainerEntityManagerFactoryBean();

        factory.setDataSource(getDataSource());
        factory.setPackagesToScan("com.sac.persistence.model");
        factory.setPersistenceUnitName("recrt");
        factory.setJpaVendorAdapter(getJpaVendorAdapter());
        factory.setJpaProperties(getJpaProperties());
        factory.afterPropertiesSet();

        return factory;
    }


    private DataSource getDataSource() {
    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
         dataSource.setDriverClassName(driverClassName);
         dataSource.setUrl(url);
         dataSource.setUsername(username);
         dataSource.setPassword(password);
         return dataSource;
    	
    }

    private JpaVendorAdapter getJpaVendorAdapter() {
        HibernateJpaVendorAdapter adaptor = new HibernateJpaVendorAdapter();
        return adaptor;
    }

    private Properties getJpaProperties() {
        Properties ps = new Properties();
        ps.put("hibernate.dialect", hibernateDialect);
        ps.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        ps.put("hibernate.show_sql", hibernateShowSql);
        ps.put("flushMode", "COMMIT/AUTO");
        return ps;
    }

}
