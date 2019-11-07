package dao.sql;

import java.sql.Connection;
import java.util.List;
import api.dao.IStockDAO;
import api.model.IBookInStock;
import api.model.IModel;

public class StockDAO extends ModelDAO implements IStockDAO {

    public StockDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        return null;
    }

    @Override
    public boolean addRecord(IModel model) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) {
        return false;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        return false;
    }

    @Override
    public boolean addRecord(IBookInStock book) throws Exception {
        return false;
    }
}
