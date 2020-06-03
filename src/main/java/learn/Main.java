package learn;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    static DataServiceImpl service = new DataServiceImpl(); // 忘掉刚才的接口，现在就是一个类

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DataServiceImpl.class); // 把需要动态代理的类设置为代理类的超类
        enhancer.setCallback(new LogInterceptor(service)); // 当代理类的方法被调用时，调用给定的 callback

        DataServiceImpl enhancedService = (DataServiceImpl) enhancer.create();
        enhancedService.a(1);
        enhancedService.b(2);
    }
}
