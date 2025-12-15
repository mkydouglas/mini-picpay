package br.com.mkydouglas.mini_picpay.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.com.mkydouglas.mini_picpay.transaction.Transaction;

@Service
public class NotificationConsumer {
    private RestClient restClient;

    public NotificationConsumer(RestClient.Builder builder) {
        this.restClient = builder
            .baseUrl("")
            .build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "mini-picpay")
    public void receiveNotification(Transaction transaction) {
        var response = restClient.get()
            .retrieve()
            .toEntity(Notification.class);

        if (response.getStatusCode().isError() || !response.getBody().message()) {
            throw new NotificationException("Error sending notification!");
        }
    }
}
