package tasksS4_01;

import java.util.GregorianCalendar;

public class Book {
    private String title;
    private GregorianCalendar publicationDate;
    private int price;
    private int stockAvailability;
    // storeDate is a date of the latest order for this book as well
    private GregorianCalendar storeDate;
    private String description;

    public Book(String title, GregorianCalendar publicationDate, int price, int stockAvailability, 
            GregorianCalendar storeDate, String description) {
        this.title = title;
        this.publicationDate = publicationDate;
        this.price = price;
        this.stockAvailability = stockAvailability;
        this.storeDate = storeDate;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public GregorianCalendar getPublicationDate() {
        return publicationDate;
    }

    public int getPrice() {
        return price;
    }

    public boolean getStockAvailability() {
        if (stockAvailability > 0) {
            return true;
        } else {
            return false;
        }
    }

    // for "stale" info
    public GregorianCalendar getStoreDate() {
        return storeDate;
    }
    
    // this method is exceptionally for MyBookSorter
    public long getDateInMillisec() {
        return publicationDate.getTimeInMillis();
    }

    public long getStoreDateInMillisec() {
        return storeDate.getTimeInMillis();
    }

    public String getDescription() {
        return description;
    }
    
    public void addToStock() {
        stockAvailability++;
    }
    
    public void removeFromStock() {
        if(stockAvailability > 0) {
            stockAvailability--;
        }
    }
}
