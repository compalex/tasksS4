package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import api.annotations.Columns;

public class Converter {

    public static <T> List<T> getListFromResultSet(Class classType, ResultSet resultSet)
            throws Exception {
        Field[] fields = classType.getDeclaredFields();
        List<T> models = new ArrayList<>();
        Map<String, Field> map = new HashMap<>(); 
        
        for(Field field : fields) {
            field.setAccessible(true);
            String name = field.getAnnotation(Columns.class).name();
            map.put(name, field);
        }
        Constructor<T> constructor = classType.getConstructor();
        
        while(resultSet.next()) {
            T dto = constructor.newInstance();
            dto = setDTO(dto, map, resultSet);
            models.add(dto);
        }
        return models;
    }
    
    private static <T> T setDTO(T dto, Map<String, Field> map, ResultSet resultSet) throws Exception{
        for(String key : map.keySet()) {
            Field field = map.get(key);
            Class<?> clazz = field.getType();

            String value = resultSet.getString(key); 
            
            if(clazz == Date.class) { 
                field.set(dto, new SimpleDateFormat("yyyy-MM-dd").parse(value));
            } else { 
                field.set(dto, field.getType().getConstructor(String.class).newInstance(value)); 
            }
        }
        return dto;
    }
}
