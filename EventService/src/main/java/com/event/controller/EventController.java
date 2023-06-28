package com.event.controller;

import java.rmi.ConnectException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.dto.ServerResponse;
import com.event.entity.Mail;
import com.event.service.EventService;
import com.event.service.MailService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventService eventService;

	@Autowired
	MailService mailService;

	@GetMapping("/getHealthStatus")
	@Scheduled(cron = "*/30 * * * * *")
	public ResponseEntity<List<ServerResponse>> getServerHealthStatus() throws ConnectException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date now = new Date();
		List<ServerResponse> serverList = new ArrayList<ServerResponse>();
		ServerResponse orderServer = eventService.checkOrderServer();
		ServerResponse paymentServer = eventService.checkPaymentServer();
		ServerResponse userServer = eventService.checkUserServer();
		serverList.add(orderServer);
		serverList.add(paymentServer);
		serverList.add(userServer);

		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
		serverList.stream().forEach(e -> System.out.println(e.getServerName() + "-" + e.getStatus()));
		return new ResponseEntity<List<ServerResponse>>(serverList, HttpStatus.OK);
	}

	@PostMapping("/mail")
	public String sendMail(@RequestBody Mail mail) {
		return mailService.sendMail(mail);
	}
}
