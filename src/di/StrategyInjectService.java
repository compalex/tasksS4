package di;

import api.di.IInjectStrategy;
import service.ServiceFactory;
import utility.Constants;

public class StrategyInjectService implements IInjectStrategy {
    public Object getInjectObject(Constants.Type type) {
        switch(type) {
            case BOOK:
                return ServiceFactory.getBookService();
            case ORDER:
                return ServiceFactory.getOrderService();
            case REQUEST:
                return ServiceFactory.getRequestService();
            case STOCK:
                return ServiceFactory.getStockService();
            default:
                return null;
        }
    }
}
