package proxy.jdk;

import proxy.jdk.handler.MyInvocationHandler;
import proxy.jdk.service.MyService;
import proxy.jdk.service.impl.MyServiceImpl;

import java.lang.reflect.Proxy;

@SuppressWarnings("restriction")
public class JavaProxyTest {

    public static void main(String[] args) {

        MyService newService = (MyService) Proxy.newProxyInstance(MyService.class.getClassLoader(),
                MyServiceImpl.class.getInterfaces(),
                new MyInvocationHandler(new MyServiceImpl()));

        // 这里可以看到这个类以及被代理，在执行方法前会执行aopMethod();
        // 这里需要注意的是oneDay（）方法和oneDayFinal（）的区别;
        // oneDayFinal的方法aopMethod执行1次，oneDay的aopMethod执行1次!!!
        newService.gotoSchool();
        newService.gotoWork();
        newService.oneDay();
        newService.oneDayFinal();
    }
}
