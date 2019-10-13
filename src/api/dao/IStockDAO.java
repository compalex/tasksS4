package api.dao;

import java.util.List;
import api.model.IBookInStock;

public interface IStockDAO {
    List<IBookInStock> getStock() throws Exception;
    boolean addRecord(IBookInStock book) throws Exception;
    
}
