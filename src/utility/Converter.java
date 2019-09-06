package utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import api.annotations.Columns;
import api.model.IModel;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Converter {

    public static <T> List<T> getListFromResultSet(Class<T> classType, ResultSet resultSet)
            throws Exception {
        Field[] fields = classType.getDeclaredFields();
        List<T> list = new ArrayList<>();
        int rowsCount = getRowsCount(resultSet);

        for (int i = 0; i < rowsCount; i++) {
            list.add(classType.getConstructor().newInstance());
        }

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            String name = fields[i].getAnnotation(Columns.class).name();

            for (int j = 0; j < rowsCount; j++) {
                resultSet.absolute(j + 1);
                String value = resultSet.getString(name);
                if (fields[i].getType() == Date.class) {
                    fields[i].set(list.get(j), new SimpleDateFormat("yyyy-MM-dd").parse(value));
                } else {
                    fields[i].set(list.get(j), fields[i].getType().getConstructor(String.class).newInstance(value));
                }
            }
        }

        /*
         * for (Field field : fields) { 
         *  field.setAccessible(true); 
         * }
         * 
         * while (resultSet.next()) { 
         * T dto = (T) classType.getConstructor().newInstance();
         * 
         *  for (Field field : fields) { 
         *  String name = field.getAnnotation(Columns.class).name(); 
         *  String value = resultSet.getString(name); 
         *  if(field.getType() == Date.class) { 
         *   field.set(dto, new SimpleDateFormat("yyyy-MM-dd").parse(value)); 
         *  } else { field.set(dto, field.getType().getConstructor(String.class).newInstance(value)); 
         *  }
         * }
         * list.add(dto); }
         */
        return list;
    }

    private static int getRowsCount(ResultSet resultSet) {
        int size = 0;
        try {
            resultSet.last();
            size = resultSet.getRow();
            resultSet.first();
            return size;
        } catch (SQLException e) {
            return 0;
        }
    }
}
