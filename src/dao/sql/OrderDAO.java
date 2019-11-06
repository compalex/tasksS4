package dao.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import api.dao.IOrderDAO;
import api.model.IOrder;
import model.Order;
import utility.Converter;
import utility.SQLs;
import utility.Constants.OrderSort;

public class OrderDAO extends ModelDAO implements IOrderDAO {
    
    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<IOrder> getAllOrders() throws Exception {
        OrderSort sort = OrderSort.BY_DATE;
        Class<Order> classType = Order.class;
        String sql = SQLs.getAllOrdersSQL(sort);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return Converter.getListFromResultSet(classType, resultSet);
    }

    @Override
    public List<IOrder> getCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        return null;
    }

    @Override
    public double getAmountOfFundsOverTime(Date dateFrom, Date dateTo) {
        return 0;
    }

    @Override
    public int getNumOfCompletedOrdersOverTime(Date dateFrom, Date dateTo) {
        return 0;
    }

    @Override
    public IOrder getOrderDetails() {
        return null;
    }

    @Override
    public boolean addOrder(IOrder order) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `orders` (`date`, `price`, `status`) VALUES ('"
                    + new SimpleDateFormat("yyyy/MM/dd").format(order.getOrderDate())
                    + "', "
                    + order.getPrice() 
                    + ", '"
                    + order.getStatus()
                    +"')");   
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
            } catch(SQLException ex) {
                System.err.print("Couldn't close DB connection");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean completeOrder(IOrder order) {
        return false;
    }

    @Override
    public boolean cancelOrder(IOrder book) {
        return false;
    }
}
