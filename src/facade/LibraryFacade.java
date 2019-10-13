package facade;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import api.model.IBookRequest;
import dao.DAOFactory;
import service.BookService;
import service.OrderService;
import utility.Constants;
import utility.Constants.BookSort;
import utility.Constants.Database;
import utility.Constants.OrderSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;

public class LibraryFacade implements ILibraryFacade {
    private static volatile ILibraryFacade instance = new LibraryFacade();
    private BookService bookService;
    private OrderService orderService;

    private LibraryFacade() {
        try {
            initConfig();
            bookService = new BookService();
            orderService = new OrderService();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initConfig() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        DAOFactory.database = Database.valueOf(props.getProperty("DATABASE"));
        Constants.unsoldMonth = Integer.parseInt(props.getProperty("UNSOLD_MONTH"));
        Constants.autoRequest = Boolean.parseBoolean(props.getProperty("AUTO_COMPLETE_REQUEST"));
    }

    @Override
    public IOrder getCopyOfOrder(int id) throws Exception {
        return orderService.getCopyOfOrder(id);
    }
    
    public static ILibraryFacade getInstance() {
        return instance;
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
