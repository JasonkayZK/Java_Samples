package top.jasonkayzk.ioc.app.service;

import top.jasonkayzk.ioc.core.annotation.MyComponent;
import top.jasonkayzk.ioc.core.annotation.MyLazy;

/**
 * LazyService懒加载测试
 *
 * @author zk
 */
@MyLazy
@MyComponent
public class LazyService {

    public LazyService() {
        System.out.println("测试懒加载: LazyService 的无参构造被执行");
    }

}
