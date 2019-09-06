package api.service;

import java.util.List;
import api.model.IOrder;
import utility.Constants;

public interface IOrderService {
    
    List<IOrder> getAllOrders(Constants.OrderSort sort) throws Exception;
}
