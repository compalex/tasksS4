package model;

import api.annotations.Columns;
import api.model.IRequest;

public class Request implements IRequest {
    @Columns(name = "quantity")
    private Integer quantity;
    @Columns(name = "title")
    private String title;
    
    public Request() {
        
    }
    
    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public String getTitle() {
        return title;
    }
}
