package com.nt.service;

import java.util.Arrays;                                                                                
import java.util.Date;                                                                            

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseService")
public class PurchaseOrderMgmtService implements IPurchaseOrderMgmtService {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Override
	public String purchase(String[] items, Double[] prices, String[] emails)throws Exception {
		
		Double billAmt = 0.0d;
		for(Double p : prices)
		{
			billAmt = billAmt+p;
		}
		String msg = Arrays.toString(items)+" Are Purchased Having "+ Arrays.toString(prices)+" With Bill Amount "+billAmt;
		String mailStatus = sendMail(msg,emails);
		return msg+"...."+mailStatus;
	}
	
	private String sendMail(String messageBody, String toMails[])throws Exception
	{
		//Create MIME Message.
		MimeMessage message = sender.createMimeMessage();
		//Create MimeMessageHelper Object.
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		//Set Message Headers.
		helper.setFrom(fromMail);
		helper.setCc(toMails);
		helper.setSubject("Open It To Know It.");
		helper.setSentDate(new Date());
		helper.setText(messageBody);
		helper.addAttachment("SreeHarsha.png", new ClassPathResource("SreeHarsha.png"));
		sender.send(message);
		
		return "Mail Has Been Sent To The Customers.";
	}
}
