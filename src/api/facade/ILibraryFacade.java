package api.facade;

import java.util.List;
import api.model.IBook;
import api.model.IOrder;
import api.model.IRequest;
import utility.Constants;

public interface ILibraryFacade {
    
    List<IBook> getAllBooks(Constants.BookSort sort);
    List<IOrder> getAllOrders(Constants.OrderSort sort);
    List<IRequest> getAllRequests(Constants.RequestSort sort);
    void addOrder(double price);
}
