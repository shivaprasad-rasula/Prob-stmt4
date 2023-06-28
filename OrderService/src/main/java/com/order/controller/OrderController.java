package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Order;
import com.order.service.OrderService;
import com.order.util.TransactionRequest;
import com.order.util.TransactionResponse;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired(required = true)
	OrderService orderService;

	@PostMapping("/placeOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionRequest) {
		return orderService.saveOrder(transactionRequest);
	}
	
	@GetMapping("/placeOrder")
	public List<Order> saveOrder() {
		return  orderService.getAll();
	}
	
}
