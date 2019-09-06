package utility;

public class Constants {
    public enum BookSort {
        BY_TITLE,
        BY_PUBLICATION_DATE,
        BY_PRICE,
        BY_STOCK_AVAILABILITY
    }
    
    public enum OrderSort {
        BY_DATE,
        BY_PRICE,
        BY_STATUS
    }
    
    public enum RequestSort {
        BY_QUANTITY,
        BY_ALPHABET
    }
    
    public enum TypeDAO {
        BOOK,
        ORDER,
        REQUEST
    }
}
