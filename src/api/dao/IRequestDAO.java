package api.dao;

import java.util.List;
import api.model.IRequest;
import model.Request;
import utility.Constants;

public interface IRequestDAO {
    public List<IRequest> getAllRequests(Constants.RequestSort sort) throws Exception;
    public boolean addRequest(Request request);
}
