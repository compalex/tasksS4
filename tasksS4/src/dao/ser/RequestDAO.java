package dao.ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import api.dao.IRequestDAO;
import api.model.IBookRequest;

public class RequestDAO extends ModelDAO implements IRequestDAO {

    public RequestDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<IBookRequest> getAllRequests() throws Exception {
        FileInputStream file = new FileInputStream(pathName);
        ObjectInputStream in = new ObjectInputStream(file);
        return (List<IBookRequest>)in.readObject();
    }

    @Override
    public boolean addRecord(IBookRequest request) throws Exception {
        return super.addRecord(request);
    }

    @Override
    public boolean deleteRecord(int requestID) {
        // TODO Auto-generated method stub
        return false;
    }
}
