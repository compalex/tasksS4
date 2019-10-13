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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addRecord(IModel model) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteRecord(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addRecord(IBookInStock book) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }
}
