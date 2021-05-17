package com.github.hcsp.encapsulation;

import com.github.hcsp.encapsulation.service.DataService;
import com.github.hcsp.encapsulation.service.impl.DataServiceImpl;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;

public class Main {
    static DataService staticDataService = new CacheDecorator(new LogDecorator(new DataServiceImpl()));
    static DataService jdkDynamicDataService = new DataServiceImpl();
    static DataServiceImpl cgLibDynamicDataService = new DataServiceImpl();

    public static void main(String[] args) {
        System.out.println("OOP=====================================");
        // 装饰器模式
        System.out.println(staticDataService.a(1));
        System.out.println(staticDataService.b(1));
        System.out.println();

        System.out.println("AOP=====================================");
        System.out.println("jdk dynamic proxy-----------------------");
        // jdk动态代理
        DataService jdkDataService = (DataService) Proxy.newProxyInstance(jdkDynamicDataService.getClass().getClassLoader(),
                new Class[]{DataService.class},
                new LogProxy(jdkDynamicDataService));
        System.out.println(jdkDataService.a(1));
        System.out.println(jdkDataService.b(1));
        System.out.println();

        System.out.println("CGLib intercept-------------------------");
        // CGLib拦截器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DataServiceImpl.class);
        enhancer.setCallback(new LogInterceptor(cgLibDynamicDataService));

        DataServiceImpl cgLibDataService = (DataServiceImpl) enhancer.create();
        System.out.println(cgLibDataService.a(1));
        System.out.println(cgLibDataService.b(1));
    }
}
