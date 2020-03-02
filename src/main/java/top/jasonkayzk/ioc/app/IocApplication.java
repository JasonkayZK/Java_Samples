package top.jasonkayzk.ioc.app;

import top.jasonkayzk.ioc.app.service.CustomerService;
import top.jasonkayzk.ioc.app.service.UserService;
import top.jasonkayzk.ioc.core.context.AnnotationConfigApplicationContext;

import java.util.Set;

/**
 * 启动类
 *
 * @author zk
 */
public class IocApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("top.jasonkayzk.ioc.app");
        System.out.println("---------------容器创建完毕-------------------");

        // 测试类型首字母小写获取
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);

        // 测试自定义名称
        CustomerService customerService = (CustomerService) context.getBean("myCustomer");
        System.out.println(customerService);

        // 测试懒加载
        Object lazyService = context.getBean("lazyService");
        System.out.println(lazyService);

        // 测试循环依赖
        System.out.println("测试循环依赖  " + (customerService == userService.getMyCustomer()));
        System.out.println("--------------------------------------------------------");
        Set<String> beanDefinitionNames = context.getBeanDefinitionNames();
        beanDefinitionNames.forEach(System.out::println);
    }

}
