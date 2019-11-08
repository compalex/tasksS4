package service;

import api.service.IBookService;
import api.service.IOrderService;
import api.service.IRequestService;
import api.service.IStockService;

public class ServiceFactory {
    public static IBookService getBookService() {
        return BookService.getInstance();
    }
    
    public static IOrderService getOrderService() {
        return OrderService.getInstance();
    }
    
    public static IRequestService getRequestService() {
        return RequestService.getInstance();
    }
    
    public static IStockService getStockService() {
        return StockService.getInstance();
    }
}
