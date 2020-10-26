/**
 * OmniDataSourceConfig.java
 */
package com.omni.core.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@PropertySource("classpath:com/omni/core/config/config.properties")
public class OmniDataSourceConfig {

    private static final String ENV_JDBC_BITE = "jdbc.password";
    private static final String ENV_JDBC_USERNAME = "jdbc.username";
    private static final String ENV_JDBC_URL = "jdbc.url";
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final int MAX_ACTIVE = -1;
    private static final int MAX_IDLE = -1;
    private static final int MAX_WAIT = 1000;
    private static final int REMOVE_ABANDONED_TIMEOUT = 300;
    private static final boolean REMOVE_ABANDONED = true;
    private static final boolean TEST_ON_BORROW = true;

    @Autowired
    private Environment env;

    @Bean
    @Profile("env-test")
    public DataSource testDataSource() {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(env.getProperty(ENV_JDBC_URL));
        bds.setUsername(env.getProperty(ENV_JDBC_USERNAME));
        bds.setPassword(env.getProperty(ENV_JDBC_BITE));
        bds.setTestOnBorrow(TEST_ON_BORROW);
        bds.setRemoveAbandonedOnBorrow(REMOVE_ABANDONED);
        bds.setRemoveAbandonedTimeout(REMOVE_ABANDONED_TIMEOUT);
        bds.setMaxIdle(MAX_IDLE);
        bds.setMaxTotal(MAX_ACTIVE);
        bds.setMaxWaitMillis(MAX_WAIT);
        bds.setDriverClassName(DRIVER_CLASS_NAME);
        return bds;
    }

    @Bean
    @Profile("env-local")
    public DataSource localdataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("java:comp/env/jdbc/LOCAL");
    }

    @Bean
    @Profile("env-dev")
    public DataSource devDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("java:comp/env/jdbc/DEV");
    }

    @Bean
    @Profile("env-recette")
    public DataSource recetteDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("java:comp/env/jdbc/RECETTE");
    }

    @Bean
    @Profile("env-preprod")
    public DataSource preprodDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("java:comp/env/jdbc/PREPROD");
    }

    @Bean
    @Profile("env-prod")
    public DataSource prodDataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("java:comp/env/jdbc/PROD");
    }

}
