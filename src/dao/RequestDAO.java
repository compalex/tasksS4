package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import api.dao.IRequestDAO;
import api.model.IRequest;
import model.Request;
import utility.Constants;
import utility.Converter;
import utility.SQLs;

public class RequestDAO extends ModelDAO implements IRequestDAO {
    private Connection connection;
    
    public RequestDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<IRequest> getAllRequests(Constants.RequestSort sort) throws Exception {
        Statement statement = null;
        ResultSet resultSet = null;
        Class<Request> classType = Request.class;
        String sql = SQLs.getAllRequestsSQL(sort);
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        return Converter.getListFromResultSet(classType, resultSet);
    }

    @Override
    public boolean addRequest(Request request) {
        return false;
    }

    @Override
    void updateRecord() {
        // TODO Auto-generated method stub
        
    }

    @Override
    void deleteRecord() {
        // TODO Auto-generated method stub
        
    }
}
