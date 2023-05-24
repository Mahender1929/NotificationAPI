package com.cae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cae.entity.Context;
import com.cae.entity.Details;
import com.cae.service.PasswordResetEmailService;
import com.cae.service.UpdateDetailsEmailService;
import com.cae.service.WelcomeEmailService;

@RestController
@RequestMapping("/sendMail")
public class EmailController {

	@Autowired
	WelcomeEmailService welcomeEmailService;

	@Autowired
	PasswordResetEmailService passwordResetEmailService;
	
	@Autowired
	UpdateDetailsEmailService updateDetailsEmailService;

	@PostMapping("/welcome")
	public String sendMail(@RequestBody Details details) throws Exception {
		Context context = new Context(welcomeEmailService);
		String status = context.executeStrategy(details);
		return status;
	}

	@PostMapping("/passwordReset")
	public String sendMailForPasswordReset(@RequestBody Details details) throws Exception {
		Context context = new Context(passwordResetEmailService);
		String status = context.executeStrategy(details);
		return status;

	}

	@PostMapping("/detailsUpdate")
	public String sendMailFordetailsUpdate(@RequestBody Details details) throws Exception {
		Context context = new Context(updateDetailsEmailService);
		String status = context.executeStrategy(details);
		return status;
	}
}

/*
 * @PostMapping("/sendMailWithAttachment") public String
 * sendMailWithAttachment(@RequestBody Details details){ String status =
 * emailService.sendMailWithAttachment(details); return status; }
 */