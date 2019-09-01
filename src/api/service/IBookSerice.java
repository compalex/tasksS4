package api.service;

import java.util.List;
import api.model.IBook;
import utility.BookSort;

public interface IBookService {
    
    List<IBook> getAllBooks(BookSort sort);
}