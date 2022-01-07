package com.qa.data;

public class Users3 {
	String clientName;
	String clientEmail;
    String error;
    String accessToken;
	Users3(){}

	public Users3(String clientName, String clientEmail) {
		super();
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getError() {
		return error;
	}
	public String getaccessToken() {
		return accessToken;
	}
	
}
