package api.model;

import java.util.Date;

public interface IBook extends IModel {
    int getId();
    String getTitle();
    Date getPublicationDate();
    double getPrice();
    String getDescription();
}
