package com.cae.service;

import org.springframework.stereotype.Service;

import com.cae.entity.Details;


@Service(NotificationType.PUSH_NOTIFICATION)
public class PushNotificationService implements NotificationService {

  @Override
  public String sendNotification(Details details) {
   return "Sending push notification";
  }
}
