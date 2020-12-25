package listeners;

import apiUtils.Endpoints;
import dataProvider.ConfigFileReader;

public class TestContext {

	private String baseUrl = ConfigFileReader.getInstance().getBaseUrl();
	private Endpoints endpoints;

	public TestContext() {
		endpoints = new Endpoints(baseUrl);
	}

	public Endpoints getEndpoints() {
		return endpoints;
	}

}
