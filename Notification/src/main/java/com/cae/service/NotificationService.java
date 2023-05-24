package com.cae.service;

import org.springframework.scheduling.annotation.Async;

import com.cae.entity.Details;

public interface NotificationService {
	
	@Async
	String sendNotification(Details details);

}
