package com.alkemy.javaChallenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alkemy.javaChallenge.model.User;
import com.alkemy.javaChallenge.service.ISendMailService;

@Service
public class SendMailServiceImpl implements ISendMailService{
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMail(User user) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getMail());
		mailMessage.setSubject("Bienvenido");
		mailMessage.setText("Su cuenta ha sido creada con éxito");
		mailSender.send(mailMessage);
	}
}
