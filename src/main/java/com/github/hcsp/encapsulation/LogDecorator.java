package com.github.hcsp.encapsulation;

import com.github.hcsp.encapsulation.service.DataService;

public class LogDecorator implements DataService {
    private DataService delegate;

    public LogDecorator(DataService delegate) {
        this.delegate = delegate;
    }

    @Override
    public String a(int i) {
        System.out.println("enter a");
        String a = delegate.a(i);
        System.out.println("out a");
        return a;
    }

    @Override
    public String b(int i) {
        System.out.println("enter b");
        String b = delegate.b(i);
        System.out.println("out b");
        return b;
    }
}
