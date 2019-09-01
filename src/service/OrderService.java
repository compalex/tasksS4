package service;

import java.util.List;

import api.dao.IOrderDAO;
import api.model.IOrder;
import api.service.IOrderService;
import config.JDBCInstaller;
import utility.OrderSort;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;

    public OrderService() {
        JDBCInstaller jdbc = JDBCInstaller.getInstance();
        orderDAO = jdbc.createOrderDAO();
    }
    
    public List<IOrder> getAllOrders(OrderSort sort) {
        return (List<IOrder>)(List<?>)orderDAO.getAllOrders(sort);
    }
    
    public void addOrder(double price) {

    }
}