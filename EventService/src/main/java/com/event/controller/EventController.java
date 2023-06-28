package com.event.controller;

import java.rmi.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.dto.ServerResponse;
import com.event.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventService eventService;
	
	@GetMapping("/getHealthStatus")
	@Scheduled(cron = "*/30 * * * * *")
	public ResponseEntity<?> getServerHealthStatus() throws ConnectException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		 ServerResponse checkOrderServer = eventService.checkOrderServerStatus();
		 System.out.println(checkOrderServer.toString());
		 ServerResponse checkPaymentServer = eventService.checkPaymentServerStatus();
		 System.out.println(checkPaymentServer.toString());
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
		return null;
	}
	// end point fomr mail
	
	// Adding Users
	// basci login
	
}
