package com.event.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${order.host}")
	public 	String orderHost;
	
	@Value("${payment.host}")
	public  String paymentHost;
	
	@Value("${user.host}")
	public  String userHost;

	@Value("${actuator.health.url}")
	public  String actuator;
	
	@Value("${order.service.url}")
	public  String orderServiceUrl;

	@Value("${payment.service.url}")
	public  String pamentServiceUrl;

	@Value("${user.service.url}")
	public  String userServiceUrl;
	
	
	@Value("${mail.username}")
	public  String mailUsername;
	
	
	@Value("${mail.password}")
	public  String mailPassword;

	@Value("${mail.from}")
	public  String from;
	
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getMailUsername() {
		return mailUsername;
	}

	public void setMailUsername(String mailUsername) {
		this.mailUsername = mailUsername;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getOrderHost() {
		return orderHost;
	}

	public void setOrderHost(String orderHost) {
		this.orderHost = orderHost;
	}

	public String getPaymentHost() {
		return paymentHost;
	}

	public void setPaymentHost(String paymentHost) {
		this.paymentHost = paymentHost;
	}

	public String getUserHost() {
		return userHost;
	}

	public void setUserHost(String userHost) {
		this.userHost = userHost;
	}

	public String getActuator() {
		return actuator;
	}

	public void setActuator(String actuator) {
		this.actuator = actuator;
	}

	public String getOrderServiceUrl() {
		return orderServiceUrl;
	}

	public void setOrderServiceUrl(String orderServiceUrl) {
		this.orderServiceUrl = orderServiceUrl;
	}

	public String getPamentServiceUrl() {
		return pamentServiceUrl;
	}

	public void setPamentServiceUrl(String pamentServiceUrl) {
		this.pamentServiceUrl = pamentServiceUrl;
	}

	public String getUserServiceUrl() {
		return userServiceUrl;
	}

	public void setUserServiceUrl(String userServiceUrl) {
		this.userServiceUrl = userServiceUrl;
	}
	
	
}
