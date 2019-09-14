package reflection.chapter8.settings;

import reflection.chapter8.settings.service.Service1;
import reflection.chapter8.settings.service.Service2;

/**
 * 不使用反射时, 需要修改源代码, 并重新编译!!!
 */
public class CommonDemo {

    public static void main(String[] args) {
        // new Service1().doService1();

        // 想要使用service2, 必须修改源码!
        new Service2().doService2();
    }


}
