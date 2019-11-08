package service;

import java.util.List;
import api.annotations.Inject;
import api.dao.IOrderDAO;
import api.model.IOrder;
import api.service.IOrderService;
import utility.Constants;
import utility.Constants.OrderSort;

public class OrderService implements IOrderService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.ORDER) 
    private IOrderDAO orderDAO;
    private static IOrderService instance;

    private OrderService() {
        //just to forbid regular initializing
    }
    
    public static IOrderService getInstance() {
        if(instance == null) {
            instance = new OrderService();
        }
        return instance;
    }
    
    @Override
    public List<IOrder> getAllOrders(OrderSort sort) throws Exception {
        return orderDAO.getAllOrders();
    }

    @Override
    public boolean addOrder(IOrder order) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public IOrder getCopyOfOrder(int id) throws Exception {
        List<IOrder> orders = getAllOrders(OrderSort.BY_DATE);
        
        for(IOrder order : orders) {
            if(order.getId() == id) {
                return order.getClone();
            }
        }
        return null;
    }
}
