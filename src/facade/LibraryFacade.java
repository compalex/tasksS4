package facade;

import java.util.Date;
import java.util.List;
import java.util.Map;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import api.model.IBookRequest;
import service.BookService;
import service.OrderService;
import service.RequestService;
import service.StockService;
import utility.ConfigHandler;
import utility.InjectionHandler;
import utility.Constants.BookSort;
import utility.Constants.OrderSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;

public class LibraryFacade implements ILibraryFacade {
    private static volatile LibraryFacade instance = new LibraryFacade();
    public BookService bookService;
    public OrderService orderService;
    public RequestService requestService;
    public StockService stockService;

    private LibraryFacade() {
        try {
            initServices(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //TODO can't return interface
    public static LibraryFacade getInstance() {
        return instance;
    }    
    
    private void initServices() throws Exception {
        ConfigHandler.Configs configs = new ConfigHandler().getConfigs();
        bookService = new BookService(configs);
        orderService = new OrderService(configs);
        requestService = new RequestService(configs);
        stockService = new StockService(configs);
        InjectionHandler.doInjection(bookService, orderService, requestService, stockService, configs.database);
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
