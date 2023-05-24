package com.cae.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.cae.entity.Details;

import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailNotificationCommon {
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Autowired
	private Configuration configuration;

	public Template template;

	
	public String sendEmailNotification(Details details, String status) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.addInline("logo.png", new ClassPathResource("caelogo.png"));
			template = configuration.getTemplate(status+".ftl");
			List<String> list = new ArrayList<>();
			for (Map.Entry<String, Object> entry : details.getAttributes_().entrySet()) {
				if(!entry.getKey().equals("id") && !entry.getKey().equals("firstName") && !entry.getKey().equals("lastName") && !entry.getKey().equals("username")&& !entry.getKey().equals("email")) {
			    list.add(entry.getKey() + ":" + entry.getValue());
				}
			}
			details.getAttributes_().put("updateList", list);
			details.getAttributes_().put("subscriptionDate", new Date().toString());
			String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(template, details.getAttributes_());
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getAttributes_().get("email").toString());
			mimeMessageHelper.setText(htmlBody, true);
			mimeMessageHelper.setSubject(details.getSubject());
			javaMailSender.send(mimeMessage);
			return "Mail Sent Successfully...";
		} catch (Exception e) {
			return "Error while Sending Mail";
		}
	}

}
