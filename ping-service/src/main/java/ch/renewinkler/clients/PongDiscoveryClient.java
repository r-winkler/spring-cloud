package ch.renewinkler.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PongDiscoveryClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getPong() {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("pong-service");
        if (instances.size() == 0) return null;
        String serviceUri = String.format("%s/pong", instances.get(0).getUri().toString());
        ResponseEntity<String> restExchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, String.class);
        return restExchange.getBody();
    }
}
