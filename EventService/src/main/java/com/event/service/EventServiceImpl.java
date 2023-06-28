package com.event.service;

import java.io.IOException;
import java.rmi.ConnectException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.dto.ServerResponse;



@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${order.service.url}")
	private String orderServiceUrl;

	@Value("${order.payment.url}")
	private String pamentServiceUrl;
	
	

	Map<String,Object> response = new HashMap<String,Object>();
	
	public ServerResponse checkOrderServerStatus() throws ConnectException {
		ServerResponse serverResponse = new ServerResponse();
		try {
		ResponseEntity<Map> orderService = restTemplate.getForEntity("http://localhost:" + 9998 + "/actuator/health",Map.class);
		//response.put("orderservice",orderService.getStatusCode());
		serverResponse.setAppUrl(orderServiceUrl);
		serverResponse.setServerName("Order Service");
		serverResponse.setServerstatus(orderService.getStatusCodeValue());
		System.out.println(orderService);
		}catch (Exception e) {
			serverResponse.setAppUrl(orderServiceUrl);
			serverResponse.setServerName("Order Service");
			serverResponse.setServerstatus(500);
	    }
		return serverResponse;
	}

	public ServerResponse checkPaymentServerStatus() {
		ServerResponse serverResponse = new ServerResponse();
		try {
		ResponseEntity<Map> paymentService = restTemplate.getForEntity("http://localhost:" + 8898 + "/actuator/health",Map.class);
		//response.put("orderservice",paymentService.getStatusCode());
		serverResponse.setAppUrl(pamentServiceUrl);
		serverResponse.setServerName("Payment Service");
		serverResponse.setServerstatus(paymentService.getStatusCodeValue());
		System.out.println(paymentService);
		}catch (Exception e) {
			serverResponse.setAppUrl(pamentServiceUrl);
			serverResponse.setServerName("Payment Service");
			serverResponse.setServerstatus(500);
	    }
		return serverResponse;
		
	}
}
