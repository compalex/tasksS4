package facade;

import java.util.Date;
import java.util.List;
import java.util.Map;

import api.annotations.Inject;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IBookRequest;
import api.model.IOrder;
import service.BookService;
import service.OrderService;
import service.RequestService;
import service.StockService;
import utility.ConfigHandler;
import utility.Constants;
import utility.Constants.BookSort;
import utility.Constants.OrderSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;
import utility.InjectionHandler;

public class LibraryFacade implements ILibraryFacade {
    private static ILibraryFacade instance;
    //TODO It'd be pretty cool to overload @ to avoid "type" here
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.OTHER)
    private BookService bookService;
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.OTHER)
    private OrderService orderService;
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.OTHER)
    private RequestService requestService;
    @Inject(layer = Constants.Layer.SERVICE, type = Constants.Type.OTHER)
    private StockService stockService;

    private LibraryFacade() {
        try {
            ConfigHandler.getInstance().initConfigs();
            InjectionHandler.doInjection(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ILibraryFacade getInstance() {
        if(instance == null) {
            instance = new LibraryFacade();
        }
        return instance;
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
        return bookService.addBookToStock(book);
    }

    @Override
    public boolean addRequest(IBookRequest request) {
        return false;
    }
}
