package org.acme;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class HelloDeserializer extends ObjectMapperDeserializer<Account> {
    public HelloDeserializer() {
        super(Account.class);
    }
}
