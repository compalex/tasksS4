package utility;

public class SQLs {

    public static String getAllBooksSQL(Constants.BookSort sort) {
        String firstPart = "SELECT books.book_id, books.title, books.publication_date, "
                + "books.price, COUNT(stock.book_id) AS stock_availability " + "FROM books " + "LEFT JOIN stock "
                + "ON books.book_id = stock.book_id " + "GROUP BY books.book_id ";

        switch (sort) {
            case BY_TITLE:
                return firstPart + "ORDER BY title;";
            case BY_PUBLICATION_DATE:
                return firstPart + "ORDER BY publication_date;";
            case BY_PRICE:
                return firstPart + "ORDER BY price;";
            case BY_STOCK_AVAILABILITY:
                return firstPart + "ORDER BY stock_availability;";
            default:
                return "Something goes wrong...";
        }
    }

    public static String getAllOrdersSQL(Constants.OrderSort sort) {
        String firstPart = "SELECT * FROM orders ";

        switch (sort) {
            case BY_DATE:
                return firstPart + "ORDER BY `date`;";
            case BY_PRICE:
                return firstPart + "ORDER BY price;";
            case BY_STATUS:
                return firstPart + "ORDER BY status;";
            default:
                return "smth wrong";
        }
    }

    public static String getAllRequestsSQL(Constants.RequestSort sort) {
        String firstPart = "SELECT COUNT(requests.book_id) AS quantity, books.title " + "FROM requests " + "JOIN books "
                + "ON requests.book_id = books.book_id " + "GROUP BY requests.book_id ";

        switch (sort) {
            case BY_QUANTITY:
                return firstPart + "ORDER BY quantity;";
            case BY_ALPHABET:
                return firstPart + "ORDER BY title;";
            default:
                return "smth doesnt' work";
        }
    }
}
