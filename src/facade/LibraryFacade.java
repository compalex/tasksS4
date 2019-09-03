package facade;

import java.util.List;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import api.model.IRequest;
import service.BookService;
import service.OrderService;
import service.RequestService;
import utility.Constants;

public class LibraryFacade implements ILibraryFacade {
    private static volatile ILibraryFacade instance = new LibraryFacade();
    private BookService bookService;
    private OrderService orderService;
    private RequestService requestService;

    private LibraryFacade() {
        bookService = new BookService();
        orderService = new OrderService();
        requestService = new RequestService();
    }

    public static ILibraryFacade getInstance() {
        return instance;
    }

    @Override
    public List<IBook> getAllBooks(Constants.BookSort sort) {
        return bookService.getAllBooks(sort);
    }

    @Override
    public List<IOrder> getAllOrders(Constants.OrderSort sort) {
        return orderService.getAllOrders(sort);
    }

    @Override
    public List<IRequest> getAllRequests(Constants.RequestSort sort) {
        return requestService.getAllRequests(sort);
    }

    @Override
    public void addOrder(double price) {
        new OrderService().addOrder(price);
    }
}
