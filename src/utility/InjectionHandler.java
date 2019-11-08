package utility;

import java.lang.reflect.Field;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import api.annotations.Inject;
import dao.DAOFactory;
import service.ServiceFactory;
import utility.Constants;
import org.reflections.util.ClasspathHelper;

public class InjectionHandler {  
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    public static void doInjection() throws Exception {
        Set<Field> fields = getAnnotatedFields();

        for(Field field : fields) {
            field.setAccessible(true);
            Object toInject = null;
            
            switch(field.getAnnotation(Inject.class).layer()) {
                case DAO:
                    toInject = getInjectDAO(field);
                    break;
                case SERVICE:
                    toInject = getInjectService(field);
                    break;
                default:
                    break;
            }
            Object declaringObj = field.getDeclaringClass().getMethod(Constants.GET_INSTANCE_METHOD).invoke(null);
            field.set(declaringObj, toInject);
        }
    }

    private static Object getInjectDAO(Field field) {
        try {
            switch(field.getAnnotation(Inject.class).type()) {
                case BOOK:
                    return DAOFactory.getBookDAO();
                case ORDER:
                    return DAOFactory.getOrderDAO();
                case REQUEST:
                    return DAOFactory.getRequestDAO();
                case STOCK:
                    return DAOFactory.getStockDAO();
                default:
                    return null;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return null;
    }

    private static Object getInjectService(Field field) throws Exception {
        switch(field.getAnnotation(Inject.class).type()) {
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
    
    private static Set<Field> getAnnotatedFields() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setScanners(new FieldAnnotationsScanner());
        configurationBuilder.setUrls(ClasspathHelper.forPackage(Constants.PACKAGE_NAME));
        Reflections reflections = new Reflections(configurationBuilder);
        return reflections.getFieldsAnnotatedWith(Inject.class);
    }
}
