package tasksS4_01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Printer {
    private static DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
    
    public static void printListOfBooks(ArrayList<Book> books) {
        for (Book next : books) {
            System.out.println(Constants.LINE);
            System.out.println(next.getTitle());
            System.out.println(dateFormat.format(next.getPublicationDate().getTime()));
            System.out.println(next.getPrice());
            System.out.println(next.getStockAvailability());
            System.out.println();
            System.out.println(Constants.LINE);
        }
    }

    public static void printListOfOrders(ArrayList<Order> orders) {
        for (Order next : orders) {
            System.out.println(Constants.LINE);
            System.out.println(dateFormat.format(next.getOrderDate().getTime()));
            System.out.println(next.getPrice());
            System.out.println(next.getStatus());
            System.out.println();
            System.out.println(Constants.LINE);
        }
    }
    
    public static void printListOfBookRequests(ArrayList<BookRequest> bookRequests) {
        for (BookRequest next : bookRequests) {
            System.out.println(Constants.LINE);
            System.out.println(next.getTitle());
            System.out.println(Constants.NUM_REQUESTS + next.getRequestNum());
            System.out.println();
            System.out.println(Constants.LINE);
        }
    }

    public static void printListOfOrdersByDate(Date date1, Date date2, ArrayList<Order> orders) {
        for (Order next : orders) {
            if (next.getStatus() == Constants.ORDER_STATUS_1 && next.getDateInMillisec() > date1.getTime()
                    && next.getDateInMillisec() < date2.getTime()) {
                System.out.println(Constants.LINE);
                System.out.println(dateFormat.format(next.getOrderDate().getTime()));
                System.out.println(next.getPrice());
                System.out.println(next.getStatus());
                System.out.println();
                System.out.println(Constants.LINE);
            }
        }
    }

    public static void printEarnedMoney(Date date1, Date date2, ArrayList<Order> orders) {
        int sum = 0;

        for (Order next : orders) {
            if (next.getStatus() == Constants.ORDER_STATUS_1 && next.getDateInMillisec() > date1.getTime()
                    && next.getDateInMillisec() < date2.getTime()) {
                sum += next.getPrice();
            }
        }
        System.out.println(Constants.EARNED_MONEY + sum);
    }

    public static void printOrderQuantity(Date date1, Date date2, ArrayList<Order> orders) {
        int quantity = 0;

        for (Order next : orders) {
            if (next.getStatus() == Constants.ORDER_STATUS_1 && next.getDateInMillisec() > date1.getTime()
                    && next.getDateInMillisec() < date2.getTime()) {
                quantity++;
            }
        }
        System.out.println(Constants.ORDERS_NUM + quantity);
    }
    
    public static void printStaleListOfBooks(ArrayList<Book> books) {
        Date date = new Date();
        
        for (Book next : books) {
            if(next.getStockAvailability() && (date.getTime() - next.getStoreDateInMillisec()) > Constants.MONTH_6) {
                System.out.println(Constants.LINE);
                System.out.println(next.getTitle());
                System.out.println(dateFormat.format(next.getStoreDate().getTime()));
                System.out.println(next.getPrice());
                System.out.println();
                System.out.println(Constants.LINE);
            }
        }
    }
}
