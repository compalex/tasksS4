package dao.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import api.dao.IModelDAO;
import api.model.IModel;

public class ModelDAO implements IModelDAO {
    protected String pathName;
    
    public ModelDAO(String pathName) throws Exception {
        this.pathName = pathName;
    }
    
    public boolean addRecord(IModel model) throws Exception {
        File file = new File(pathName);
        FileWriter csvWriter = new FileWriter(file, true);

        Class<?> clazz = model.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        String[] values = new String[fields.length];
        int i = 0;
        
        for(Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(model);

            if(value instanceof Date) {
                values[i] = new SimpleDateFormat("dd/MM/yyyy").format(value);
            } else {
                values[i] = "" +  value;
            }
            i++;
        }
        csvWriter.append(String.join(",", values));
        csvWriter.append("\n");
        csvWriter.flush();
        csvWriter.close();
        return true;
    }

    @Override
    public boolean deleteRecord(int id) throws Exception {
        File file = new File(pathName);
        File tempFile = new File("temp.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        
        while((currentLine = reader.readLine()) != null) {
            if(currentLine.substring(0, currentLine.indexOf(",")).equals(Integer.toString(id))) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        file.delete();
        boolean successful = tempFile.renameTo(file);
        return successful;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        // TODO Auto-generated method stub
        return false;
    }
}
