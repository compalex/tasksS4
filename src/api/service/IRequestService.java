package api.service;

import java.util.List;
import api.model.IRequest;
import utility.Constants;

public interface IRequestService {

    List<IRequest> getAllRequests(Constants.RequestSort sort) throws Exception;
}
