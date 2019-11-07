package api.dao;

import java.util.List;
import api.model.IBook;

public interface IBookDAO {
    List<IBook> getAllBooks() throws Exception;
    String getBookDescriprion(int bookId) throws Exception; 
    boolean addRecord(IBook book) throws Exception;
}
