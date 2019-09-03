package service;

import java.util.List;
import api.dao.IRequestDAO;
import api.model.IRequest;
import api.service.IRequestService;
import config.JDBCInstaller;
import utility.Constants;

public class RequestService implements IRequestService {
    private IRequestDAO requestDAO;
        
    public RequestService() {
            JDBCInstaller jdbc = JDBCInstaller.getInstance();
            requestDAO = jdbc.createRequestDAO();
    }
    
    @Override
    public List<IRequest> getAllRequests(Constants.RequestSort sort) {
        return (List<IRequest>)(List<?>)requestDAO.getAllRequests(sort);
    }
}
