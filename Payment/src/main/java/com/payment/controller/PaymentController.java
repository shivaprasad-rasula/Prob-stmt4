package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.Payment;
import com.payment.service.PaymentService;
import com.payment.util.ResponseEntity;

@CrossOrigin
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	ResponseEntity responseEntity;
	
	@GetMapping("/getPayments")
	public ResponseEntity  getAllPayments() {
		List<Payment> paymentList = paymentService.getAllPayments();
		responseEntity = new ResponseEntity();
		responseEntity.setPaymentList(paymentList);
		return responseEntity;
	}
	 
	
	@PostMapping("/doPayment")
	public Payment  doPayments(@RequestBody Payment payment) {
		return paymentService.savePayments(payment);
	}
}
