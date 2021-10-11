package com.capstone.service;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.capstone.domain.EmailVO;

@Service
public class EmailServiceImpl implements EmailService {
	@Inject
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(EmailVO vo) {
		try {
				MimeMessage msg = mailSender.createMimeMessage();
				msg.addRecipient(RecipientType.TO, new InternetAddress(vo.getReceiveMail()));
				msg.addFrom(new InternetAddress[] { new InternetAddress(vo.getSenderMail(), vo.getSenderName()) });
				msg.setSubject(vo.getSubject(), "utf-8");
				msg.setText(vo.getMessage(), "utf-8");
				mailSender.send(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
