package stepDefinitions;

import apiUtils.Endpoints;
import listeners.TestContext;

public class BaseStep {
	private Endpoints endpoints;

	public BaseStep(TestContext testContext) {
		endpoints = testContext.getEndpoints();
	}

	public Endpoints getEndpoints() {
		return endpoints;
	}
}
