package service;

import java.util.List;
import api.annotations.Inject;
import api.dao.IStockDAO;
import api.model.IBookInStock;
import api.service.IStockService;
import utility.Constants;

public class StockService implements IStockService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.STOCK) 
    private IStockDAO stockDAO;
    private static IStockService instance;

    private StockService() {
        //just to forbid regular initializing
    }
    
    public static IStockService getInstance() {
        if(instance == null) {
            instance = new StockService();
        }
        return instance;
    }
    
    @Override
    public List<IBookInStock> getStock() throws Exception {
        return stockDAO.getStock();
    }
}
