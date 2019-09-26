package entry_point;

import java.text.SimpleDateFormat;
import java.util.List;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import api.model.IRequest;
import facade.LibraryFacade;
import utility.Constants;

public class Demo {

    public static void main(String args[]) {
        showBooks(Constants.BookSort.BY_TITLE);
        showOrders(Constants.OrderSort.BY_PRICE);
        showRequests(Constants.RequestSort.BY_ALPHABET);
        showBookDescription(2);
    }

    public static void showBooks(Constants.BookSort sort) {
        ILibraryFacade facade = LibraryFacade.getInstance();        
        List<IBook> books = null;
        try {
            books = facade.getAllBooks(sort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(IBook book : books) {
            System.out.println("____________");
            System.out.println(book.getId() + ". " + book.getTitle());
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicationDate()));
            System.out.println(book.getPrice());
            System.out.println(book.getStockAvailability() + " in stock");
        }
    }
    
    public static void showOrders(Constants.OrderSort sort) {
        ILibraryFacade facade = LibraryFacade.getInstance();        
        List<IOrder> orders = null;
        try {
            orders = facade.getAllOrders(sort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(IOrder order : orders) {
            System.out.println("-------------");
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()));
            System.out.println(order.getPrice());
            System.out.println(order.getStatus());
        }
    }
    
    public static void showRequests(Constants.RequestSort sort) {
        ILibraryFacade facade = LibraryFacade.getInstance();  
        List<IRequest> requests = null;
        try {
            requests = facade.getAllRequests(sort);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(IRequest request : requests) {
            System.out.println("-_-___-_-___-_-");
            System.out.println(request.getTitle());
            System.out.println(request.getQuantity());
        }
    }
    
    public static void showBookDescription(int bookId) {
        ILibraryFacade facade = LibraryFacade.getInstance();
        String description = facade.getBookDescription(bookId);
        System.out.println(description);
    }
}
