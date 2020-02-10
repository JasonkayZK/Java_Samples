package top.jasonkayzk.redislock.singlepoint;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单节点Redis分布式锁测试类
 *
 * @author zk
 */
public class SinglePointRedisLockTest {

    SinglePointRedisLock redisLock = new SinglePointRedisLock();

    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        new SinglePointRedisLockTest().test();
    }

    public void test() throws InterruptedException {
        int clientCount = 1000;

        CountDownLatch latch = new CountDownLatch(clientCount);

        // 创建client大小的连接池
        ExecutorService executorService = Executors.newFixedThreadPool(clientCount);

        long start = System.currentTimeMillis();

        for (var i = 0; i < clientCount; ++i) {
            executorService.execute(() -> {
                //通过Snowflake算法获取唯一的ID字符串
                UUID id = UUID.randomUUID();
                try {
                    redisLock.lock(id.toString());
                    count++;
                } finally {
                    redisLock.unlock(id.toString());
                }
                latch.countDown();
            });
        }

        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(String.format("执行线程数:{%s},总耗时:{%s},count数为:{%s}", clientCount, end - start, count));
        executorService.shutdown();
    }

}
