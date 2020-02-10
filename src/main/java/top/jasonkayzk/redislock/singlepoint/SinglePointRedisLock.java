package top.jasonkayzk.redislock.singlepoint;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * 单点Redis分布式锁
 * <p>
 * 未实现: 可重入, 键值过期等问题
 *
 * @author zk
 */
public class SinglePointRedisLock {

    /**
     * 锁键
     */
    private final String LOCK_KEY = "redis_lock";

    /**
     * 锁过期时间
     */
    protected final long internalLockLeaseTime = 30000;

    /**
     * 获取锁的超时时间
     */
    private final long TIMEOUT = 999999;

    /**
     * 加锁
     *
     * @param id 锁Id
     * @return 是否加锁成功
     */
    public boolean lock(String id) {
        try (Jedis jedis = new Jedis("127.0.0.1", 6379, 0)) {
            long start = System.currentTimeMillis();

            // SET命令的参数
            SetParams params = SetParams.setParams().nx().px(internalLockLeaseTime);

            for (; ; ) {
                // SET命令返回OK ，则证明获取锁成功
                String lock = jedis.set(LOCK_KEY, id, params);
                if ("OK".equals(lock)) {
                    return true;
                }

                // 否则循环等待，在timeout时间内仍未获取到锁，则获取失败
                long l = System.currentTimeMillis() - start;
                if (l >= TIMEOUT) {
                    return false;
                }

                // 模拟自旋锁
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 解锁
     *
     * @param id 锁Id
     * @return 是否成功解锁
     */
    public boolean unlock(String id) {
        try (Jedis jedis = new Jedis("127.0.0.1", 6379, 0)) {
            String script =
                    "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                            "   return redis.call('del',KEYS[1]) " +
                            "else" +
                            "   return 0 " +
                            "end";

            // 使用jedis.eval执行Lua脚本, 保证解锁的原子性
            Object result = jedis.eval(script, Collections.singletonList(LOCK_KEY),
                    Collections.singletonList(id));
            return "1".equals(result.toString());
        }
    }

}
