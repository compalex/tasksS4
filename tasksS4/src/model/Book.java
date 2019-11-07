package model;

import java.util.Date;
import api.annotations.Columns;
import api.model.IBook;

public class Book implements IBook {
    @Columns(name = "book_id")
    private Integer id;
    @Columns(name = "title")
    private String title;
    @Columns(name = "publication_date")
    private Date date;
    @Columns(name = "price")
    private Double price;
    @Columns(name = "description")
    private String description;
    
    public Book() {  
      //used by dao
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
    public String getDescription() {
        return description;
    }
}
