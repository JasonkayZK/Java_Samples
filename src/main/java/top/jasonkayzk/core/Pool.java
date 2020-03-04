package top.jasonkayzk.core;

import java.util.concurrent.Executor;

/**
 * 线程池定级接口
 *
 * @author zk
 */
public interface Pool extends Executor {

    /**
     * 添加任务(并非执行)
     *
     * @param runnable 任务
     */
    @Override
    void execute(Runnable runnable);

    /**
     * 停止线程池(让线程执行完任务在停止)
     */
    void shutDown();

    /**
     * 添加工作者
     *
     * @param num 添加工作者数量
     */
    void addWorker(int num);

    /**
     * 移除工作者
     *
     * @param num 移除工作者数量
     */
    void removeWorker(int num);

    /**
     * 获取线程池大小
     *
     * @return 当前线程池大小
     */
    int poolSize();

    /**
     * 强转停止线程池(不管是否有任务,都停止)
     */
    void shutDownNow();
}
