package dao.csv;

import java.io.File;
import java.util.Date;
import java.util.List;
import api.dao.IOrderDAO;
import api.model.IOrder;
import model.Order;
import utility.Converter;

public class OrderDAO extends ModelDAO implements IOrderDAO {

    public OrderDAO(String pathName) throws Exception {
        super(pathName);
    }
    
    @Override
    public List<IOrder> getAllOrders() throws Exception {
        File file = new File(pathName);
        List<List<String>> records = Converter.getRecordsCVS(file);                
        Class<Order> classType = Order.class;
        List<IOrder> list = Converter.getListFromListOfList(classType, records);
        return list;
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
