package api.dao;

import api.model.IModel;

public interface IModelDAO {
    boolean addRecord(IModel model) throws Exception;
    boolean deleteRecord(int id) throws Exception;
    boolean updateRecord(IModel model, int id);
}
