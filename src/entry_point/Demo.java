package entry_point;

import java.text.SimpleDateFormat;
import java.util.List;

import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import api.model.IRequest;
import facade.LibraryFacade;
import utility.BookSort;
import utility.OrderSort;
import utility.RequestSort;

public class Demo {

    public static void main(String args[]) {
        
        //showBooks(BookSort.BY_TITLE);
        
        //showOrders(OrderSort.BY_PRICE);
        
        showRequests(RequestSort.BY_ALPHABET);
    }

    public static void showBooks(BookSort sort) {
        ILibraryFacade facade = LibraryFacade.getInstance();        
        List<IBook> books = facade.getAllBooks(sort);
        
        for(IBook book : books) {
            System.out.println("____________");
            System.out.println(book.getId() + ". " + book.getTitle());
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicationDate()));
            System.out.println(book.getPrice());
            System.out.println(book.getStockAvailability() + " in stock");
        }
    }
    
    public static void showOrders(OrderSort sort) {
        ILibraryFacade facade = LibraryFacade.getInstance();        
        List<IOrder> orders = facade.getAllOrders(sort);
        
        for(IOrder order : orders) {
            System.out.println("-------------");
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()));
            System.out.println(order.getPrice());
            System.out.println(order.getStatus());
        }
    }
    
    public static void showRequests(RequestSort sort) {
        ILibraryFacade facade = LibraryFacade.getInstance();  
        List<IRequest> requests = facade.getAllRequests(sort);
        
        for(IRequest request : requests) {
            System.out.println("-_-___-_-___-_-");
            System.out.println(request.getTitle());
            System.out.println(request.getQuantity());
        }
    }
}
