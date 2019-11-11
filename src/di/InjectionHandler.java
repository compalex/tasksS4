package di;

import java.lang.reflect.Field;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.util.ConfigurationBuilder;
import api.annotations.Inject;
import api.di.IInjectStrategy;
import utility.Constants;
import org.reflections.util.ClasspathHelper;

public class InjectionHandler {   
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
    public static void doInjection() {
        Set<Field> fields = getAnnotatedFields();

        for(Field field : fields) {
            field.setAccessible(true);
            IInjectStrategy injStrategy = null;
            
            switch(field.getAnnotation(Inject.class).layer()) {
                case DAO:
                    injStrategy = new StrategyInjectDAO();
                    break;
                case SERVICE:
                    injStrategy = new StrategyInjectService(); 
                    break;
                default:
                    break;
            }
            try {
                Object objToInject = injStrategy.getInjectObject(field.getAnnotation(Inject.class).type());
                Object declaringObj = field.getDeclaringClass().getMethod(Constants.GET_INSTANCE_METHOD).invoke(null);
                field.set(declaringObj, objToInject);
            } catch(Exception e) {
               logger.error(e);
            }
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
