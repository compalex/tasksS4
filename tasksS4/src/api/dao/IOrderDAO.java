package api.dao;

import java.util.Date;
import java.util.List;
import api.model.IOrder;

public interface IOrderDAO {
    public List<IOrder> getAllOrders() throws Exception;
    public List<IOrder> getCompletedOrdersOverTime(Date dateFrom, Date dateTo);
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo);
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo);
    public IOrder getOrderDetails(); 
    public boolean addOrder(IOrder order);
    public boolean completeOrder(IOrder order);
    public boolean cancelOrder(IOrder book);
}
