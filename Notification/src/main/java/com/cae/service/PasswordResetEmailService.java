package com.cae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cae.entity.Details;

@Service
public class PasswordResetEmailService implements NotificationService {

	@Autowired
	EmailNotificationCommon emailNotificationCommon;
	
	@Override
	public String sendNotification(Details details) {
		String sendEmailNotification = emailNotificationCommon.sendEmailNotification(details,"passwordReset");
		return sendEmailNotification;

	}

}
