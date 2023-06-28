package com.event.service;

import java.rmi.ConnectException;
import java.util.List;

import com.event.dto.ServerResponse;

public interface EventService {

	public ServerResponse checkOrderServerStatus() throws ConnectException;
	public ServerResponse checkPaymentServerStatus();
	
}
