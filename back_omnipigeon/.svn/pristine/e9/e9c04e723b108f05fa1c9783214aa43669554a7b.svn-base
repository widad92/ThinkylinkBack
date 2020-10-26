/**
 * omniCoreDataBaseUtils.java
 */
package com.omni.core.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

/**
 * This class is {@link omniCoreDataBaseUtils} omniomni utility class.
 *
 */
public class OmniCoreDataBaseUtils {

    private static final Logger LOGGER = OmniCoreUtils.getLogger(OmniCoreDataBaseUtils.class);
       
    /**
     * recupere une connection à une base de données
     * 
     * @param prod nom JNDI de la base de prod
     * @param dev nom JNDI de la base de dev
     * @return  une connection à une base de données
     */
    private static Connection getConnection(String prod, String dev){
        Connection conn = null; 
        try {
            final DataSource ds;
            final InitialContext cxt = new InitialContext();
            if (OmniCoreUtils.getValueFromPropertyCode("projectConfig").equalsIgnoreCase("prod")) {
                ds = (DataSource) cxt.lookup(prod);
            } else {
                ds = (DataSource) cxt.lookup(dev);
            }
            conn = ds.getConnection();

        } catch (NamingException | SQLException ex) {
            LOGGER.error( ex.getMessage(), ex);
        } 
        
        return conn;
    }

}
