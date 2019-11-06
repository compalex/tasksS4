package dao.ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import api.dao.IBookDAO;
import api.model.IBook;
import utility.Constants;

public class BookDAO extends ModelDAO implements IBookDAO {

    public BookDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<IBook> getAllBooks() throws Exception {
        FileInputStream file = new FileInputStream(pathName);
        ObjectInputStream in = new ObjectInputStream(file);
        return (List<IBook>)in.readObject();
    }

    @Override
    public String getBookDescriprion(int bookId) throws Exception {
        List<IBook> allBooks = getAllBooks();
        
        for(IBook book : allBooks) {
            if(book.getId() == bookId) {
                return book.getDescription();
            }
        }
        return Constants.ERROR;
    }

    @Override
    public boolean addRecord(IBook book) throws Exception {
        return super.addRecord(book);
    }
}
