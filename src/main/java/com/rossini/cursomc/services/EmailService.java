package com.rossini.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.rossini.cursomc.domain.Cliente;
import com.rossini.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
