package service;

import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import api.service.IBookService;
import config.JDBCInstaller;
import dao.DAOFactory;
import utility.Constants;
import utility.Constants.TypeDAO;

public class BookService implements IBookService {
    private IBookDAO bookDAO;
    
    public BookService() {
        JDBCInstaller jdbc = JDBCInstaller.getInstance();
        bookDAO = DAOFactory.getDAO(TypeDAO.BOOK, jdbc.getConnection());
    }
    
    @Override
    public List<IBook> getAllBooks(Constants.BookSort sort) throws Exception {
        return bookDAO.getAllBooks(sort);
    }

    @Override
    public String getBookDescription(int bookId) {
        // TODO Auto-generated method stub
        return null;
    }
}
