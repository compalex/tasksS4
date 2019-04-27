package tasksS4_01;

import java.util.Comparator;

public class MyOrderSorter implements Comparator<Order>{
    private int sortNum;

    MyOrderSorter(int sortNum) {
        this.sortNum = sortNum;
    }
    
    @Override
    public int compare(Order a, Order b) {
         if(sortNum == 1) {
             if(a.getDateInMillisec() < b.getDateInMillisec()) return 1;
             else if(a.getDateInMillisec() == b.getDateInMillisec()) return 0;
             else return -1;
         } else if(sortNum == 2) {
             return b.getPrice() - a.getPrice();
         } else if(sortNum == 3) {
             if(a.getStatus() == Constants.ORDER_STATUS_1) {
                 if(b.getStatus() != Constants.ORDER_STATUS_1) return -1;
                 else return 0;
             } else if(b.getStatus() == Constants.ORDER_STATUS_1) {
                 if(a.getStatus() != Constants.ORDER_STATUS_1) return 1;
                 else return 0;
             } else if(a.getStatus() == Constants.ORDER_STATUS_2) {
                 if(b.getStatus() != Constants.ORDER_STATUS_2) return -1;
                 else return 0;
             } else if(b.getStatus() == Constants.ORDER_STATUS_2) {
                 if(a.getStatus() != Constants.ORDER_STATUS_2) return 1;
                 else return 0;
             } else return 0;
         } else return 0;
    }
}

