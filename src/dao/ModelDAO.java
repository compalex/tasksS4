package dao;

import java.sql.Connection;

import utility.Constants.TypeDAO;

public abstract class ModelDAO {
    TypeDAO typeDAO = null;
    Connection connection = null;
    
    ModelDAO(TypeDAO typeDAO, Connection connection) {
        this.typeDAO = typeDAO;
        this.connection = connection;
    }
    
    abstract void createDAO();

    public Connection getConnection() {
        return connection;
    }
    
    void updateRecord() {
        
    }
    
    void deleteRecord() {
        
    }
}
