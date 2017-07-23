package ch.renewinkler.controller;

import ch.renewinkler.clients.PongDiscoveryClient;
import ch.renewinkler.clients.PongFeignClient;
import ch.renewinkler.clients.PongRestTemplateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Autowired
    PongDiscoveryClient pongDiscoveryClient;

    @Autowired
    PongRestTemplateClient pongRestTemplateClient;

    @Autowired
    PongFeignClient pongFeignClient;

    @Value("${config.ping}")
    String ping;

    @GetMapping("/ping")
    public String ping() {
        return String.join(" ",
                ping,
                pongDiscoveryClient.getPong(),
                pongRestTemplateClient.getPong(),
                pongFeignClient.getPong()
                );
    }
}
