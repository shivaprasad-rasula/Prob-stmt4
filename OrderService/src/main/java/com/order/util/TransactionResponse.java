package com.order.util;

import com.order.entity.Order;

public class TransactionResponse {

	
	private Order order;
	private double amount;
	private String transactionId;
	private String message;

	

	public TransactionResponse(Order order, double amount, String transactionId, String message) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
