package com.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.dto.Payment;
import com.order.entity.Order;
import com.order.repository.OrderRepository;
import com.order.util.TransactionRequest;
import com.order.util.TransactionResponse;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RestTemplate restTemplate;

	public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
		String response = "";
		Order order = transactionRequest.getOrder();
		Payment payment = transactionRequest.getPayment();
		payment.setOrderId(order.getOrderId());
		payment.setAmount(order.getPrice());

		Payment paymentResponse = restTemplate.postForObject("http://localhost:8898/payment/doPayment", payment,
				Payment.class);
		response = paymentResponse.getPaymentStatus().equalsIgnoreCase("success") ? "payment id processing" : "fail";
		orderRepository.save(order);

		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(),
				response);
	}

	@Override
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

}
