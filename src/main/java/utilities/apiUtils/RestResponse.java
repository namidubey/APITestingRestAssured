package utilities.apiUtils;

import io.restassured.response.Response;

public class RestResponse<T> implements IRestResponse<T> {

	private T data;
	private Response response;
	private Exception e;

	public RestResponse(Class<T> t, Response response) {
		this.response = response;
		try{
			this.data = t.newInstance();
		}catch (Exception e){
			throw new RuntimeException("There should be a default constructor in the Response POJO");
		}
	}

	public String getContent() {
		return response.getBody().asString();
	}

	public int getStatusCode() {
		return response.getStatusCode();
	}

	public boolean isSuccessful() {
		int code = response.getStatusCode();
		if( code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
		return false;
	}

	public String getStatusDescription() {
		return response.getStatusLine();
	}

	public Response getResponse() {
		return response;
	}

	public T getBody() {
		try {
			data = (T) response.getBody().as(data.getClass());
		}catch (Exception e) {
			this.e=e;
		}
		return data;
	}

	public boolean isFailure() {
		int code = response.getStatusCode();
		if( code == 400 || code == 401 || code == 403 || code == 404 || code == 405 || code == 409 || code == 500 || code == 503) return true;
		return false;
	}

	public Exception getException() {
		return e;
	}
}
