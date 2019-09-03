package service;

import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import api.service.IBookService;
import config.JDBCInstaller;
import utility.Constants;

public class BookService implements IBookService {
    private IBookDAO bookDAO;
    
    public BookService() {
        JDBCInstaller jdbc = JDBCInstaller.getInstance();
        bookDAO = jdbc.createBookDAO();
    }
    
    @Override
    public List<IBook> getAllBooks(Constants.BookSort sort) {
        return (List<IBook>)(List<?>)bookDAO.getAllBooks(sort);
    }
}
