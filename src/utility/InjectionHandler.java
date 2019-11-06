package utility;

import java.lang.reflect.Field;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import api.annotations.Inject;
import api.service.IBookService;
import api.service.IOrderService;
import api.service.IRequestService;
import api.service.IStockService;
import dao.DAOFactory;
import utility.Constants.Database;
import org.reflections.util.ClasspathHelper;

public class InjectionHandler {  
    
    public static Set<Field> getAnnotatedFields() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setScanners(new FieldAnnotationsScanner());
        configurationBuilder.setUrls(ClasspathHelper.forPackage("service"));
        Reflections reflections = new Reflections(configurationBuilder);
        return reflections.getFieldsAnnotatedWith(Inject.class);
    }
    
    public static void doInjection(IBookService bookService, IOrderService orderService, 
            IRequestService requestService, IStockService stockService, Database database) throws Exception {
        Set<Field> fields = getAnnotatedFields();
        
        for(Field field : fields) {
            field.setAccessible(true);
            
            switch(field.getAnnotation(Inject.class).daoType()) {
                case BOOK_DAO:
                    field.set(bookService, DAOFactory.getBookDAO(database));
                    break;
                case ORDER_DAO:
                    field.set(orderService,  DAOFactory.getOrderDAO(database));
                    break;
                case REQUEST_DAO:
                    field.set(requestService, DAOFactory.getRequestDAO(database));
                    break;
                case STOCK_DAO:
                    field.set(stockService,  DAOFactory.getStockDAO(database));
                    break;
                default:
                    return;
            }
        }
    }
}
