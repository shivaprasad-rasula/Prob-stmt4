package com.event.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.event.entity.Mail;
import com.event.entity.User;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public String sendMail(Mail mails) {
		// Recipient's email ID needs to be mentioned.
		//String to = "narani0126@gmail.com";
		String from = "serveralertnorelplay@gmail.com";
		final String username = "erveralertnorelplay";// change accordingly
		final String password = "qobglvwlgtdyvtfa";// change accordingly

		String host = "localhost"; // or IP address
		Properties props = new Properties();
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.user", from);
		props.put("mail.password", password);

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		//User forObject = restTemplate.postForObject("http://localhost:8897/user/users",User.class,Map<String,String> m);
		ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:8897/user/users",User[].class);
				User[] body = response.getBody();
		try {
			List<User> asList = Arrays.asList(body);
			for (User user : asList) {
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);
				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));
				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
				// Set Subject: header field
				message.setSubject("Server Down Alert ");
				// Now set the actual message
				message.setText("Hello Team,"+System.lineSeparator ()+" please check the service "
						+mails.getServiceName() +" "
						+System.lineSeparator ()+" with the Url "+mails.getUrl());
				// Send message
				Transport.send(message);
				System.out.println("Sent message successfully....");
			}
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return "";
	}
	
}