package service;

import java.util.Date;
import java.util.List;
import api.annotations.Inject;
import api.dao.IStockDAO;
import api.model.IBook;
import api.model.IBookInStock;
import api.service.IStockService;
import facade.LibraryFacade;
import model.BookInStock;
import utility.ConfigHandler;
import utility.Constants.TypeDAO;

public class StockService implements IStockService {
    @Inject(daoType = TypeDAO.STOCK_DAO)
    private IStockDAO stockDAO;
    private ConfigHandler.Configs configs;
    
    public StockService(ConfigHandler.Configs configs) throws Exception {
        this.configs = configs;
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        return stockDAO.getStock();
    }

    @Override
    public boolean addBookToStock(IBook book) throws Exception {
        List<IBookInStock> booksInStock = getStock();
        int previousId = booksInStock.get(booksInStock.size() - 1).getId();        
        if(configs.autoRequest) {
            RequestService requestService = LibraryFacade.getInstance().requestService;
            requestService.deleteRequests(book);
        }
        return stockDAO.addRecord(new BookInStock(previousId + 1, book.getId(), new Date()));
    }
}
