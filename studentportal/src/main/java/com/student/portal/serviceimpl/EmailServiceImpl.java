package com.student.portal.serviceimpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.student.portal.entity.Reciver;
import com.student.portal.entity.Sender;
import com.student.portal.service.MessageServiceType;

public class EmailServiceImpl implements MessageServiceType {

	private Sender sender = null;
	private Reciver reciver = null;

	public EmailServiceImpl() {
	}

	public EmailServiceImpl(Sender sender, Reciver reciver) {

		this.sender = sender;
		this.reciver = reciver;
	}

	@Override
	public void sendMessage() {
		String d_host = "smtp.gmail.com", d_port = "465";
		Properties props = new Properties();
		props.put("mail.smtp.user", sender.getEmailId());
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable", "true");
		Authenticator auth = new Authenticator() {};
		Session session = Session.getInstance(props, auth);
		session.setDebug(true);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSubject(sender.getSubject());
			msg.setFrom(new InternetAddress(sender.getEmailId()));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(reciver.getEmailId()));
			msg.setText(sender.getMessage());
			Transport transport = session.getTransport("smtps");
			transport.connect(d_host, Integer.valueOf(d_port), sender.getEmailId(), sender.getPassword());
			transport.sendMessage(msg, msg.getRecipients(RecipientType.TO));
			transport.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
