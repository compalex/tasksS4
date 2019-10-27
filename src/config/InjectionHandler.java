package config;

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
            IRequestService requestService, IStockService stockService) throws Exception {
        Set<Field> fields = getAnnotatedFields();
        
        for(Field field : fields) {
            field.setAccessible(true);
            
            switch(field.getAnnotation(Inject.class).daoType()) {
                case "bookDAO":
                    field.set(bookService, DAOFactory.getBookDAO());
                    break;
                case "orderDAO":
                    field.set(orderService,  DAOFactory.getOrderDAO());
                    break;
                case "requestDAO":
                    field.set(requestService, DAOFactory.getRequestDAO());
                    break;
                case "stockDAO":
                    field.set(stockService,  DAOFactory.getStockDAO());
                    break;
                default:
                    return;
            }
        }
    }
}
