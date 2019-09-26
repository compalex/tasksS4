package api.facade;

import java.util.List;
import api.model.IBook;
import api.model.IOrder;
import api.model.IRequest;
import utility.Constants;

public interface ILibraryFacade {
    List<IBook> getAllBooks(Constants.BookSort sort) throws Exception;
    List<IOrder> getAllOrders(Constants.OrderSort sort) throws Exception;
    List<IRequest> getAllRequests(Constants.RequestSort sort) throws Exception;
    String getBookDescription(int bookId);
    boolean addOrder(double price);
}
