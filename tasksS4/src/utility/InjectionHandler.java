package utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import api.annotations.Inject;
import dao.DAOFactory;
import facade.LibraryFacade;
import service.BookService;
import service.OrderService;
import service.RequestService;
import service.StockService;
import utility.Constants;
import org.reflections.util.ClasspathHelper;

public class InjectionHandler {  
    //TODO  1)parameter facade to avoid loop (can't take facade.getInstance() 'cuz it's not ready yet)
    //      2)The couldn't be interfaces because of static getInstance()
    public static void doInjection(LibraryFacade facade) throws Exception {
        Set<Field> fields = getAnnotatedFields();

        for(Field field : fields) {
            field.setAccessible(true);
            
            switch(field.getAnnotation(Inject.class).layer()) {
                case DAO:
                    injectDAO(field);
                    break;
                case SERVICE:
                    injectDynamically(field, facade);
                    break;
                default:
                    break;
            }
        }
    }

    private static void injectDAO(Field field) throws Exception {
        System.out.println(field.getDeclaringClass());
        Object declaringObj = field.getDeclaringClass().getMethod(Constants.GET_INSTANCE_METHOD).invoke(null);
        switch(field.getAnnotation(Inject.class).type()) {
            case BOOK_DAO:
                field.set(declaringObj, DAOFactory.getBookDAO());
                break;
            case ORDER_DAO:
                field.set(declaringObj,  DAOFactory.getOrderDAO());
                break;
            case REQUEST_DAO:
                field.set(declaringObj, DAOFactory.getRequestDAO());
                break;
            case STOCK_DAO:
                field.set(declaringObj,  DAOFactory.getStockDAO());
                break;
            default:
                break;
        }
    }

    private static void injectDynamically(Field field, LibraryFacade facade) throws Exception {
        Method method = field.getType().getMethod(Constants.GET_INSTANCE_METHOD);  
        field.set(facade, method.invoke(null));
    }
    
    private static Set<Field> getAnnotatedFields() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setScanners(new FieldAnnotationsScanner());
        configurationBuilder.setUrls(ClasspathHelper.forPackage(Constants.PACKAGE_NAME));
        Reflections reflections = new Reflections(configurationBuilder);
        return reflections.getFieldsAnnotatedWith(Inject.class);
    }
}
