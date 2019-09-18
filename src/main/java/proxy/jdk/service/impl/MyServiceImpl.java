package proxy.jdk.service.impl;

import proxy.jdk.service.MyService;

/**
 * 需要被代理的类，实现了顶层接口，非必须!!
 */
public class MyServiceImpl implements MyService {
    @Override
    public void gotoSchool() {
        System.out.println("gotoSchool");
    }
    @Override
    public void gotoWork() {
        System.out.println("gotoWork");
    }
    @Override
    public void oneDay() {
        gotoSchool();
        gotoWork();
    }
    @Override
    public final void oneDayFinal() {
        gotoSchool();
        gotoWork();
    }
}
