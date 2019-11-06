package dao.ser;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.List;
import api.dao.IOrderDAO;
import api.model.IOrder;

public class OrderDAO extends ModelDAO implements IOrderDAO {

    public OrderDAO(String pathName) {
        super(pathName);
    }

    @Override
    public List<IOrder> getAllOrders() throws Exception {
        FileInputStream file = new FileInputStream(pathName);
        ObjectInputStream in = new ObjectInputStream(file);
        return (List<IOrder>)in.readObject();
    }

    @Override
    public List<IOrder> getCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public IOrder getOrderDetails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addOrder(IOrder order) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean completeOrder(IOrder order) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean cancelOrder(IOrder book) {
        // TODO Auto-generated method stub
        return false;
    }
}
