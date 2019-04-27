package tasksS4_01;

/**
 * The program represents virtual bookstore
 * Task S4_01
 * @version 1.0
 * @author compalex
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Demo {
    private static DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
    private static Date dateFrom, dateTo;
    private static ArrayList<Book> books;
    private static ArrayList<Order> orders;
    private static ArrayList<BookRequest> bookRequests;
    private static boolean needToRepeat;
    private static Scanner sc = null;

    public static void main(String[] args) {
        DataBase data = new DataBase();
        books = data.getBookList();
        orders = data.getOrderList();
        bookRequests = data.getBookRequestList();
        sc = new Scanner(System.in);
        
        try {
            do {
                // gets a choice from the main menu
                showMenu(Constants.MAIN_MENU);
                int choice1 = getInput(Constants.MAIN_MENU);
                System.out.println(Constants.MAIN_MENU[choice1]);
                System.out.println();
                // gets a choice from the secondary menu (zero if there's no need to)
                int choice2 = getChoice2(choice1);
                System.out.println();
                // sorts list of 'choice1' in comparator of 'choice2' (or does smth else)
                doWhatUserChose(choice1, choice2);
                // asks the user if it is necessary to repeat the program
                needToRepeat = doAgain();
            } while (needToRepeat);
        } catch(InputMismatchException e) {
            System.err.println(e);
        } finally {
            sc.close();
        }
        System.out.println(Constants.GOODBYE_MSG);
    }

    private static void showMenu(String[] menu) {
        for (String line : menu) {
            System.out.println(line);
        }
    }
    
    private static int getInput(String[] inputPrompt) {
        try {
            int choice = sc.nextInt();
            if (choice < 1 || choice >= inputPrompt.length) {
                System.out.println(Constants.INPUT_ERROR_2 + (inputPrompt.length - 1));
                return getInput(inputPrompt);
            } else
                return choice;
        } catch (InputMismatchException e) {
            System.out.print(Constants.INPUT_ERROR);
            return getInput(inputPrompt);
        } 
    }
    
    private static int getChoice2(int choice) {
        int choice2;
        switch (choice) {
        case 1:
            showMenu(Constants.MENU_1);
            choice2 = getInput(Constants.MENU_1);
            System.out.println(Constants.MENU_1[choice2]);
            return choice2;
        case 2:
            showMenu(Constants.MENU_2);
            choice2 = getInput(Constants.MENU_2);
            System.out.println(Constants.MENU_2[choice2]);
            return choice2;
        case 3:
            showMenu(Constants.MENU_3);
            choice2 = getInput(Constants.MENU_3);
            System.out.println(Constants.MENU_3[choice2]);
            return choice2;
        case 4:
            showMenu(Constants.MENU_4);
            choice2 = getInput(Constants.MENU_4);
            System.out.println(Constants.MENU_4[choice2]);
            return choice2;
        case 5:
            return 0;
        case 6:
            return 0;
        case 7:
            showMenu(Constants.MENU_7);
            choice2 = getInput(Constants.MENU_7);
            System.out.println(Constants.MENU_7[choice2]);
            return choice2;
        case 8:
            return 0;
        case 9:
            return 0;
        default:
            return 0;
        }
    }

    private static void doWhatUserChose(int choice1, int choice2) {
        switch (choice1) {
        case 1:
            Collections.sort(books, new MyBookSorter(choice2));
            Printer.printListOfBooks(books);
            return;
        case 2:
            Collections.sort(orders, new MyOrderSorter(choice2));
            Printer.printListOfOrders(orders);
            return;
        case 3:
            Collections.sort(bookRequests, new BookRequestSorter(choice2));
            Printer.printListOfBookRequests(bookRequests);
            return;
        case 4:
            Collections.sort(orders, new MyOrderSorter(choice2));
            getTimePeriod();
            Printer.printListOfOrdersByDate(dateFrom, dateTo, orders);
            return;
        case 5:
            getTimePeriod();
            Printer.printEarnedMoney(dateFrom, dateTo, orders);
            return;
        case 6:
            getTimePeriod();
            Printer.printOrderQuantity(dateFrom, dateTo, orders);
            return;
        case 7:
            Collections.sort(books, new MyBookSorter(choice2 * 10));
            Printer.printStaleListOfBooks(books);
            return;
        }
    }
    
    private static boolean doAgain() {
        showMenu(Constants.REPEAT_PROMPT);
        if (getInput(Constants.REPEAT_PROMPT) == Constants.ONE) {
            return true;
        } else if (getInput(Constants.REPEAT_PROMPT) == Constants.TWO) {
            return false;
        } else {
            return doAgain();
        }
    }

    private static void getTimePeriod() {
        System.out.println(Constants.ASK_DATE_1 + Constants.DATE_FORMAT);
        dateFrom = getDate();
        System.out.println(Constants.ASK_DATE_2 + Constants.DATE_FORMAT);
        dateTo = getDate();
    }
    
    private static Date getDate() {
        Date date = null;
        try {
            date = dateFormat.parse(sc.next());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    private static void addBook() {
        System.out.println(Constants.BOOK_TITLE_PROMPT);
        String title = sc.nextLine();
        
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                book.addToStock();
                System.out.println(title + Constants.BOOK_ADDED_MSG);
                return;
            }
        }
        System.out.println(Constants.BOOK_NOT_FOUND);
    }
    
    private static void removeBook() {
        System.out.println(Constants.BOOK_TITLE_PROMPT);
        String title = sc.nextLine();
        
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                book.removeFromStock();
                System.out.println(title + Constants.BOOK_REMOVED_MSG);
                return;
            }
        }
        System.out.println(Constants.BOOK_NOT_FOUND);
    }
    
    private static void addOrder() {
        System.out.println(Constants.ORDER_PRICE_PROMPT);
        int price = sc.nextInt();
        Order order = new Order(new GregorianCalendar(), price, Constants.ORDER_STATUS_2);
    }
}
