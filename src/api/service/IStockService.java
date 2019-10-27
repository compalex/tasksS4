package api.service;

import java.util.List;
import api.model.IBook;
import api.model.IBookInStock;

public interface IStockService {
    List<IBookInStock> getStock() throws Exception;
    boolean addBookToStock(IBook book) throws Exception;
}
