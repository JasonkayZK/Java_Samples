package top.jasonkayzk.ioc.app.service;

import top.jasonkayzk.ioc.core.annotation.MyAutowired;
import top.jasonkayzk.ioc.core.annotation.MyService;

/**
 * @author zk
 */
@MyService(name = "myCustomer")
public class CustomerService {

    @MyAutowired
    private UserService userService;

}
