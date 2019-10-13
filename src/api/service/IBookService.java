package api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import api.model.IBook;
import utility.Constants;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;

public interface IBookService {
    Map<IBook, Integer> getAllBooks(Constants.BookSort sort) throws Exception;
    Map<IBook, Integer> getRequests(RequestSort sort) throws Exception;
    Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception;
    String getBookDescription(int bookId) throws Exception;
    boolean addBookToStock(IBook book) throws Exception;
}
