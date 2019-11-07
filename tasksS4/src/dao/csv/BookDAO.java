package dao.csv;

import java.io.File;
import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import model.Book;
import utility.Converter;

public class BookDAO extends ModelDAO implements IBookDAO {
    
    public BookDAO(String pathName) throws Exception {
        super(pathName);
    }

    @Override
    public List<IBook> getAllBooks() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<Book> classType = Book.class;
        List<IBook> list = Converter.getListFromListOfList(classType, records);
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
