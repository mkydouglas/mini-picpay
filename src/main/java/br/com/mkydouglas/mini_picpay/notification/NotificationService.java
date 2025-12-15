package br.com.mkydouglas.mini_picpay.notification;

import org.springframework.stereotype.Service;

import br.com.mkydouglas.mini_picpay.transaction.Transaction;

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;

    public NotificationService(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    public void notify(Transaction transaction) {
        notificationProducer.sendNotification(transaction);
    }
}
