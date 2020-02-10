package top.jasonkayzk.redislock.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Redisson可重入锁测试
 *
 * @author zk
 */
public class RedissonReentrantLockTest {

    private int count = 0;

    private static final String LOCK_KEY = "redis_lock";

    /**
     * 锁过期时间
     */
    protected static final long INTERNAL_LOCK_LEASE_TIME = 30000;

    private static final RedissonClient client;

    static {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        client = Redisson.create(config);
    }

    public static void main(String[] args) throws InterruptedException {
        new RedissonReentrantLockTest().test();
    }

    public void test() throws InterruptedException {
        var clientCount = 1000;

        var latch = new CountDownLatch(clientCount);

        // 创建client大小的连接池
        var executorService = Executors.newFixedThreadPool(clientCount);

        var start = System.currentTimeMillis();

        for (var i = 0; i < clientCount; ++i) {
            executorService.execute(() -> {
                RLock lock = null;
                try {
                    lock = client.getLock(LOCK_KEY);
                    lock.lock(INTERNAL_LOCK_LEASE_TIME, TimeUnit.MILLISECONDS);
                    count++;
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
                latch.countDown();
            });
        }

        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(String.format("执行线程数:{%s},总耗时:{%s},count数为:{%s}", clientCount, end - start, count));
        executorService.shutdown();
        client.shutdown();
    }

}
