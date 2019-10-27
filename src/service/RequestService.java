package service;

import java.util.List;

import api.annotations.Inject;
import api.dao.IRequestDAO;
import api.model.IBook;
import api.model.IBookRequest;
import api.service.IRequestService;
import dao.DAOFactory;

public class RequestService implements IRequestService {
    @Inject(daoType = "requestDAO") 
    private IRequestDAO requestDAO;
    
    public RequestService() throws Exception {
        requestDAO = DAOFactory.getRequestDAO();
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
