package api.model;

import java.util.Date;

public interface IOrder extends IModel{
    
    int getId();
    Date getOrderDate();
    double getPrice();
    String getStatus();
}