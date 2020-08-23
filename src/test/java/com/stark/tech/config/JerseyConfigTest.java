package com.stark.tech.config;

import com.stark.tech.resource.HealthCheck;
import com.stark.tech.resource.RandomPasswordGeneratorResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class JerseyConfigTest {

    @Test
    public void testJerseyConfig() {
        JerseyConfig jerseyConfig = new JerseyConfig();
        assertTrue(jerseyConfig.isRegistered(HealthCheck.class));
        assertTrue(jerseyConfig.isRegistered(RandomPasswordGeneratorResource.class));
    }

}
