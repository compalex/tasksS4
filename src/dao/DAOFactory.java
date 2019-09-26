package dao;

import java.sql.Connection;
import api.dao.IBookDAO;
import api.dao.IOrderDAO;
import api.dao.IRequestDAO;

public class DAOFactory {

    public static IBookDAO getBookDAO(Connection connection) {
        return new BookDAO(connection);
    }
    
    public static IOrderDAO getOrderDAO(Connection connection) {
        return new OrderDAO(connection);
    }
    
    public static IRequestDAO getRequestDAO(Connection connection) {
        return new RequestDAO(connection);
    }
}