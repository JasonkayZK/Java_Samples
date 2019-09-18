package proxy.dynamicProxy;

import proxy.dynamicProxy.handler.WineHandler;
import proxy.dynamicProxy.service.WineService;
import proxy.dynamicProxy.service.impl.WineServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        WineService wineService = new WineServiceImpl();

        InvocationHandler handler = new WineHandler(wineService);

        WineService dynamicProxy = (WineService) Proxy.newProxyInstance(WineService.class.getClassLoader(), WineServiceImpl.class.getInterfaces(), handler);

        dynamicProxy.sellWine();
    }
}
