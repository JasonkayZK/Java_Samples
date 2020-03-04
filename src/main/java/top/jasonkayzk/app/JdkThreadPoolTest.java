package top.jasonkayzk.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过JDK提供的线程池计算1~100求和
 *
 * @author zk
 */
public class JdkThreadPoolTest {

    private static AtomicInteger res;

    public static void main(String[] args) throws InterruptedException {
        res = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i < 101; i++) {
            int finalI = i;
            executorService.execute(() -> res.getAndAdd(finalI));
        }

        executorService.shutdown();
        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("结束了！");
                break;
            }
            Thread.sleep(200);
        }
        System.out.println(res);
    }

}
