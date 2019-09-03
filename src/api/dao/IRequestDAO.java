package api.dao;

import java.util.List;
import api.model.IModel;
import model.Request;
import utility.Constants;

public interface IRequestDAO {
    public List<IModel> getAllRequests(Constants.RequestSort sort);
    public void addRequest(Request request);
}
