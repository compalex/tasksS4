package model;

import java.util.Date;

import api.Columns;
import api.model.IBook;

public class Book implements IBook {
    @Columns(name = "book_id")
    private Integer id;
    private String title;
    @Columns(name = "publication_date")
    private Date date;
    private Double price;
    @Columns(name = "stock_availability")
    private Integer stock;
    
    public Book() {
        
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Date getPublicationDate() {
        return date;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public int getStockAvailability() {
        return stock;
    }
}