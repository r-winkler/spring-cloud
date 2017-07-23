package ch.renewinkler.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PongController {

    @Value("${config.pong}")
    String pong;

    @GetMapping("/pong")
    public String pong() {
        return pong;
    }
}
