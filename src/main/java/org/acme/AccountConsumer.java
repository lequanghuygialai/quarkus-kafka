package org.acme;

import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AccountConsumer {
    private final Logger logger = Logger.getLogger(AccountConsumer.class);

    @Incoming("account-in")
    public void receive(Record<String, Account> record) {
        logger.infof("Got a record %s: name: %s - email: %s ", record.key(), record.value().name, record.value().email);
    }
}
