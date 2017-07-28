package ch.renewinkler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FilterChainController {

    @Autowired
    private FilterChainProxy filterChain;

    @GetMapping("/filterChain")
    public Map<Integer, Map<Integer, String>> getServletFilterChain() {
        return this.getSecurityFilterChainProxy();
    }

    public Map<Integer, Map<Integer, String>> getSecurityFilterChainProxy() {
        Map<Integer, Map<Integer, String>> filterChains = new HashMap<>();
        int i = 1;
        for (SecurityFilterChain secfc : this.filterChain.getFilterChains()) {
            //filters.put(i++, secfc.getClass().getName());
            Map<Integer, String> filters = new HashMap<>();
            int j = 1;
            for (Filter filter : secfc.getFilters()) {
                filters.put(j++, filter.getClass().getName());
            }
            filterChains.put(i++, filters);
        }
        return filterChains;
    }
}
