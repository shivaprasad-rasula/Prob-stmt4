package com.payment.service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.entity.Payment;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAllPayments() {
		System.out.println("getAllPayments");
		return paymentRepository.findAll();
	}
	
	@Override
	public Payment savePayments(Payment payment) {
		payment.setTransactionId(UUID.randomUUID().toString());
		payment.setPaymentStatus(paymentStatus());
		return paymentRepository.save(payment);
	}
	
	public String paymentStatus() {
		return new Random().nextBoolean()?"Sucess":"fasle";
	}
	
}
