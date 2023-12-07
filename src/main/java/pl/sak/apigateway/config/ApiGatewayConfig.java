package pl.sak.apigateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApiGatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer", r -> r
                        .path("/customers/**")
                        .filters(f -> f.filter(filter))
//                        .uri("host.docker.internal:customer:8081"))
                        .uri("lb://CUSTOMER"))
                .route("ride-request", r -> r
                        .path("/ride-requests/**")
                        .filters(f -> f.filter(filter))
//                        .uri("localhost:8081"))
                        .uri("lb://CUSTOMER"))
                .route("driver", r -> r
                        .path("/drivers/**")
                        .filters(f -> f.filter(filter))
//                        .uri("host.docker.internal:driver:8082"))
                        .uri("lb://DRIVER"))
                .route("ride", r -> r
                        .path("/rides/**")
                        .filters(f -> f.filter(filter))
//                        .uri("localhost:8083"))
                        .uri("lb://RIDE"))
                .route("security", r -> r
                        .path("/auths/**")
                        .filters(f -> f.filter(filter))
//                        .uri("localhost:8084"))
                        .uri("lb://SECURITY"))
                .build();
    }
}
