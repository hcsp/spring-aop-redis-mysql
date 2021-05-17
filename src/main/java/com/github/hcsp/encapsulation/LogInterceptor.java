package com.github.hcsp.encapsulation;

import com.github.hcsp.encapsulation.service.impl.DataServiceImpl;
import java.lang.reflect.Method;
import java.util.Arrays;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogInterceptor implements MethodInterceptor {
    private DataServiceImpl delegate;

    public LogInterceptor(DataServiceImpl delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + " is invoked " + Arrays.toString(objects));
        Object retValue = method.invoke(delegate, objects);
        System.out.println(method.getName() + " is finished ");
        return retValue;
    }
}
