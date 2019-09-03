package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import api.model.IModel;
import model.Book;
import utility.Constants;
import utility.Converter;
import utility.SQLs;

public class BookDAO implements IBookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<IModel> getAllBooks(Constants.BookSort sort) {
        Statement statement = null;
        ResultSet resultSet = null;
        // could be Class<?> or <? extends parentClass>
        Class<Book> classType = Book.class;

        try {
            String sql = SQLs.getAllBooksSQL(sort);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return Converter.getListFromResultSet(classType, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<IModel>();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<IBook> getStaleBooks() {
        return null;
    }

    @Override
    public void addBookToStock(IBook book) {
    }

    @Override
    public void removeBookFromStock(IBook book) {
    }

    @Override
    public IBook getBookDescriprion() {
        return null;
    }
}
