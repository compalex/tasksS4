package api.service;

import java.util.List;
import api.model.IBook;
import utility.Constants;

public interface IBookService {
    
    List<IBook> getAllBooks(Constants.BookSort sort) throws Exception;
    String getBookDescription(int bookId);
}
