package facade;

import java.util.List;

import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import api.model.IRequest;
import service.BookService;
import service.OrderService;
import service.RequestService;
import utility.BookSort;
import utility.OrderSort;
import utility.RequestSort;

public class LibraryFacade implements ILibraryFacade {
    private static volatile ILibraryFacade instance = new LibraryFacade();
    
    private LibraryFacade() {
        //constructor BODY
    }
    
    public static ILibraryFacade getInstance() {
        return instance;
    }
    
    public List<IBook> getAllBooks(BookSort sort) {
        return new BookService().getAllBooks(sort);
    }
    
    public List<IOrder> getAllOrders(OrderSort sort) {
        return new OrderService().getAllOrders(sort);
    }
    
    public List<IRequest> getAllRequests(RequestSort sort){
        return new RequestService().getAllRequests(sort);
    }
    
    public void addOrder(double price) {
        new OrderService().addOrder(price);
    }
}