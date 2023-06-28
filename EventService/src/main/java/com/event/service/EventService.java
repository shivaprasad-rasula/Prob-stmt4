package com.event.service;

import com.event.dto.ServerResponse;

public interface EventService {

	ServerResponse checkOrderServer();

	ServerResponse checkPaymentServer();

	ServerResponse checkUserServer();

	

	
	
}
