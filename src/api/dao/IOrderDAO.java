package api.dao;

import java.util.Date;
import java.util.List;
import api.model.IModel;
import api.model.IOrder;
import utility.Constants;

public interface IOrderDAO {
    public List<IModel> getAllOrders(Constants.OrderSort sort);
    public List<IOrder> getCompletedOrdersOverTime(Date dateFrom, Date dateTo);
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo);
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo);
    public IOrder getOrderDetails(); //?
    public void addOrder(IOrder order);
    public void completeOrder(IOrder order);
    public void cancelOrder(IOrder book);
}
