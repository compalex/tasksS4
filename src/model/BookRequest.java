package model;

import api.annotations.Columns;
import api.model.IBookRequest;

public class BookRequest implements IBookRequest {
    @Columns(name = "request_id")
    private Integer requestId;
    @Columns(name = "book_id")
    private Integer bookId;
    
    public BookRequest() {
      //used by dao
    }
    
    @Override
    public int getRequestId() {
        return requestId;
    }
    
    @Override
    public int getBookId() {
        return bookId;
    }
}
