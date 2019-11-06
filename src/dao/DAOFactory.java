package dao;

import api.dao.IBookDAO;
import api.dao.IOrderDAO;
import api.dao.IRequestDAO;
import api.dao.IStockDAO;
import utility.Constants;
import utility.JDBCInstaller;
import utility.Constants.Database;

public class DAOFactory {
    public static IBookDAO getBookDAO(Database database) throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.BookDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.BookDAO(Constants.PATH_BOOK_SER);
            case CSV_FILES:
                return new dao.csv.BookDAO(Constants.PATH_BOOK_CSV);
            default:
                return null;
        }
    }
    
    public static IOrderDAO getOrderDAO(Database database) throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.OrderDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.OrderDAO(Constants.PATH_ORDER_SER);
            case CSV_FILES:
                return new dao.csv.OrderDAO(Constants.PATH_ORDER_CSV);
            default:
                return null;
        }
    }
    
    public static IRequestDAO getRequestDAO(Database database) throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.RequestDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.RequestDAO(Constants.PATH_REQUEST_SER);
            case CSV_FILES:
                return new dao.csv.RequestDAO(Constants.PATH_REQUEST_CSV);
            default:
                return null;
        }
    }
    
    public static IStockDAO getStockDAO(Database database) throws Exception {
        switch(database) {
            case MY_SQL:
                return new dao.sql.StockDAO(JDBCInstaller.getInstance().getConnection());
            case SERIAL:
                return new dao.ser.StockDAO(Constants.PATH_STOCK_SER);
            case CSV_FILES:
                return new dao.csv.StockDAO(Constants.PATH_STOCK_CSV);
            default:
                return null;
        }
    }
}