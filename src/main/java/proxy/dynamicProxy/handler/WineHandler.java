package proxy.dynamicProxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WineHandler implements InvocationHandler {

    private Object wine;

    public WineHandler(Object wine) {
        this.wine = wine;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("销售开始  柜台是： "+this.getClass().getSimpleName());
        method.invoke(wine, args);
        System.out.println("销售结束");
        return null;
    }

}
