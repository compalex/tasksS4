package api.dao;

import java.util.List;
import api.model.IBook;
import utility.Constants;

public interface IBookDAO {
    public List<IBook> getAllBooks(Constants.BookSort sort) throws Exception;
    public List<IBook> getStaleBooks();
    public IBook getBookDescriprion(); 
    public boolean addBookToStock(IBook book);
    public boolean removeBookFromStock(IBook book);
}
