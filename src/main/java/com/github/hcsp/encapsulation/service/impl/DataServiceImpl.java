package com.github.hcsp.encapsulation.service.impl;

import com.github.hcsp.encapsulation.service.DataService;
import java.util.UUID;

public class DataServiceImpl implements DataService {
    @Override
    public String a(int i) {
        return UUID.randomUUID().toString();
    }

    @Override
    public String b(int i) {
        return UUID.randomUUID().toString();
    }
}
