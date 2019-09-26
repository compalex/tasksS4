package dao;

import java.sql.Connection;

public abstract class ModelDAO {
    protected Connection connection;
    
    public ModelDAO(Connection connection) {
        this.connection = connection;
    }
    
    abstract void updateRecord();
    abstract void deleteRecord();
}
