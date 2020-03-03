package proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import proxy.cglib.interceptor.MyInterceptor;
import proxy.cglib.service.impl.CGLibServiceImpl;
import proxy.jdk.service.MyService;

public class CGLibProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        Callback c = new MyInterceptor(new CGLibServiceImpl());

        enhancer.setSuperclass(CGLibServiceImpl.class);
        enhancer.setCallback(c);

        CGLibServiceImpl helper = (CGLibServiceImpl) enhancer.create();

        helper.goHome();
        helper.gotoSchool();
        System.out.println();
        // 这里可以看到这个类以及被代理，在执行方法前会执行aopMethod（）;
        // 这里需要注意的是oneDay（）方法和onedayFinal（）的区别:
        // onedayFinal的方法aopMethod执行2次，oneDay的aopMethod执行1次!!!!
        // 注意这里和jdk的代理的区别!!!
        helper.oneday();
        System.out.println();

        helper.onedayFinal();
    }




}
