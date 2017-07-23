package ch.renewinkler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@RefreshScope // refresh endpoint needs a POST request and authentication is required
@EnableEurekaClient
public class PingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PingServiceApplication.class, args);
	}
}
