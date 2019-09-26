package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import model.Book;
import utility.Constants;
import utility.Converter;
import utility.SQLs;

public class BookDAO extends ModelDAO implements IBookDAO {

    public BookDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IBook> getAllBooks(Constants.BookSort sort) throws Exception {
        Statement statement = null;
        ResultSet resultSet = null;
        Class<Book> classType = Book.class;
        String sql = SQLs.getAllBooksSQL(sort);
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sql);
        List<IBook> list = Converter.getListFromResultSet(classType, resultSet);
        return list;
    }
    
    @Override
    public List<IBook> getStaleBooks() {
        return null;
    }

    @Override
    public boolean addBookToStock(IBook book) {
        return false;
    }

    @Override
    public boolean removeBookFromStock(IBook book) {
        return false;
    }

    @Override
    public IBook getBookDescriprion() {
        return null;
    }

    @Override
    void updateRecord() {
   
    }

    @Override
    void deleteRecord() {
   
    }
}
