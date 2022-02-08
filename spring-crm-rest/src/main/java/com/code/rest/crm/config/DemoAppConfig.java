package com.code.rest.crm.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.code.rest.crm")
@PropertySource("classpath:persistence-postgres.properties")
public class DemoAppConfig{
    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        try{
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        }catch (PropertyVetoException exec){
            throw new RuntimeException(exec);
        }

        logger.info(">>> jdbc.url="+env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user="+env.getProperty("jdbc.user"));

        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        securityDataSource.setInitialPoolSize(getInt(env.getProperty("connection.pool.initialPoolSize")));
        securityDataSource.setMinPoolSize(getInt(env.getProperty("connection.pool.minPoolSize")));
        securityDataSource.setMaxPoolSize(getInt(env.getProperty("connection.pool.maxPoolSize")));
        securityDataSource.setMaxIdleTime(getInt(env.getProperty("connection.pool.maxIdleTime")));

        return securityDataSource;
    }

    private Properties getHibernateProperties() {
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return props;
    }


    private int getInt(String str){
        return Integer.parseInt(str);
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        // Create a session Factory
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.package_to_scan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

}
