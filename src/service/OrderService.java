package service;

import java.util.List;
import api.dao.IOrderDAO;
import api.model.IOrder;
import api.service.IOrderService;
import dao.DAOFactory;
import model.Order;
import utility.Constants.OrderSort;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;

    public OrderService() throws Exception {
        orderDAO = DAOFactory.getOrderDAO();
    }
    
    @Override
    public List<IOrder> getAllOrders(OrderSort sort) throws Exception {
        return orderDAO.getAllOrders();
    }
    
    public void addOrder(double price) {

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
