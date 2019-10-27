package service;

import java.util.Date;
import java.util.List;
import api.annotations.Inject;
import api.dao.IStockDAO;
import api.model.IBook;
import api.model.IBookInStock;
import api.service.IStockService;
import dao.DAOFactory;
import model.BookInStock;
import utility.Constants;

public class StockService implements IStockService {
    @Inject(daoType = "stockDAO")
    private IStockDAO stockDAO;
    
    public StockService() throws Exception {
        stockDAO = DAOFactory.getStockDAO();
    }

    @Override
    public List<IBookInStock> getStock() throws Exception {
        return stockDAO.getStock();
    }

    @Override
    public boolean addBookToStock(IBook book) throws Exception {
        List<IBookInStock> booksInStock = getStock();
        int previousId = booksInStock.get(booksInStock.size() - 1).getId();
        
        if(Constants.autoRequest) {
            RequestService requestService = new RequestService();
            requestService.deleteRequests(book);
        }
        return stockDAO.addRecord(new BookInStock(previousId + 1, book.getId(), new Date()));
    }

}
