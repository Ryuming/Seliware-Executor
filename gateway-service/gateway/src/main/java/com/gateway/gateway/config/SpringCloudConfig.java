package com.gateway.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("gallery-service", r -> r.path("/api/gallery/**")
                        .uri("lb://gallery-service")
                        )
                .route("image-service", r -> r.path("/api/image/**")
                        .uri("lb://image-service")
                        )
                .build();

    }
}
