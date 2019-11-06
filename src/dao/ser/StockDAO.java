package dao.ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import api.dao.IStockDAO;
import api.model.IBookInStock;

public class StockDAO extends ModelDAO implements IStockDAO {

    public StockDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        FileInputStream file = new FileInputStream(pathName);
        ObjectInputStream in = new ObjectInputStream(file);
        return (List<IBookInStock>)in.readObject();
    }

    @Override
    public boolean addRecord(IBookInStock book) throws Exception {
        return false;
    }
}
