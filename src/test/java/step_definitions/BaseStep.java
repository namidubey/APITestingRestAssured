package step_definitions;

import api.APIPost;
import utilities.ConfigFileReader;

public class BaseStep {
	private APIPost endpoints;
	private String baseUrl;

	public APIPost getEndpoints() {
		return endpoints;
	}

	public static String getBaseUrl() {
		return ConfigFileReader.getInstance().getBaseUrl();
	}
}
