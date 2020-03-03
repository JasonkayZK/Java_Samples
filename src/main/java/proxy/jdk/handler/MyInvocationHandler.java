package proxy.jdk.handler;

import proxy.jdk.service.MyService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * InvocationHandler 的一个实现，实际上处理代理的逻辑在这里
 *
 * 甚至可以不需要写Service接口的实现类, 而在Handler中写!
 *
 */
public class MyInvocationHandler implements InvocationHandler {

    MyService service;

    public MyInvocationHandler(MyService service) {
        this.service = service;
    }

    public void aopMethod() {
        System.out.println("before method");
    }

    // 继承方法，代理时实际执行的方法;
    // 如果要实现原方法，则需要调用method.invoke(service, args);
    // 这里还调用了一个aopMethod(),可以类比于Spring中的切面before注解;
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        aopMethod();
        return method.invoke(service, args);
    }
}
