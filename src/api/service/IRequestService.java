package api.service;

import java.util.List;
import api.model.IRequest;
import utility.RequestSort;

public interface IRequestService {

    List<IRequest> getAllRequests(RequestSort sort);
}