package dao.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import api.dao.IRequestDAO;
import api.model.IBookRequest;
import model.BookRequest;
import utility.Converter;
import utility.SQLs;
import utility.Constants.RequestSort;

public class RequestDAO extends ModelDAO implements IRequestDAO {

    public RequestDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public List<IBookRequest> getAllRequests() throws Exception {
        Statement statement = null;
        ResultSet resultSet = null;
        Class<BookRequest> classType = BookRequest.class;
        String sql = SQLs.getAllRequestsSQL(RequestSort.BY_ALPHABET);
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sql);
        return Converter.getListFromResultSet(classType, resultSet);
    }

    @Override
    public boolean addRecord(IBookRequest request) throws Exception {
        return super.addRecord(request);
    }

    @Override
    public boolean deleteRecord(int requestId) {
        // TODO Auto-generated method stub
        return false;
    }
}
