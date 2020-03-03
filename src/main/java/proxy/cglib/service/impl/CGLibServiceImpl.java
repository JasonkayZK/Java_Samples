package proxy.cglib.service.impl;

/**
 * 需要被代理的类，不需要实现顶层接口!!
 */
public class CGLibServiceImpl {

    public void goHome() {
        System.out.println("============Go Home============");
    }

    public void gotoSchool() {
        System.out.println("===========Go to school============");
    }

    public void oneday() {
        goHome();
        gotoSchool();
    }

    public final void onedayFinal() {
        goHome();
        gotoSchool();
    }
}
