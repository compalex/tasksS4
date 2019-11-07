package model;

import java.util.Date;
import api.annotations.Columns;
import api.model.IOrder;

public class Order implements IOrder {
    @Columns(name = "order_id")
    private Integer id;
    @Columns(name = "date")
    private Date orderDate;
    @Columns(name = "price")
    private Double price;
    @Columns(name = "status")
    private String status;
    
    public Order() {
      //used by dao
    }

    @Override
    public int getId() {
        return id;
    }  
    
    @Override
    public Date getOrderDate() {
        return orderDate;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public String getStatus() {
        return status;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Order)super.clone();
    }

    @Override
    public IOrder getClone() throws CloneNotSupportedException {
        IOrder order = (IOrder) clone();
        order.setId(null);
        return order;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
