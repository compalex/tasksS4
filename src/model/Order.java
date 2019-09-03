package model;

import java.util.Date;

import api.annotations.Columns;
import api.model.IOrder;

public class Order implements IOrder {
    @Columns(name = "order_id")
    private Integer id;
    @Columns(name = "date")
    private Date orderDate;
    private Double price;
    private String status;
    
    public Order() {
        
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
}
