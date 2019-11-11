package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import api.annotations.Columns;
import api.model.IBookInStock;
import di.InjectionHandler;

public class Converter {
    private static Logger logger = LogManager.getLogger(InjectionHandler.class);
    
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
    
    public static <T> List<T> getListFromListOfList(Class classType, List<List<String>> values) 
            throws Exception {
        Field[] fields = classType.getDeclaredFields();
        List<T> models = new ArrayList<>();
        
        Constructor<T> constructor = classType.getConstructor();
        
        for(List<String> line : values) {
            T dto = constructor.newInstance();
            dto = setDTOcsv(dto, fields, line);
            models.add(dto);
        }
        return models;
    }
    
    public static <T> List<T> getListFromObjStream(Class classType, ObjectInputStream input) {
        List<T> models = new ArrayList<>();
        try {
            models = (List<T>)input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            logger.error(e);
        }  
        return models;
    }
    
    private static <T> T setDTOcsv(T dto, Field[] fields, List<String> line) 
            throws Exception {
        int i = 0;
        
        for(Field field : fields) {
            field.setAccessible(true);
            Class<?> clazz = field.getType();            
            String value = line.get(i);   
            if(clazz == Date.class) { 
                field.set(dto, new SimpleDateFormat("dd/MM/yyyy").parse(value));
            } else { 
                field.set(dto, field.getType().getConstructor(String.class).newInstance(value)); 
            }
            i++;
        }
        return dto;
    }

    private static <T> T setDTO(T dto, Map<String, Field> map, ResultSet resultSet) throws Exception {
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
    
    public static List<List<String>> getRecordsCVS(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<List<String>> records = new ArrayList<List<String>>(); 
        String line;
        br.readLine();
        
        while((line = br.readLine()) != null) {
            String[] values = line.split(",");
            records.add(Arrays.asList(values));
        }
        br.close();
        return records;
    }

    public static List<IBookInStock> getStaleBooks(List<IBookInStock> booksInStock, int months) {
        //convert months to milliseconds
        long diff = months * 30 * 24 * 60 * 60 * 1000l;
        List<IBookInStock> staleBooks = new ArrayList<>();
        
        for(IBookInStock book : booksInStock) {
            if((new Date().getTime() - book.getDate().getTime()) >  diff) {
                staleBooks.add(book);
            }
        }
        return staleBooks;
    } 
}
