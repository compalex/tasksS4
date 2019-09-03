package config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import dao.BookDAO;
import dao.OrderDAO;
import dao.RequestDAO;

public class JDBCInstaller {
    private Connection connection;
    private static JDBCInstaller instance;
    
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
                e.printStackTrace();
            }
        }
        return instance;
    }
    
    public BookDAO createBookDAO() {
        return new BookDAO(connection);
    }

    public OrderDAO createOrderDAO() {
        return new OrderDAO(connection);
    }
    
    public RequestDAO createRequestDAO() {
        return new RequestDAO(connection);
    }
}
