package api.di;

import utility.Constants;

public interface IInjectStrategy {
    Object getInjectObject(Constants.Type type);
}
