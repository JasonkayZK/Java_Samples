package top.jasonkayzk.ioc.app.controller;

import top.jasonkayzk.ioc.app.service.UserService;
import top.jasonkayzk.ioc.core.annotation.MyAutowired;
import top.jasonkayzk.ioc.core.annotation.MyController;

/**
 * UserController控制器类
 *
 * @author zk
 */
@MyController
public class CustomerController {

    @MyAutowired
    private UserService userService;

}
