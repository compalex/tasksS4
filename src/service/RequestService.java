package service;

import java.util.List;

import api.dao.IRequestDAO;
import api.model.IRequest;
import api.service.IRequestService;
import config.JDBCInstaller;
import utility.RequestSort;

public class RequestService implements IRequestService {
    private IRequestDAO requestDAO;
        
    public RequestService() {
            JDBCInstaller jdbc = JDBCInstaller.getInstance();
            requestDAO = jdbc.createRequestDAO();
    }
    
    public List<IRequest> getAllRequests(RequestSort sort) {
        return (List<IRequest>)(List<?>)requestDAO.getAllRequests(sort);
    }
}
