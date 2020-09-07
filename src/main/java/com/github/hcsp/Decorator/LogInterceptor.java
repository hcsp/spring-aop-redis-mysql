package com.github.hcsp.Decorator;

import java.lang.reflect.Method;

import com.github.hcsp.Manager.goodsRankManager;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogInterceptor implements MethodInterceptor {
    private goodsRankManager goodsRankManager;

    public LogInterceptor(com.github.hcsp.Manager.goodsRankManager goodsRankManager) {
        this.goodsRankManager = goodsRankManager;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object retValue = method.invoke(goodsRankManager, args);
        return retValue;
    }
}
