package com.event.controller;

import java.rmi.ConnectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
	public ResponseEntity<List<ServerResponse>> getServerHealthStatus() throws ConnectException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		List<ServerResponse> serverList = new ArrayList<ServerResponse>();
		 ServerResponse checkOrderServer = eventService.checkOrderServerStatus();
		 ServerResponse checkPaymentServer = eventService.checkPaymentServerStatus();
		 serverList.add(checkOrderServer);
		 serverList.add(checkPaymentServer);
		 System.out.println(checkPaymentServer.toString());
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
		return new ResponseEntity<List<ServerResponse>>(serverList, HttpStatus.OK);
	}
	// end point fomr mail
	
	// Adding Users
	// basci login
	
}
