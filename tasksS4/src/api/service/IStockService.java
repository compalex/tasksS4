package api.service;

import java.util.List;
import api.model.IBookInStock;

public interface IStockService {
    List<IBookInStock> getStock() throws Exception;
}
