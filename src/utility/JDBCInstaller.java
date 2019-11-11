package utility;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import di.InjectionHandler;

public class JDBCInstaller {
    private static JDBCInstaller instance;
    private static Connection connection;
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    private JDBCInstaller() throws Exception{
        Properties props = new Properties();
        props.load(new FileInputStream("db.properties"));
        String dbUrl = props.getProperty("dbUrl");
        String userName = props.getProperty("userName");
        String password = props.getProperty("password");
        connection = DriverManager.getConnection(dbUrl, userName, password);
        System.out.println("Connection established to " + dbUrl);
    }
    
    public static JDBCInstaller getInstance() {
        if(instance == null) {
            try {
                instance = new JDBCInstaller();
            } catch (Exception e) {
                logger.error(e);
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
