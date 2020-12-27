package utilities.apiUtils;

import io.restassured.response.Response;

public interface IRestResponse<T> {
	public T getBody();

	public String getContent();

	public int getStatusCode();

	public boolean isSuccessful();

	public boolean isFailure();

	public String getStatusDescription();

	public Response getResponse();

	public Exception getException();
}
