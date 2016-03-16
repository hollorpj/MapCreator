package preferences;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import dao.DAO;

public class Property {
	private Properties properties;
	
	public Property() throws IOException {
		this.properties = new Properties();
		properties.load(new FileInputStream(DAO.getUserPreferences().getResourceFolder() + "/config.properties"));
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
