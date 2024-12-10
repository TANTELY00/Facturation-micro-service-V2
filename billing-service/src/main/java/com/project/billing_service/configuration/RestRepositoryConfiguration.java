package com.project.billing_service.configuration;

import com.project.billing_service.entities.Bill;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepositoryConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(org.springframework.data.rest.core.config.RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Bill.class);
    }
}
