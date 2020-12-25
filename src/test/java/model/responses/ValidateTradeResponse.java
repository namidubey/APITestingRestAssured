package model.responses;

import java.util.List;

public class ValidateTradeResponse {
	public String status;
	public List<String> messages = null;

	public String getStatus() {
		return status;
	}

	public List<String> getMessages() {
		return messages;
	}
}
