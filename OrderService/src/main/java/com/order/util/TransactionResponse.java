package com.order.util;

public class TransactionResponse {

	private String message;

	@Override
	public String toString() {
		return "TransactionResponse [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
