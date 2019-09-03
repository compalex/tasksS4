package model;

import api.model.IRequest;

public class Request implements IRequest {
    private Integer quantity;
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
