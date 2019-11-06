package service;

import java.util.List;
import api.annotations.Inject;
import api.dao.IOrderDAO;
import api.model.IOrder;
import api.service.IOrderService;
import utility.ConfigHandler;
import utility.Constants.OrderSort;
import utility.Constants.TypeDAO;

public class OrderService implements IOrderService {
    @Inject(daoType = TypeDAO.ORDER_DAO)
    private IOrderDAO orderDAO;
    private ConfigHandler.Configs configs;

    public OrderService(ConfigHandler.Configs configs) throws Exception {
        this.configs = configs;
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
