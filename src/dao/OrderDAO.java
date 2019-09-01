package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import api.dao.IOrderDAO;
import api.model.IModel;
import api.model.IOrder;
import model.Order;
import utility.Converter;
import utility.OrderSort;
import utility.SQLs;

public class OrderDAO implements IOrderDAO {
    private Connection connection;
    
    public OrderDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<IModel> getAllOrders(OrderSort sort) {
        Statement statement = null;
        ResultSet resultSet = null;
        Class<Order> classType = Order.class;

        try {
            String sql = SQLs.getAllOrdersSQL(sort);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return Converter.getListFromResultSet(classType, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<IModel>();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException ex) {
            ex.printStackTrace();
            }
        }
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
    public void addOrder(IOrder order) {
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
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                //am I supposed to close connection at all?
                connection.close();
            } catch(SQLException ex) {
                System.err.print("Couldn't close DB connection");
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void completeOrder(IOrder order) {    
    }

    @Override
    public void cancelOrder(IOrder book) {        
    }
}