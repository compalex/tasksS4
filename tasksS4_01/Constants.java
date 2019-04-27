package tasksS4_01;

public class Constants {
    public static final String[] MAIN_MENU = { 
            "What do you wanna see, dude?", 
            "1.\tList of books",
            "2.\tList of orders", 
            "3.\tList of book requests", 
            "4.\tList of completed orders for a period of time",
            "5.\tAmount of money earned over a period of time", 
            "6.\tNumber of completed orders for a period of time",
            "7.\tList of \"stale\" books being unsold for over 6 months", 
            "8.\tDetails of the order",
            "9.\tDescription of the book" 
    };
    public static final String[] MENU_1 = { 
            "How do you wanna sort the list of books, dude?",
            "1.\tSort the list alphabetically", 
            "2.\tSort by date of publication", 
            "3.\tSort by price",
            "4\tSort by stock availability" 
    };
    public static final String[] MENU_2 = { 
            "How do you wanna sort the list of orders, dude?", 
            "1.\tSort by order date",
            "2.\tSort by price of the order", 
            "3.\tSort by the status of the order" 
    };
    public static final String[] MENU_3 = { 
            "How do you wanna sort the list of book requests, dude?",
            "1.\tSort by number of requests", 
            "2.\tSort the list alphabetically", 
    };
    public static final String[] MENU_4 = { 
            "How do you wanna sort the list, dude?", 
            "1.\tSort by date",
            "2.\tSort by price", 
    };
    public static final String[] MENU_7 = { 
            "How do you wanna sort the list, dude?",
            "1.\tSort by date of getting stored", 
            "2.\tSort by price", 
    };
    public static final String[] REPEAT_PROMPT = { 
            "Wanna try program again or just stop it?",
            "1.\tYeah, why not. I'm gonna repeat", 
            "2.\tNah, Imma be done for now. Take it easy" 
    };
    public static final String INPUT_ERROR_2 = "Come on! It's gonna be the integer number between 1 and ";
    public static final String INPUT_ERROR = "Error! Wrong input!";
    public static final String DATE_FORMAT = "yyyy/MM/dd";
    public static final String ASK_DATE_1 = "Starting from which date? Input in format ";
    public static final String ASK_DATE_2 = "Ending with what date? Input in format ";
    public static final String LINE = "_________________________________________";
    public static final String GOODBYE_MSG = "All right then, see you next time, dude";
    public static final String NUM_REQUESTS = "The number of requests for this book is ";
    public static final String EARNED_MONEY = "Money each were earned for completed orders -> ";
    public static final String ORDERS_NUM = "The number of complete orders for adjusted period of time is ";
    public static final String BOOK_TITLE_1 = "Think Java";
    public static final String BOOK_TITLE_2 = "Think as God by Alex Compalex";
    public static final String BOOK_TITLE_3 = "Java. A beginner's guide";
    public static final String BOOK_TITLE_4 = "Dictionary";
    public static final String BOOK_TITLE_5 = "Easy Way To Stop Smoking";
    public static final String BOOK_TITLE_6 = "How To Play Dota";
    public static final String ORDER_STATUS_1 = "COMPLETED";
    public static final String ORDER_STATUS_2 = "PROCESSING";
    public static final String ORDER_STATUS_3 = "CANCELED";
    public static final String BOOK_DESCRIPTION_1 = "This book is about different things such as bla-bla-bla";
    public static final String BOOK_DESCRIPTION_2 = "This is the best book ever";
    public static final String BOOK_DESCRIPTION_3 = "This book is about bla-bla-bla";
    public static final String BOOK_DESCRIPTION_4 = "This book is about different things";
    public static final String BOOK_DESCRIPTION_5 = "bla-bla-bla";
    public static final String BOOK_DESCRIPTION_6 = "This is a book";
    public static final String BOOK_TITLE_PROMPT = "Input the title of the book you want to add:";
    public static final String BOOK_ADDED_MSG = " has been added to the stock.";
    public static final String BOOK_REMOVED_MSG = " has been removed from the stock.";
    public static final String BOOK_NOT_FOUND = "Book with such title ain't found";;
    public static final String ORDER_PRICE_PROMPT = "Input the price of this order";
    public static final int ONE = 1, TWO = 2;
    public static final long MONTH_6 = 15778800000L;
}
