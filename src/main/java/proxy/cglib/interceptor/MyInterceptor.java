package proxy.cglib.interceptor;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.cglib.service.impl.CGLibServiceImpl;

import java.lang.reflect.Method;

/**
 * 可以类比于jdk动态代理中的InvocationHandler, 实际上被代理后重要的类!
 *
 * 实际上后续执行的就是intercept里的方法;
 *
 * 如果需要执行原来的方法，则调用 method.invoke(s, args);
 *
 * 这里也加了一个aopMethod();
 */
public class MyInterceptor implements MethodInterceptor {

    private CGLibServiceImpl service;

    public MyInterceptor(CGLibServiceImpl service) {
        this.service = service;
    }

    private void aopMethod() {
        System.out.println("i am aopMethod");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        aopMethod();
        return method.invoke(service, args);
    }

}
