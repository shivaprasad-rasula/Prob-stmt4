package com.event.service;

import java.rmi.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.config.Config;
import com.event.dto.ServerResponse;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Config config;
//
//	@Value("${order.host}")
//	public String orderHost;
//
//	@Value("${payment.host}")
//	public String paymentHost;
//
//	@Value("${user.host}")
//	public String userHost;
//
//	@Value("${actuator.health.url}")
//	public String actuator;
//
//	@Value("${order.service.url}")
//	public String orderServiceUrl;
//
//	@Value("${payment.service.url}")
//	public String pamentServiceUrl;
//
//	@Value("${user.service.url}")
//	public String userServiceUrl;

	public ServerResponse checkOrderServer() {
		ServerResponse serverResponse = new ServerResponse();
		try {
			System.out.println(config.getOrderHost() + config.getActuator());
			ResponseEntity<Map> orderService = restTemplate.getForEntity(config.getOrderHost() + config.getActuator(),
					Map.class);
			// response.put("orderservice",orderService.getStatusCode());
			serverResponse.setApplicationUrl(config.getOrderServiceUrl());
			serverResponse.setServerName("Order Service");
			serverResponse.setStatus(orderService.getStatusCodeValue());
			System.out.println(orderService);
		} catch (Exception e) {
			serverResponse.setApplicationUrl(config.getOrderServiceUrl());
			serverResponse.setServerName("Order Service");
			serverResponse.setStatus(500);
		}
		return serverResponse;
	}

	public ServerResponse checkPaymentServer() {
		ServerResponse serverResponse = new ServerResponse();
		try {
			ResponseEntity<Map> paymentService = restTemplate.getForEntity(config.getPaymentHost() + config.getActuator(),
					Map.class);
			serverResponse.setApplicationUrl(config.getPamentServiceUrl());
			serverResponse.setServerName("Payment Service");
			serverResponse.setStatus(paymentService.getStatusCodeValue());
			System.out.println(paymentService);
		} catch (Exception e) {
			serverResponse.setApplicationUrl(config.getPamentServiceUrl());
			serverResponse.setServerName("Payment Service");
			serverResponse.setStatus(500);
		}
		return serverResponse;

	}

	public ServerResponse checkUserServer() {
		ServerResponse serverResponse = new ServerResponse();
		try {
			ResponseEntity<Map> paymentService = restTemplate.getForEntity(config.getUserHost() + config.getActuator(),
					Map.class);
			serverResponse.setApplicationUrl(config.getUserServiceUrl());
			serverResponse.setServerName("User Service");
			serverResponse.setStatus(paymentService.getStatusCodeValue());
			System.out.println(paymentService);
		} catch (Exception e) {
			serverResponse.setApplicationUrl(config.getUserServiceUrl());
			serverResponse.setServerName("User Service");
			serverResponse.setStatus(500);
		}
		return serverResponse;

	}
}
