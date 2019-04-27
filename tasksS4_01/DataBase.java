package tasksS4_01;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class DataBase {
    private ArrayList<Book> books;
    private ArrayList<Order> orders;
    private ArrayList<BookRequest> bookRequests;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;

    public DataBase() {
        createBooks();
        createListOfBooks();
        createListOfOrders();
        createListOfBookRequests();
    }

    private void createBooks() {
        book1 = new Book(Constants.BOOK_TITLE_1, new GregorianCalendar(1998, 11, 24), 35, 3,
                new GregorianCalendar(2019, 02, 11), Constants.BOOK_DESCRIPTION_1);
        book2 = new Book(Constants.BOOK_TITLE_2, new GregorianCalendar(2018, 8, 26), 135, 0,
                new GregorianCalendar(2018, 02, 11), Constants.BOOK_DESCRIPTION_2);
        book3 = new Book(Constants.BOOK_TITLE_3, new GregorianCalendar(1992, 2, 3), 70, 0,
                new GregorianCalendar(2018, 05, 10), Constants.BOOK_DESCRIPTION_3);
        book4 = new Book(Constants.BOOK_TITLE_4, new GregorianCalendar(1954, 12, 3), 12, 1,
                new GregorianCalendar(2019, 01, 11), Constants.BOOK_DESCRIPTION_4);
        book5 = new Book(Constants.BOOK_TITLE_5, new GregorianCalendar(1982, 2, 5), 23, 6,
                new GregorianCalendar(2018, 01, 01), Constants.BOOK_DESCRIPTION_5);
        book6 = new Book(Constants.BOOK_TITLE_6, new GregorianCalendar(1974, 10, 13), 122, 0,
                new GregorianCalendar(2018, 07, 20), Constants.BOOK_DESCRIPTION_6);
    }

    private void createListOfBooks() {
        books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
    }

    private void createListOfOrders() {
        orders = new ArrayList<Order>();
        orders.add(new Order(new GregorianCalendar(2019, 3, 18), 65, Constants.ORDER_STATUS_1));
        orders.add(new Order(new GregorianCalendar(2019, 3, 11), 170, Constants.ORDER_STATUS_3));
        orders.add(new Order(new GregorianCalendar(2018, 8, 1), 135, Constants.ORDER_STATUS_1));
        orders.add(new Order(new GregorianCalendar(2019, 2, 3), 40, Constants.ORDER_STATUS_2));
        orders.add(new Order(new GregorianCalendar(2016, 11, 15), 65, Constants.ORDER_STATUS_1));
        orders.add(new Order(new GregorianCalendar(2017, 12, 3), 88, Constants.ORDER_STATUS_2));
        orders.add(new Order(new GregorianCalendar(2018, 12, 15), 65, Constants.ORDER_STATUS_1));
    }

    private void createListOfBookRequests() {
        bookRequests = new ArrayList<BookRequest>();
        bookRequests.add(new BookRequest(book2, 5));
        bookRequests.add(new BookRequest(book3, 3));
        bookRequests.add(new BookRequest(book6, 10));
    }

    public ArrayList<Book> getBookList() {
        return books;
    }

    public ArrayList<Order> getOrderList() {
        return orders;
    }

    public ArrayList<BookRequest> getBookRequestList() {
        return bookRequests;
    }
}
