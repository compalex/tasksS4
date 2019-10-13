package dao;

import api.dao.IBookDAO;
import api.dao.IOrderDAO;
import api.dao.IRequestDAO;
import api.dao.IStockDAO;
import config.JDBCInstaller;
import utility.Constants.Database;

public class DAOFactory {
    public static Database database;
    
    public static IBookDAO getBookDAO() throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.BookDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.BookDAO("books.ser");
            case CSV_FILES:
                return new dao.csv.BookDAO("books.csv");
            default:
                return null;
        }
    }
    
    public static IOrderDAO getOrderDAO() throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.OrderDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.OrderDAO("orders.ser");
            case CSV_FILES:
                return new dao.csv.OrderDAO("orders.csv");
            default:
                return null;
        }
    }
    
    public static IRequestDAO getRequestDAO() throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.RequestDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.RequestDAO("bookRequests.ser");
            case CSV_FILES:
                return new dao.csv.RequestDAO("bookRequests.csv");
            default:
                return null;
        }
    }
    
    public static IStockDAO getStockDAO() throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.StockDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.StockDAO("stock.ser");
            case CSV_FILES:
                return new dao.csv.StockDAO("stock.csv");
            default:
                return null;
        }
    }
}