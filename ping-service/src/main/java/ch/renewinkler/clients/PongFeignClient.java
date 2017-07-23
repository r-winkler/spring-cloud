package ch.renewinkler.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("pong-service")
public interface PongFeignClient {

    @GetMapping("/pong")
    String getPong();
}