package service;

import java.util.List;
import api.annotations.Inject;
import api.dao.IRequestDAO;
import api.model.IBook;
import api.model.IBookRequest;
import api.service.IRequestService;
import utility.ConfigHandler;
import utility.Constants.TypeDAO;

public class RequestService implements IRequestService {
    @Inject(daoType = TypeDAO.REQUEST_DAO) 
    private IRequestDAO requestDAO;
    private ConfigHandler.Configs configs;
    
    public RequestService(ConfigHandler.Configs configs) throws Exception {
        this.configs = configs;
    }

    public List<IBookRequest> getAllRequests() throws Exception {
        return requestDAO.getAllRequests();
    }

    public void deleteRequests(IBook book) throws Exception {
        List<IBookRequest> requests = requestDAO.getAllRequests();
        
        for(IBookRequest request : requests) {
            if(request.getBookId() == book.getId()) {
                requestDAO.deleteRecord(request.getRequestId());
            }
        }
    }
}
