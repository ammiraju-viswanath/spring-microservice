package com.vis.learning;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()

				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion"))

				.route(p -> p.path("/sainsburry-c4-stage1-currency-conversion/**")
						.filters(f -> f.rewritePath("/sainsburry-c4-stage1-currency-conversion/(?<segment>.*)",
								"/currency-conversion/${segment}"))
						.uri("lb://currency-conversion"))

				.route(p -> p.path("/sainsburry-c4-stage1-currency-exchange/**")
						.filters(f -> f.rewritePath("/sainsburry-c4-stage1-currency-exchange/(?<segment>.*)",
								"/currency-exchange/${segment}"))
						.uri("lb://currency-exchange"))

				.build();
	}

}
