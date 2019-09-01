package api.dao;

import java.util.List;
import api.model.IModel;
import model.Request;
import utility.RequestSort;

public interface IRequestDAO {
    public List<IModel> getAllRequests(RequestSort sort);
    public void addRequest(Request request);
}