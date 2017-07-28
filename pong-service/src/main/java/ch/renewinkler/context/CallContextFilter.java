package ch.renewinkler.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Slf4j
// Do not name bean "RequestContextFilter", otherwise filter will not work!
public class CallContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        CallContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(CallContext.CORRELATION_ID));
        CallContextHolder.getContext().setUserId(httpServletRequest.getHeader(CallContext.USER_ID));
        CallContextHolder.getContext().setAuthToken(httpServletRequest.getHeader(CallContext.AUTH_TOKEN));

        log.info("Incoming Correlation id: {}", CallContextHolder.getContext().getCorrelationId());
        log.info("Incoming User id: {}", CallContextHolder.getContext().getUserId());
        log.info("Incoming Auth token: {}", CallContextHolder.getContext().getAuthToken());

        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
