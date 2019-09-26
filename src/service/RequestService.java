package service;

import java.util.List;
import api.dao.IRequestDAO;
import api.model.IRequest;
import api.service.IRequestService;
import config.JDBCInstaller;
import dao.DAOFactory;
import utility.Constants;

public class RequestService implements IRequestService {
    private IRequestDAO requestDAO;
        
    public RequestService() {
            JDBCInstaller jdbc = JDBCInstaller.getInstance();
            requestDAO = DAOFactory.getRequestDAO(jdbc.getConnection());
    }
    
    @Override
    public List<IRequest> getAllRequests(Constants.RequestSort sort) throws Exception {
        return requestDAO.getAllRequests(sort);
    }
}
