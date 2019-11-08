package service;

import java.util.List;
import api.annotations.Inject;
import api.dao.IRequestDAO;
import api.model.IBook;
import api.model.IBookRequest;
import api.service.IRequestService;
import utility.Constants;

public class RequestService implements IRequestService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.REQUEST) 
    private IRequestDAO requestDAO;
    private static IRequestService instance;

    private RequestService() {
        //just to forbid regular initializing
    }
    
    public static IRequestService getInstance() {
        if(instance == null) {
            instance = new RequestService();
        }
        return instance;
    }
    
    @Override
    public List<IBookRequest> getAllRequests() throws Exception {
        return requestDAO.getAllRequests();
    }

    @Override
    public void deleteRequests(IBook book) throws Exception {
        List<IBookRequest> requests = requestDAO.getAllRequests();
        
        for(IBookRequest request : requests) {
            if(request.getBookId() == book.getId()) {
                requestDAO.deleteRecord(request.getRequestId());
            }
        }
    }
}
