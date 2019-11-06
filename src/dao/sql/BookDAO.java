package dao.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import model.Book;
import utility.Constants.BookSort;
import utility.Converter;
import utility.SQLs;

public class BookDAO extends ModelDAO implements IBookDAO {

    public BookDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IBook> getAllBooks() throws Exception {
        BookSort sort = BookSort.BY_PRICE;
        Class<Book> classType = Book.class;
        String sql = SQLs.getAllBooksSQL(sort);
        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(sql);
        List<IBook> list = Converter.getListFromResultSet(classType, resultSet);
        return list;
    }

    @Override
    public String getBookDescriprion(int bookId) {
        return null;
    }

    @Override
    public boolean addRecord(IBook book) throws Exception {
        return super.addRecord(book);
    }
}
