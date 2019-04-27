package tasksS4_01;

public class BookRequest {
    private int requestNum;
    private Book book;
    
    public BookRequest(Book book, int requestNum) {
        this.requestNum = requestNum;
        this.book = book;
    }
    
    public int getRequestNum() {
        return requestNum;
    }
    
    public String getTitle() {
        return book.getTitle();
    }
}
