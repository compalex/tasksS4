package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import api.dao.IRequestDAO;
import api.model.IModel;
import model.Request;
import utility.Constants;
import utility.Converter;
import utility.SQLs;

public class RequestDAO implements IRequestDAO {
    private Connection connection;
    
    public RequestDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<IModel> getAllRequests(Constants.RequestSort sort) {
        Statement statement = null;
        ResultSet resultSet = null;
        // could be Class<?> or <? extends parentClass>
        Class<Request> classType = Request.class;

        try {
            String sql = SQLs.getAllRequestsSQL(sort);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return Converter.getListFromResultSet(classType, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<IModel>();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
    }

    @Override
    public void addRequest(Request request) {
    
    }
}
