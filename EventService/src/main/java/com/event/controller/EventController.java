package com.event.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EventController {

	@GetMapping("/getHealthStatus")
	@Scheduled(cron = "*/60 * * * * *")
	public ResponseEntity<?> getServerHealthStatus() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		
		// call other service api and event-service.
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
		return null;
	}
	// end point fomr mail
	
	// Adding Users
	// basci login
	
}
