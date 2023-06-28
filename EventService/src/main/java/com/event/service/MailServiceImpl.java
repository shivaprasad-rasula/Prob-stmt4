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

import com.event.config.Config;
import com.event.entity.Mail;
import com.event.entity.User;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Config config;
	/*
	 * Sending the mail to all the users available inthe Userstable with service
	 * name and url details
	 */
	
	@Override
	public String sendMail(Mail mails) {
		// Recipient's email ID needs to be mentioned.
		//String to = "narani0126@gmail.com";
		String responseMgs="";
		String from = "serveralertnorelplay@gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.user", config.getFrom());
		props.put("mail.password", config.getMailPassword());

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, config.getMailPassword());
			}
		});

		ResponseEntity<User[]> response = restTemplate.getForEntity(config.getUserServiceUrl(),User[].class);
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
				message.setText("Hello Team,"+System.lineSeparator ()+" <html> We found that <b>"
						+mails.getServiceName() +"</b> "
						+System.lineSeparator ()+" down(Not working as expected) with the following URL <b>"+mails.getUrl()+"</b> </html>");
				// Send message
				Transport.send(message);
				responseMgs = "Sent message successfully....";
			}
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return responseMgs;
	}
}