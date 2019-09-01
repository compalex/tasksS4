package api.service;

import java.util.List;
import api.model.IOrder;
import utility.OrderSort;

public interface IOrderService {
    
    List<IOrder> getAllOrders(OrderSort sort);
}