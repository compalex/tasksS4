package dao.csv;

import java.io.File;
import java.util.List;
import api.dao.IStockDAO;
import api.model.IBookInStock;
import model.BookInStock;
import utility.Converter;

public class StockDAO extends ModelDAO implements IStockDAO {

    public StockDAO(String pathName) throws Exception {
        super(pathName);
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<BookInStock> classType = BookInStock.class;
        List<IBookInStock> list = Converter.getListFromListOfList(classType, records);
        return list;
    }

    @Override
    public boolean addRecord(IBookInStock book) throws Exception {
        return super.addRecord(book);
    }
}
