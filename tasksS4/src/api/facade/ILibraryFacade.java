package api.facade;

import java.util.Date;
import java.util.List;
import java.util.Map;
import api.model.IBook;
import api.model.IOrder;
import api.model.IBookRequest;
import utility.Constants.BookSort;
import utility.Constants.OrderSort;
import utility.Constants.RequestSort;
import utility.Constants.StaleBookSort;

public interface ILibraryFacade {
    Map<IBook, Integer> getAllBooks(BookSort sort) throws Exception;
    List<IOrder> getAllOrders(OrderSort sort) throws Exception;
    Map<IBook, Integer> getAllRequests(RequestSort sort) throws Exception;
    Map<IBook, List<Date>> getStaleBooks(StaleBookSort sort) throws Exception;
    String getBookDescription(int bookId) throws Exception;
    boolean addOrder(IOrder order);
    boolean addBookToStock(IBook book) throws Exception;
    boolean addRequest(IBookRequest request);
    IOrder getCopyOfOrder(int id) throws Exception;
}
