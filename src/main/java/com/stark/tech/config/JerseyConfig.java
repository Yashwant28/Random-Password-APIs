package com.stark.tech.config;

import com.stark.tech.resource.HealthCheck;
import com.stark.tech.resource.RandomPasswordGeneratorResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HealthCheck.class);
        register(RandomPasswordGeneratorResource.class);
    }
}
