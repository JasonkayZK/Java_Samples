package top.jasonkayzk.app;

import top.jasonkayzk.core.Pool;
import top.jasonkayzk.core.SimpleThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 手写线程池测试类
 *
 * @author zk
 */
public class SimpleThreadPoolTest {

    private static AtomicInteger res;

    public static void main(String[] args) throws Exception {
        res = new AtomicInteger(0);

        // 构建一个只有10个线程的线程池
        Pool pool = new SimpleThreadPool(10);
        Thread.sleep(1000);

        // 放500个任务进去, 让线程池进行消费
        for (int i = 1; i < 101; i++) {
            int finalI = i;
            pool.execute(() -> res.getAndAdd(finalI));
        }

        // 移除2个工作者
//        pool.removeWorker(2);
//        System.out.println("线程池大小:" + pool.poolSize());

        // 添加5个工作者
//        pool.addWorker(5);
//        System.out.println("线程池大小:" + pool.poolSize());

        // 验证线程池的消费完任务停止以及不等任务队列清空就停止任务
//        System.out.println("停止线程池");
//        pool.shutDown();
        System.out.println("强行停止线程池");
        pool.shutDownNow();

        System.out.println(res);
    }

}
