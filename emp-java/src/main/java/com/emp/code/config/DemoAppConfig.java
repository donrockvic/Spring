package com.emp.code.config;


import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.emp.code")
@PropertySource("classpath:persistence-postgres.properties")
public class DemoAppConfig{
    @Autowired
    private Environment env;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

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


    private int getInt(String str){
        return Integer.parseInt(str);
    }

}
