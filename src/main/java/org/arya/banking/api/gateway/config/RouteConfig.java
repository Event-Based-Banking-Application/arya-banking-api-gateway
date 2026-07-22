package org.arya.banking.api.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Value("${app.service.admin-service.uri:http://localhost:8089}")
    private String adminServiceUri;

    @Value("${app.service.auth-service.uri:http://localhost:8087}")
    private String authServiceUri;

    @Value("${app.service.user-service.uri:http://localhost:8086}")
    private String userServiceUri;

    @Bean
    public RouteLocator swaggerApiDocsRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("admin-service-api-docs", r -> r
                        .path("/admin-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/admin-service/v3/api-docs", "/v3/api-docs"))
                        .uri(adminServiceUri))
                .route("auth-service-api-docs", r -> r
                        .path("/auth-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/auth-service/v3/api-docs", "/v3/api-docs"))
                        .uri(authServiceUri))
                .route("user-service-api-docs", r -> r
                        .path("/user-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/user-service/v3/api-docs", "/v3/api-docs"))
                        .uri(userServiceUri))
                .build();
    }
}
