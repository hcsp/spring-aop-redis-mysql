package learn;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

public class LogInterceptor implements MethodInterceptor {
    private DataServiceImpl delegate;

    public LogInterceptor(DataServiceImpl delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() + " is invoked: " + Arrays.toString(objects));
        Object retValue = method.invoke(delegate, objects);
        System.out.println(method.getName() + " is finished: " + retValue);
        return retValue;
    }
}
