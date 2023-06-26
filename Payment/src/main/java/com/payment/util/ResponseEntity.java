package com.payment.util;

import java.util.List;

import com.payment.entity.Payment;

public class ResponseEntity {

	private List<Payment> paymentList;
	
	private String status;

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
