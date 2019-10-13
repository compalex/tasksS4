package dao.csv;

import java.io.File;
import java.util.List;
import api.dao.IRequestDAO;
import api.model.IBookRequest;
import model.BookRequest;
import utility.Converter;

public class RequestDAO extends ModelDAO implements IRequestDAO {

    public RequestDAO(String pathName) throws Exception {
        super(pathName);
    }

    @Override
    public List<IBookRequest> getAllRequests() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<BookRequest> classType = BookRequest.class;
        List<IBookRequest> list = Converter.getListFromListOfList(classType, records);
        return list;
    }

    @Override
    public boolean addRecord(IBookRequest request) throws Exception {
        return super.addRecord(request);
    }

    @Override
    public boolean deleteRecord(int requestId) throws Exception {
        return super.deleteRecord(requestId);
    }
}
