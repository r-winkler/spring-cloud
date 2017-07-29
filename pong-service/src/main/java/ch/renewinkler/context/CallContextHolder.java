package ch.renewinkler.context;

public class CallContextHolder {

    /**
     * Will not work when using Hysterix!
     * https://github.com/jmnarloch/hystrix-context-spring-boot-starter
     */
    private static final ThreadLocal<CallContext> userContext = new ThreadLocal<>();

    public static final CallContext getContext() {
        CallContext context = userContext.get();

        if (context == null) {
            context = new CallContext();
            userContext.set(context);
        }
        return userContext.get();
    }

}
