package api.service;

import java.util.List;

import api.model.IBook;
import api.model.IBookRequest;

public interface IRequestService {
    List<IBookRequest> getAllRequests() throws Exception;
    void deleteRequests(IBook book) throws Exception;
}
