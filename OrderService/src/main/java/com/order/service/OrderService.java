package com.order.service;

import java.util.List;

import com.order.entity.Order;
import com.order.util.TransactionRequest;
import com.order.util.TransactionResponse;

public interface OrderService {

	public TransactionResponse saveOrder(TransactionRequest transactionRequest);

	public List<Order> getAll();
}
