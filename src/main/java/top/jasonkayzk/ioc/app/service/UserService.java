package top.jasonkayzk.ioc.app.service;

import top.jasonkayzk.ioc.core.annotation.MyAutowired;
import top.jasonkayzk.ioc.core.annotation.MyComponent;

/**
 * UserService
 *
 * 提供myCustomer实例
 *
 * @author zk
 */
@MyComponent
public class UserService {

    @MyAutowired
    private CustomerService myCustomer;

    public CustomerService getMyCustomer() {
        return myCustomer;
    }

}
