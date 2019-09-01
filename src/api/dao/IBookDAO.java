package api.dao;

import java.util.List;
import api.model.IBook;
import api.model.IModel;
import utility.BookSort;

public interface IBookDAO {
    public List<IModel> getAllBooks(BookSort sort);
    public List<IBook> getStaleBooks();
    public IBook getBookDescriprion(); //?
    public void addBookToStock(IBook book);
    public void removeBookFromStock(IBook book);
}
