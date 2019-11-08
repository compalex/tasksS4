package utility;

import java.io.FileInputStream;
import java.util.Properties;
import utility.Constants.Database;

public class ConfigHandler {
    private static ConfigHandler instance;
    private Configs configs;
    
    public static ConfigHandler getInstance() {
        if(instance != null) {
            return instance;
        } else {
            instance = new ConfigHandler();
            return instance;
        }
    }
    
    public Configs getConfigs() throws Exception {
        if(configs == null) {
            initConfigs();
        }
        return configs;
    }
    
    private void initConfigs() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(Constants.PATH_CONFIG_PROPERTIES));
        configs = new Configs(Database.valueOf(props.getProperty(Constants.PROPERTY_DATABASE)),
                Integer.parseInt(props.getProperty(Constants.PROPERTY_UNSOLD_MONTH)),
                Boolean.parseBoolean(props.getProperty(Constants.PROPERTY_AUTOFILL)));
    }
    
    public class Configs {
        public Database database;
        public int unsoldMonth;
        public boolean autoRequest;
        
        public Configs(Database database, int unsoldMonth, boolean autoRequest) {
            this.database = database;
            this.unsoldMonth = unsoldMonth;
            this.autoRequest = autoRequest;
        }
    }
}
