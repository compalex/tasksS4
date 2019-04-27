package tasksS4_01;

import java.util.GregorianCalendar;

public class Order {
    private GregorianCalendar orderDate;
    private int price;
    private String status;
    
    public Order(GregorianCalendar orderDate, int price, String status) {
        this.orderDate = orderDate;
        this.price = price;
        this.status = status;
    }
    
    public GregorianCalendar getOrderDate() {
        return orderDate;
    }
    
    public int getPrice() {
        return price;
    }
    
    public String getStatus() {
        return status;
    }    
    
    //this method is exceptionally for MyOrderSorter
    public long getDateInMillisec() {
        return orderDate.getTimeInMillis();
    }
}
