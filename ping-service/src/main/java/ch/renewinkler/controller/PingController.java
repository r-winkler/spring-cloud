package ch.renewinkler.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Value("${config.ping}")
    String ping;

    @GetMapping("/ping")
    public String ping() {
        return ping;
    }
}
