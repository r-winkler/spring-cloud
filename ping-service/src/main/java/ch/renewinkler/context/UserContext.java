package ch.renewinkler.context;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class UserContext {

    public static final String CORRELATION_ID = "correlation-id";
    public static final String AUTH_TOKEN = "auth-token";
    public static final String USER_ID = "user-id";

    private String correlationId = new String();
    private String authToken = new String();
    private String userId = new String();

}
