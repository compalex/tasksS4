package dao.ser;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import api.dao.IModelDAO;
import api.model.IModel;

public class ModelDAO implements IModelDAO {
    protected String pathName;
    
    public ModelDAO(String pathName) {
        this.pathName = pathName;
    }
    
    @Override
    public boolean addRecord(IModel model) throws Exception {
        FileOutputStream file = new FileOutputStream(pathName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(model);
        out.close();
        file.close();
        return true;
    }
    
    public boolean addRecords(List<? extends IModel> models) throws Exception {
        FileOutputStream file = new FileOutputStream(pathName, false);
        ObjectOutputStream out = new ObjectOutputStream(file);
        out.writeObject(models);
        out.close();
        file.close();
        return true;
    }

    @Override
    public boolean deleteRecord(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateRecord(IModel model, int id) {
        // TODO Auto-generated method stub
        return false;
    }
}
