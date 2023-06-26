package com.order.service;

import java.util.List;

import com.order.entity.Order;

public interface OrderService {

	public Order saveOrder(Order order);

	public List<Order> getAll();
}
