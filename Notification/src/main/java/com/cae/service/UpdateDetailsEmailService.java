package com.cae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cae.entity.Details;

@Service
public class UpdateDetailsEmailService implements NotificationService {

	@Autowired
	EmailNotificationCommon emailNotificationCommon;
	
	@Override
	public String sendNotification(Details details) {
		String sendEmailNotification = emailNotificationCommon.sendEmailNotification(details, "detailsUpdate");
		return sendEmailNotification;

	}

}
