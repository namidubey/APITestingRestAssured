package step_definitions;

import api.APIPost;
import com.sun.javafx.tools.packager.Log;
import logs.Logs;
import utilities.ConfigFileReader;

public class BaseStep {
	private APIPost endpoints;
	private String baseUrl;

	public APIPost getEndpoints() {
		return endpoints;
	}

	public static String getBaseUrl() {
		Logs.getInstance().infoLog("Base URL is getting created");
		return ConfigFileReader.getInstance().getHost()+":"+ConfigFileReader.getInstance().getPort();
	}
}
