package com.stark.tech.resource;

import com.stark.tech.model.StatusMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class HealthCheckTest {

    @InjectMocks
    private HealthCheck healthCheck;

    @Test
    public void testHealthCheckResource() {
        StatusMessage mockMessage = new StatusMessage();
        mockMessage.setMessage("Health Check Works!!");
        Response actualRespone = healthCheck.healthCheckResponse();
        StatusMessage actualStatusMessage = (StatusMessage) actualRespone.getEntity();
        assertEquals(actualStatusMessage.getMessage(), mockMessage.getMessage());
    }

}
