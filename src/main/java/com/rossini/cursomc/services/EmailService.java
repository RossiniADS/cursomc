package com.rossini.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.rossini.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
