package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/account")
public class AccountResource {
    @Inject
    AccountProducer producer;

    @POST
    public Response send(Account account) {
        producer.sendToKafka(account);
        // Return an 202 - Accepted response.
        return Response.accepted().build();
    }
}
