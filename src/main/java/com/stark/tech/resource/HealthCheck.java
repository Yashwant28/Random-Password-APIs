package com.stark.tech.resource;

import com.stark.tech.model.StatusMessage;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/healthCheck")
public class HealthCheck {

    @PermitAll
    @GET
    @Produces("application/json")
    public Response healthCheckResponse() {
        StatusMessage message = new StatusMessage();
        message.setMessage("Health Check Works!!");
        return Response.ok().entity(message).build();
    }

}
