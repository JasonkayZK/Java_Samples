package proxy.dynamicProxy.service.impl;

import proxy.dynamicProxy.service.WineService;

public class WineServiceImpl2 implements WineService {

    @Override
    public void sellWine() {
        System.out.println("我卖得是五粮液。");
    }
}
