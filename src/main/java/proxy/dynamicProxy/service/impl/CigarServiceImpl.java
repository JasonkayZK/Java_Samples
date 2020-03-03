package proxy.dynamicProxy.service.impl;

import proxy.dynamicProxy.service.CigarService;

public class CigarServiceImpl implements CigarService {

    @Override
    public void sell() {
        System.out.println("售卖的是正宗的芙蓉王，可以扫描条形码查证。");
    }
}
