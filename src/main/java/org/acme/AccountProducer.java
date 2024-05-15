package org.acme;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.UUID;

@ApplicationScoped
public class AccountProducer {
    @Inject
    @Channel("account-out")
    Emitter<Record<String, Account>> emitter;

    public void sendToKafka(Account account) {
        emitter.send(Record.of(UUID.randomUUID().toString(), account));
    }
}
