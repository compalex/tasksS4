package tasksS4_01;

import java.util.Comparator;

public class MyBookSorter implements Comparator<Book>{    
    private int sortNum;

    MyBookSorter(int sortNum) {
        this.sortNum = sortNum;
    }
    
    @Override
    public int compare(Book a, Book b) {
         if(sortNum == 1) {
             if(a.getTitle().compareToIgnoreCase(b.getTitle()) > 0) return 1;
             else if(a.getTitle() == b.getTitle()) return 0;
             else return -1;          
         } else if(sortNum == 2) {
             if(a.getDateInMillisec() < b.getDateInMillisec()) return 1;
             else if(a.getDateInMillisec() == b.getDateInMillisec()) return 0;
             else return -1;
         } else if(sortNum == 3) {
             return a.getPrice() - b.getPrice();
         } else if(sortNum == 4) {
             if(a.getStockAvailability() == true && b.getStockAvailability() == false) return -1;
             else if(a.getStockAvailability() == b.getStockAvailability()) return 0;
             else return 1;
         } 
         //for "stale"
         else if(sortNum == 10) {
             if(a.getStoreDateInMillisec() < b.getStoreDateInMillisec()) return 1;
             else if(a.getStoreDateInMillisec() == b.getStoreDateInMillisec()) return 0;
             else return -1;
         } else if(sortNum == 20) {
             return a.getPrice() - b.getPrice();
         } else return 0;
    }
}
