package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private static ConfigFileReader configReader;

	private ConfigFileReader() {
		BufferedReader reader;
		String propertyFilePath = "/Users/namitadubey/Downloads/workspace/APITestingRestAssured/src/test/resources/configs/configuration.properties";
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
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static ConfigFileReader getInstance( ) {
		if(configReader == null) {
			configReader = new ConfigFileReader();
		}
		return configReader;
	}

	public String getBaseUrl() {
		String baseUrl = properties.getProperty("base_url");
		if(baseUrl != null) return baseUrl;
		else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
	}
}
