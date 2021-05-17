package com.github.hcsp.encapsulation;

import com.github.hcsp.encapsulation.service.DataService;
import java.util.HashMap;
import java.util.Map;

public class CacheDecorator implements DataService {
    private Map<String, String> cache = new HashMap<>();

    private DataService delegate;

    public CacheDecorator(DataService delegate) {
        this.delegate = delegate;
    }

    @Override
    public String a(int i) {
        String cachedValue = cache.get("a");
        if (cachedValue == null) {
            String realValue = delegate.a(i);
            cache.put("a", realValue);
            return realValue;
        }
        return cachedValue;
    }

    @Override
    public String b(int i) {
        String cachedValue = cache.get("b");
        if (cachedValue == null) {
            String realValue = delegate.b(i);
            cache.put("b", realValue);
            return realValue;
        }
        return cachedValue;
    }
}
