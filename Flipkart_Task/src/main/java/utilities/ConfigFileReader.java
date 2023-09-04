package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "config//config.properties";

	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties file is not found at "
					+ "given path " + propertyFilePath);
		}		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) 
			return url;
		else 
			throw new RuntimeException("Application Url not specified in the "
					+ "Config.properties file for the Key:url");
	}
	
	public String getBrowserName() {
		String browserName = properties.getProperty("browser");
		if(browserName!=null)
			return browserName;
		throw new RuntimeException("Browser name is not specified in the "
				+ "Config.properties file for the Key:browser");
	}

}
