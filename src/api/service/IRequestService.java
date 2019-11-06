package api.service;

import java.util.List;
import api.model.IBookRequest;

public interface IRequestService {
    List<IBookRequest> getAllRequests() throws Exception;
}
