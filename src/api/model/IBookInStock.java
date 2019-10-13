package api.model;

import java.util.Date;

public interface IBookInStock extends IModel {
    int getId();
    int getBookId();
    Date getDate();
}
