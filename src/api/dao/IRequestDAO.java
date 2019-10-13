package api.dao;

import java.util.List;
import api.model.IBookRequest;

public interface IRequestDAO {
    public List<IBookRequest> getAllRequests() throws Exception;
    public boolean addRecord(IBookRequest request) throws Exception;
    public boolean deleteRecord(int requestId) throws Exception;
}
