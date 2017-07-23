package ch.renewinkler.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PongRestTemplateClient {

    @Autowired
    RestTemplate restTemplate;

    public String getPong() {
        ResponseEntity<String> restExchange =
                restTemplate.exchange(
                        "http://pong-service/pong",
                        HttpMethod.GET, null, String.class);
        return restExchange.getBody();
    }
}
