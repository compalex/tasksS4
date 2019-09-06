package service;

import java.util.List;
import api.dao.IOrderDAO;
import api.model.IOrder;
import api.service.IOrderService;
import config.JDBCInstaller;
import utility.Constants;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;

    public OrderService() {
        JDBCInstaller jdbc = JDBCInstaller.getInstance();
        orderDAO = jdbc.createOrderDAO();
    }
    
    @Override
    public List<IOrder> getAllOrders(Constants.OrderSort sort) throws Exception {
        return orderDAO.getAllOrders(sort);
    }
    
    public void addOrder(double price) {

    }
}
