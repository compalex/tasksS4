package entry_point;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import api.facade.ILibraryFacade;
import api.model.IBook;
import api.model.IOrder;
import di.InjectionHandler;
import facade.LibraryFacade;
import utility.Constants.BookSort;
import utility.Constants.OrderSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;

public class Demo {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    private static ILibraryFacade facade;
    
    public static void main(String args[]) {       
        try {
            InjectionHandler.doInjection();
        } catch (Exception e) {
            logger.error(e);
        }
        facade = LibraryFacade.getInstance();   
        try {
            showBooks(BookSort.BY_TITLE);
            //addBookToStock();
            showOrders(OrderSort.BY_PRICE);
            showRequests(RequestSort.BY_ALPHABET);
            //showStaleBooks(StaleBookSort.BY_DATE);
            //showBookDescription(2);
            //copyAnOrder(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addBookToStock() throws Exception {
        Map<IBook, Integer> books = facade.getAllBooks(BookSort.BY_PRICE);
        
        for(IBook book : books.keySet()) {
            if(book.getId() == 3) {
                System.out.println(facade.addBookToStock(book));
            }
        }
    }

    private static void showBooks(BookSort sort) throws Exception {   
        Map<IBook, Integer> books = facade.getAllBooks(sort);

        for(IBook book : books.keySet()) {
            System.out.println("____________");
            System.out.println(book.getId() + ". " + book.getTitle());
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicationDate()));
            System.out.println(book.getPrice());
            System.out.println(books.get(book) + " in stock");
        }
    }
    
    private static void showOrders(OrderSort sort) throws Exception {   
        List<IOrder> orders = facade.getAllOrders(sort);
        
        for(IOrder order : orders) {
            System.out.println("-------------");
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()));
            System.out.println(order.getPrice());
            System.out.println(order.getStatus());
        }
    }
    
    private static void showRequests(RequestSort sort) throws Exception {
        Map<IBook, Integer> books = facade.getAllRequests(RequestSort.BY_ALPHABET);

        for(IBook book : books.keySet()) {
            System.out.println("__ __ ___ __ ___");
            System.out.println(book.getId() + ". " + book.getTitle());
            System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicationDate()));
            System.out.println(book.getPrice());
            System.out.println(books.get(book) + " requests");
        }
    }
    
    private static void showStaleBooks(StaleBookSort sort) throws Exception {
        Map<IBook, List<Date>> books = facade.getStaleBooks(sort);
        
        for(IBook book : books.keySet()) {
            for(Date date : books.get(book)) {
                System.out.println("____________");
                System.out.println(book.getId() + ". " + book.getTitle());
                System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(book.getPublicationDate()));
                System.out.println(book.getPrice());
                System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(date));
            }
        }
    }
    
    private static void showBookDescription(int bookId) throws Exception {
        String description = facade.getBookDescription(bookId);
        System.out.println(description);
    }

    private static void copyAnOrder(int id) throws Exception {
        IOrder order = facade.getCopyOfOrder(id);
        
        System.out.println("-------------");
        System.out.println(new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate()));
        System.out.println(order.getPrice());
        System.out.println(order.getStatus());
    }
}
