package utility;

import java.io.FileInputStream;
import java.util.Properties;
import utility.Constants.Database;

public class ConfigHandler {
    private Configs configs;
    
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
    
    public Configs getConfigs() throws Exception {
        if(configs == null) {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            return new Configs(Database.valueOf(props.getProperty(Constants.PROPERTY_DATABASE)),
                    Integer.parseInt(props.getProperty(Constants.PROPERTY_UNSOLD_MONTH)),
                    Boolean.parseBoolean(props.getProperty(Constants.PROPERTY_AUTOFILL)));
        } else {
            return configs;
        }
    }
}
