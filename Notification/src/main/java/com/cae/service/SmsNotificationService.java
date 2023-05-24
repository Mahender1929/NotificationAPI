package com.cae.service;

import org.springframework.stereotype.Service;

import com.cae.entity.Details;


@Service(NotificationType.SMS)
public class SmsNotificationService implements NotificationService {

  @Override
  public String sendNotification(Details details) {
	return "Sending SMS";
  }
}
