package utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import api.annotations.Columns;
import api.model.IModel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Converter {
    
    public static List<IModel> getListFromResultSet(Class<?> classType, ResultSet resultSet) {
        List<IModel> list = new ArrayList<IModel>();
        Field[] fields = classType.getDeclaredFields();
        
        try {
            for (Field field : fields) {
                field.setAccessible(true);
            }
            
            while (resultSet.next()) {
                IModel dto = (IModel) classType.getConstructor().newInstance();
                
                for (Field field : fields) {
                    Columns column = field.getAnnotation(Columns.class);
                    String name = null;
                    if(column !=null) {
                        name = column.name();
                    } else {
                        name = field.getName();
                    }
                    String value = resultSet.getString(name);
                    if(field.getType() == Date.class) {
                        field.set(dto, new SimpleDateFormat("yyyy-MM-dd").parse(value));
                    } else {
                        field.set(dto, field.getType().getConstructor(String.class).newInstance(value));
                    }
                }
                list.add(dto);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException ex) {
            ex.printStackTrace();
            return list;
        } catch (ParseException exx) {
            exx.printStackTrace();
            return list;
        }   
    }
}
