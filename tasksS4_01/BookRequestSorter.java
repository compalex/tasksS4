package tasksS4_01;

import java.util.Comparator;

public class BookRequestSorter implements Comparator<BookRequest>{
    private int sortNum;

    BookRequestSorter(int sortNum) {
        this.sortNum = sortNum;
    }
    
    @Override
    public int compare(BookRequest a, BookRequest b) {
         if(sortNum == 1) {
             return a.getRequestNum() - b.getRequestNum();
         } else if(sortNum == 2) {
             if(a.getTitle().compareToIgnoreCase(b.getTitle()) > 0) return 1;
             else if(a.getTitle() == b.getTitle()) return 0;
             else return -1;          
         } else return 9;
    }
}
