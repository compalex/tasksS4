package facade;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import config.InjectionHandler;
import api.model.IBookRequest;
import dao.DAOFactory;
import service.BookService;
import service.OrderService;
import service.RequestService;
import service.StockService;
import utility.Constants;
import utility.Constants.BookSort;
import utility.Constants.Database;
import utility.Constants.OrderSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;
import static utility.Converter.initConfig;

public class LibraryFacade implements ILibraryFacade {
    private static volatile ILibraryFacade instance = new LibraryFacade();
    private BookService bookService;
    private OrderService orderService;
    private RequestService requestService;
    private StockService stockService;

    private LibraryFacade() {
        try {
            initConfig();
            initService(); 
            stockService = new StockService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ILibraryFacade getInstance() {
        return instance;
    }    
    
    private void initService() throws Exception {
        bookService = new BookService();
        orderService = new OrderService();
        requestService = new RequestService();
        stockService = new StockService();
        InjectionHandler.doInjection(bookService, orderService, requestService, stockService);
    }    
    
    @Override
    public IOrder getCopyOfOrder(int id) throws Exception {
        return orderService.getCopyOfOrder(id);
    }

    @Override
    public Map<IBook, Integer> getAllBooks(BookSort sort) throws Exception {
        return bookService.getAllBooks(sort);
    }

    @Override
    public Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception {
        return bookService.getStaleBooks(sort);
    }
    
    @Override
    public List<IOrder> getAllOrders(OrderSort sort) throws Exception {
        return orderService.getAllOrders(sort);
    }

    @Override
    public Map<IBook, Integer> getAllRequests(RequestSort sort) throws Exception {
        return bookService.getRequests(sort);
    }

    @Override
    public String getBookDescription(int bookId) throws Exception {
        return bookService.getBookDescription(bookId);
    }

    @Override
    public boolean addOrder(IOrder order) {
        return orderService.addOrder(order);
    }

    @Override
    public boolean addBookToStock(IBook book) throws Exception {
        return stockService.addBookToStock(book);
    }

    @Override
    public boolean addRequest(IBookRequest request) {
        return false;
    }
}
