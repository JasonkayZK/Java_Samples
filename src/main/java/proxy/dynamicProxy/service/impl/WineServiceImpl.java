package proxy.dynamicProxy.service.impl;

import proxy.dynamicProxy.service.WineService;

public class WineServiceImpl implements WineService {

    @Override
    public void sellWine() {
        System.out.println("我卖得是茅台酒。");
    }
}
