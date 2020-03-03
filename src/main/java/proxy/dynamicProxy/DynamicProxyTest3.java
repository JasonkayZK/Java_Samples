package proxy.dynamicProxy;

import proxy.dynamicProxy.handler.WineHandler;
import proxy.dynamicProxy.service.CigarService;
import proxy.dynamicProxy.service.WineService;
import proxy.dynamicProxy.service.impl.CigarServiceImpl;
import proxy.dynamicProxy.service.impl.WineServiceImpl;
import proxy.dynamicProxy.service.impl.WineServiceImpl2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest3 {

    public static void main(String[] args) {
        WineService wineService1 = new WineServiceImpl();
        WineService wineService2 = new WineServiceImpl2();
        CigarService cigarService = new CigarServiceImpl();

        InvocationHandler handler1 = new WineHandler(wineService1);
        InvocationHandler handler2 = new WineHandler(wineService2);
        InvocationHandler handler3 = new WineHandler(cigarService);

        ((WineService) Proxy.newProxyInstance(WineService.class.getClassLoader(),
                WineServiceImpl.class.getInterfaces(), handler1)).sellWine();

        ((WineService)Proxy.newProxyInstance(WineService.class.getClassLoader(),
                WineServiceImpl2.class.getInterfaces(), handler2)).sellWine();

        ((CigarService)Proxy.newProxyInstance(CigarService.class.getClassLoader(),
                CigarServiceImpl.class.getInterfaces(), handler3)).sell();
    }
}
