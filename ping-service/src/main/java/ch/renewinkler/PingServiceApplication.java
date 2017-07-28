package ch.renewinkler;

import ch.renewinkler.context.CallContextInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@RefreshScope // refresh endpoint needs a POST request and authentication is required
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class PingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingServiceApplication.class, args);
    }

    // 3 types of clients:
    // - Discovery client
    // - Ribbon-aware Spring RestTemplate
    // - Feign client

    // Ribbon-aware Spring RestTemplate for PongRestTemplateClient
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate() {
        RestTemplate template = new RestTemplate();
        // interceptor for delivering the correlation id to pong-service
        // only this client is configured with this interceptor, the discovery and feign client do not
        // deliver the correlation-id
        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();
        interceptors.add(new CallContextInterceptor());
        return template;
    }
}
