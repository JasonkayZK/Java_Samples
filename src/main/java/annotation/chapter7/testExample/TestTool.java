package annotation.chapter7.testExample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestTool {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method[] methods = NoBug.class.getDeclaredMethods();

        //用来记录测试产生的 log 信息
        StringBuilder log = new StringBuilder();
        // 记录异常的次数
        int errornum = 0;

        // 通过反射生成一个测试对象
        NoBug testObj = (NoBug)NoBug.class.getConstructor().newInstance();

        for (Method m : methods) {
            // 只有被 @MyTest标注过的方法才进行测试
            if (m.isAnnotationPresent(MyTest.class)) {
                try {
                    m.setAccessible(true);
                    m.invoke(testObj, null);
                } catch (Exception e) {
                    //e.printStackTrace();
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    //记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    //记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }
        log.append(NoBug.class.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");

        // 生成测试报告
        System.out.println(log.toString());
    }
}
