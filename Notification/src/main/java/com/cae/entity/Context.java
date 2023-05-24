package com.cae.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.cae.service.NotificationService;

public class Context {

	@Autowired
	private NotificationService notificationService;

	public Context(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public String executeStrategy(Details details) {
		return notificationService.sendNotification(details);
	}
}