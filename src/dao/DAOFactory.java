package dao;

import java.sql.Connection;

import utility.Constants.TypeDAO;

public class DAOFactory extends AbstractFactory {
    
    public static ModelDAO getDAO(TypeDAO typeDAO, Connection connection) {
        switch(typeDAO) {
            case BOOK:
                return new BookDAO(connection);
            case ORDER:
                return new OrderDAO(connection);
            case REQUEST:
                return new RequestDAO(connection);
            default: 
                return null;
        }
    }
}